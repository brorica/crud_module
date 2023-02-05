package service;

import config.JdbcTemplate;
import csv.CsvUtil;
import domain.Market;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import lombok.NoArgsConstructor;
import repository.MarketRepository;

@NoArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository = new MarketRepository();
    private final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
    private final CsvUtil csvUtil = CsvUtil.getInstance();

    public void saveCsv() {
        try (Connection connection = jdbcTemplate.getConnection()) {
            createTables(connection);
            saveMarket(connection);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTables(Connection connection) throws SQLException {
        String[] sidos = {
            "busan", "chungbug", "chungnam", "daegu", "daejeon",
            "gangwon", "gwangju", "gyeongbug", "gyeonggi", "gyeongnam",
            "incheon", "jeju", "jeonbug", "jeonnam", "sejong",
            "seoul", "ulsan"
        };
        for (String sido : sidos) {
            marketRepository.createTable(connection, sido);
        }
    }

    private void saveMarket(Connection connection) throws IOException, SQLException {
        int totalSave = 0;
        String baseName;
        File[] files = csvUtil.getFiles();
        for (File file : files) {
            baseName = parseBaseName(file);
            System.out.print(baseName + " ");
            List<Market> markets = csvUtil.makeMarkets(file);
            totalSave += marketRepository.save(connection, markets, baseName);
        }
        System.out.printf("total save: %d\n", totalSave);
    }

    private String parseBaseName(File csv) {
        String fileName = csv.getName();
        String[] splits = fileName.split("[.]");
        return splits[0];
    }
}
