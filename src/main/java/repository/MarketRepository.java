package repository;

import domain.Market;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MarketRepository {

    private final int batchLimit = 4096;

    public int save(Connection connection, List<Market> markets, String table) throws SQLException {
        int totalSave = 0;
        String sql = makeInsertQuery(table);
        try(PreparedStatement pStmt = connection.prepareStatement(sql)) {
            totalSave += setStatement(pStmt, markets);
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
        return totalSave;
    }

    private int setStatement(PreparedStatement pStmt, List<Market> markets) throws SQLException {
        int batchCount = batchLimit, totalBatch = 0;
        for (Market market : markets) {
            pStmt.setLong(1, market.getId());
            pStmt.setString(2, market.getBusinessName());
            pStmt.setString(3, market.getBranchName());
            pStmt.setString(4, market.getCommercialMainClassificationCode());
            pStmt.setString(5, market.getCommercialMainBusinessName());
            pStmt.setString(6, market.getCommercialSubMainClassificationCode());
            pStmt.setString(7, market.getCommercialSubMainBusinessName());
            pStmt.setString(8, market.getCommercialSubClassificationCode());
            pStmt.setString(9, market.getCommercialSubBusinessName());
            pStmt.setString(10, market.getStandardIndustryClassificationCode());
            pStmt.setString(11, market.getStandardIndustryClassificationName());
            pStmt.setString(12, market.getSidCode());
            pStmt.setString(13, market.getSidName());
            pStmt.setString(14, market.getSigCode());
            pStmt.setString(15, market.getSigName());
            pStmt.setString(16, market.getAdministrativeDongCode());
            pStmt.setString(17, market.getAdministrativeDongName());
            pStmt.setString(18, market.getCourtCode());
            pStmt.setString(19, market.getCourtName());
            pStmt.setString(20, market.getLotCode());
            pStmt.setString(21, market.getPlatClassificationCode());
            pStmt.setString(22, market.getPlatClassificationName());
            pStmt.setString(23, market.getLotMainAddress());
            pStmt.setString(24, market.getLotSubAddress());
            pStmt.setString(25, market.getLotAddress());
            pStmt.setString(26, market.getRoadNameCode());
            pStmt.setString(27, market.getRoadName());
            pStmt.setString(28, market.getBuildingMainAddress());
            pStmt.setString(29, market.getBuildingSubAddress());
            pStmt.setString(30, market.getBuildingManagementNumber());
            pStmt.setString(31, market.getBuildingName());
            pStmt.setString(32, market.getRoadAddress());
            pStmt.setString(33, market.getOldZipCode());
            pStmt.setString(34, market.getNewZipCode());
            pStmt.setString(35, market.getDongInfo());
            pStmt.setString(36, market.getFloorInfo());
            pStmt.setString(37, market.getRoomInfo());
            pStmt.setDouble(38, market.getLongitude());
            pStmt.setDouble(39, market.getLatitude());

            pStmt.addBatch();
            if(--batchCount == 0) {
                totalBatch += pStmt.executeBatch().length;
                batchCount = batchLimit;
            }
        }
        totalBatch += pStmt.executeBatch().length;
        System.out.printf("save... %d\n", totalBatch);
        return totalBatch;
    }

    private String makeInsertQuery(String table) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO public.");
        sb.append(table);
        sb.append(" (id, ");
        sb.append("business_name, ");
        sb.append("branch_name, ");
        sb.append("commercial_main_classification_code, ");
        sb.append("commercial_main_business_name, ");
        sb.append("commercial_sub_main_classification_code, ");
        sb.append("commercial_sub_main_business_name, ");
        sb.append("commercial_sub_classification_code, ");
        sb.append("commercial_sub_business_name, ");
        sb.append("standard_industry_classification_code, ");
        sb.append("standard_industry_classification_name, ");
        sb.append("sid_code, ");
        sb.append("sid_name, ");
        sb.append("sig_code, ");
        sb.append("sig_name, ");
        sb.append("administrative_dong_code, ");
        sb.append("administrative_dong_name, ");
        sb.append("court_code, ");
        sb.append("court_name, ");
        sb.append("lot_code, ");
        sb.append("plat_classification_code, ");
        sb.append("plat_classification_name, ");
        sb.append("lot_main_address, ");
        sb.append("lot_sub_address, ");
        sb.append("lot_address, ");
        sb.append("road_name_code, ");
        sb.append("road_name, ");
        sb.append("building_main_address, ");
        sb.append("building_sub_address, ");
        sb.append("building_management_number, ");
        sb.append("building_name, ");
        sb.append("road_address, ");
        sb.append("old_zipcode, ");
        sb.append("new_zipcode, ");
        sb.append("dong_info, ");
        sb.append("floor_info, ");
        sb.append("room_info, ");
        sb.append("longitude, ");
        sb.append("latitude) ");
        sb.append("values (");
        sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return sb.toString();
    }

    public void createTable(Connection connection, String sido) throws SQLException {
        String sql = makeCreateQuery(sido);
        try (Statement st = connection.createStatement()) {
            System.out.println(sql);
            st.execute(sql);
        }
    }

    private String makeCreateQuery(String sido) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(sido);
        sb.append("(id bigint primary key not null, ");
        sb.append("business_name varchar(64), ");
        sb.append("branch_name varchar(64), ");
        sb.append("commercial_main_classification_code char(8), ");
        sb.append("commercial_main_business_name varchar(64), ");
        sb.append("commercial_sub_main_classification_code char(8), ");
        sb.append("commercial_sub_main_business_name varchar(64), ");
        sb.append("commercial_sub_classification_code char(8), ");
        sb.append("commercial_sub_business_name varchar(64), ");
        sb.append("standard_industry_classification_code char(8), ");
        sb.append("standard_industry_classification_name varchar(64), ");
        sb.append("sid_code char(2), ");
        sb.append("sid_name varchar(64), ");
        sb.append("sig_code char(5), ");
        sb.append("sig_name varchar(64), ");
        sb.append("administrative_dong_code char(16), ");
        sb.append("administrative_dong_name varchar(64), ");
        sb.append("court_code char(16), ");
        sb.append("court_name varchar(64), ");
        sb.append("lot_code char(19), ");
        sb.append("plat_classification_code char(8), ");
        sb.append("plat_classification_name varchar(16), ");
        sb.append("lot_main_address varchar(8), ");
        sb.append("lot_sub_address varchar(8), ");
        sb.append("lot_address varchar(64), ");
        sb.append("road_name_code char(12), ");
        sb.append("road_name varchar(64), ");
        sb.append("building_main_address varchar(8), ");
        sb.append("building_sub_address char(4), ");
        sb.append("building_management_number char(25), ");
        sb.append("building_name varchar(64), ");
        sb.append("road_address varchar(64), ");
        sb.append("old_zipcode char(6), ");
        sb.append("new_zipcode char(5), ");
        sb.append("dong_info varchar(64), ");
        sb.append("floor_info varchar(8), ");
        sb.append("room_info varchar(64), ");
        sb.append("longitude float(8), ");
        sb.append("latitude float(8))");
        return sb.toString();
    }
}
