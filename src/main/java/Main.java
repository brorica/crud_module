import service.MarketService;

public class Main {

    public static void main(String[] args) {
        MarketService marketService = new MarketService();
        marketService.saveCsv();
    }
}
