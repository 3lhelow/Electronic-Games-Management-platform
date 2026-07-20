package ElectronicGames;

import java.util.ArrayList;

public class Game implements Purchasable {
    private String name;
    private double price;
    private float evaluation;
    private Company company;

    private boolean isAvailable;
    private static ArrayList<Game> allGames = new ArrayList<>();

    public Game(String name, double price, Company company, boolean isAvailable, float evaluation) {
        this.name = name;
        this.price = price;
        this.company = company;
        this.isAvailable = isAvailable;

        Game.allGames.add(this);

        if (evaluation < 1 || evaluation > 5) {
            System.out.println("The rating should be from 1 to 5.");
            this.evaluation = 0; // Default value for invalid evaluation
        } else {
            this.evaluation = evaluation;
        }
    }

    public static void displayAllGames() {
        System.out.println(" --- Display Game --- ");

        int arraySize = allGames.size();
        for (int i = 0; i < arraySize; i++) {
            System.out.println("game: " + (i+1));
            System.out.println("- name: " + allGames.get(i).getName());
            System.out.println("- price: " + allGames.get(i).getPrice());
            System.out.println("- company: " + allGames.get(i).getCompany().getName());
            System.out.println("- isAvailable: " + allGames.get(i).isAvailable());
            System.out.println("- evaluation: " + allGames.get(i).getEvaluation());
            System.out.println();
        }
    }

    @Override
    public void purchase(Player player) {
        if (player.getBalance() >= price) {
            player.addGame(this);
            player.deductBalance(this.price);
            System.out.println("You have successfully purchased " + name);
        } else {
            System.out.println("Insufficient balance to purchase " + name);
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Company getCompany() {
        return company;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public static ArrayList<Game> getAllGames() {
        return allGames;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", evaluation=" + evaluation +
                ", company=" + company.getName() +
                '}';
    }

}