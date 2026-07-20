package ElectronicGames;

public class Transaction {

    private static double allBalancePlayer() {
        double total = 0;
        for (Player play : Player.getPlayers()) {
            total += play.getBalance();
        }
        return total;
    }

    private static double allBalanceGames() {
        double total = 0;
        for (Game game : Game.getAllGames()) {
            total += game.getPrice();
        }
        return total;
    }

    private static double allBalanceAll() {
        return allBalancePlayer() + allBalanceGames();
    }

    public static void calculateTotalSales(Action actionType) {
        if (actionType.equals(Action.PLAYERS)) {
            System.out.println(allBalancePlayer());
        } else if (actionType.equals(Action.GAMES)) {
            System.out.println(allBalanceGames());
        } else if (actionType.equals(Action.ALL)) {
            System.out.println(allBalanceAll());
        }
    }

    public static double calculateTotalSales() {
        return allBalanceAll();
    }
}