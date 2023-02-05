package csv;

import domain.Market;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    private static final CsvUtil instance = new CsvUtil();

    private CsvUtil() {}

    public static CsvUtil getInstance() {
        return instance;
    }

    public List<Market> makeMarkets(File csv) throws IOException {
        return readCsv(csv);
    }

    private List<Market> readCsv(File csv) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            return parseLine(br);
        }
    }

    private List<Market> parseLine(BufferedReader br) throws IOException {
        List<Market> markets = new ArrayList<>();
        boolean first = true;
        String line;
        while ((line = br.readLine()) != null) {
            // 컬럼 명은 버린다.
            if(first) {
                first = false;
                continue;
            }
            markets.add(BuildMarket(line));
        }
        return markets;
    }

    private Market BuildMarket(String line) {
        String[] split = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        for (int i = 0; i < 38; i++) {
            split[i] = split[i].replace("\"", "");
        }
        Market market = Market.builder()
            .id(Long.parseLong(split[0]))
            .businessName(split[1])
            .branchName(split[2])
            .commercialMainClassificationCode(split[3])
            .commercialMainBusinessName(split[4])
            .commercialSubMainClassificationCode(split[5])
            .commercialSubMainBusinessName(split[6])
            .commercialSubClassificationCode(split[7])
            .commercialSubBusinessName(split[8])
            .standardIndustryClassificationCode(split[9])
            .standardIndustryClassificationName(split[10])
            .sidCode(split[11])
            .sidName(split[12])
            .sigCode(split[13])
            .sigName(split[14])
            .administrativeDongCode(split[15])
            .administrativeDongName(split[16])
            .courtCode(split[17])
            .courtName(split[18])
            .lotCode(split[19])
            .platClassificationCode(split[20])
            .platClassificationName(split[21])
            .lotMainAddress(split[22])
            .lotSubAddress(split[23])
            .lotAddress(split[24])
            .roadNameCode(split[25])
            .roadName(split[26])
            .buildingMainAddress(split[27])
            .buildingSubAddress(split[28])
            .buildingManagementNumber(split[29])
            .buildingName(split[30])
            .roadAddress(split[31])
            .oldZipCode(split[32])
            .newZipCode(split[33])
            .dongInfo(split[34])
            .floorInfo(split[35])
            .roomInfo(split[36])
            .longitude(Double.parseDouble(split[37]))
            .latitude(Double.parseDouble(split[38]))
            .build();
        return market;
    }

    public File[] getFiles() {
        String path = "./data";
        String extension = "csv";
        File directory = new File(path);
        return directory.listFiles((dir, name) -> name.endsWith(extension));
    }
}
