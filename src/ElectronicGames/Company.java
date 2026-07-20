package ElectronicGames;

import java.util.ArrayList;

public class Company extends User {
    private ArrayList<Game> ownedGames;
    private String country;
    private static ArrayList<Company> allInstances = new ArrayList<>();

    public Company(String name, String email, String password, String country) {
        super(name, email, password);

        this.country = country;
        this.ownedGames = new ArrayList<>();

        allInstances.add(this);
    }

    @Override
    public void addGame(Game game) {
        this.ownedGames.add(game);
    }

    @Override
    public void displayGame() {
        System.out.println(getName() + "'s Owned Games: ");
        for (Game game : this.ownedGames) {
            System.out.println("- " + game);
        }
    }

    public int numberOfGames() {
        int counter = 0;

        if (!(this.ownedGames.isEmpty())) {
            int sizeOfArray = this.ownedGames.size();
            for (int i = 0; i < sizeOfArray; i++) {
                counter += i;
            }
        }

        return counter;
    }

    public static void displayCompany() {
        System.out.println(" --- All instances created --- ");
        int arraySize = allInstances.size();
        for (int i = 0; i < arraySize; i++) {
            System.out.println("company: " + (i+1));
            System.out.println("- name: " + allInstances.get(i).getName());
            System.out.println("- email: " + allInstances.get(i).getEmail());
            System.out.println("- country: " + allInstances.get(i).getCountry());
            System.out.println();
        }
    }

    public String getCountry() {
        return country;
    }

    public static ArrayList<Company> getAllInstances() {
        return allInstances;
    }
}