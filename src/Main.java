import ElectronicGames.*;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("mohamed", "mohamed@gemil.com", "Acb15#", 15.6);
        Player player2 = new Player("ahmed", "ahmed@gemil.com", "Acb15#", 10.6);

        Company company1 = new Company("x company", "x@gemil.com", "Acb15#", "EG");
        Company company2 = new Company("y company", "y@gemil.com", "Acb15#", "US");

        PlatformManager.addCompany("test company", "test@gemail.com", "Acb15@", "Eg"); // Repeated 2 (problem)
        Company.displayCompany();
        System.out.println("all companies: " + PlatformManager.numberOfCompany());

        Game game1 = new Game("Xbox", 49.50, company1, true, 4.5F);
        Game game2 = new Game("Xx", 10.50, company1, false, 5F);
        Game game3 = new Game("aha", 60.50, company2, true, 2.4F);

        game2.purchase(player1); // Done
        System.out.println(player1.getBalance()); // 5.1

        player1.addGame(game1);
        player1.addGame(game2);
        player2.addGame(game1);
        player1.playWithFriend(player2, "Xbox");
        User.search("mohamed");

        PlatformManager platformManager = new PlatformManager("Ahmed", "mohamed@gemail.com", "Acb15$");
        platformManager.displayAvailableGames(); // aha && Xbox
        Transaction.calculateTotalSales(Action.PLAYERS); // 26.2
        Transaction.calculateTotalSales(Action.GAMES); // 120.5
        Transaction.calculateTotalSales(Action.ALL); // 146.7
        System.out.println(Transaction.calculateTotalSales()); // 146.7

    }
}