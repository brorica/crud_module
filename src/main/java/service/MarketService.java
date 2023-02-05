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
            marketRepository.createTable(connection);
            saveMarket(connection);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMarket(Connection connection) throws IOException, SQLException {
        int totalSave = 0;
        File[] files = csvUtil.getFiles();
        for (File file : files) {
            List<Market> markets = csvUtil.makeMarkets(file);
            System.out.print(file.getName() + " ");
            totalSave += marketRepository.save(connection, markets);
        }
        System.out.printf("total save = %d\n", totalSave);
    }
}
