package ElectronicGames;

import java.util.ArrayList;
import java.util.Arrays;

public class PlatformManager extends User {
    private static final ArrayList<String> ADMINS;

    static {
        ADMINS = new ArrayList<>(Arrays.asList("Mohamed", "Ahmed", "Ali", "Rem"));
    }

    public PlatformManager(String name, String email, String password) {
        super(name, email, password);

        if ( !(ADMINS.contains(name)) )
            System.out.println("You are not an admin !");
    }

    public static void addCompany(String name, String email, String password, String country) {
        Company.getAllInstances().add(new Company(name, email, password, country));
    }

    public static int numberOfCompany() {
        return Company.getAllInstances().size();
    }

    public void displayAvailableGames() {

        for (Game game : Game.getAllGames()) {
            if (game.isAvailable()) {
                System.out.println(game);
            }
        }
    }

    @Override
    public void addGame(Game game) {
        Game.getAllGames().add(game);
    }

    @Override
    public void displayGame() {
        System.out.println(getName() + "'s Owned Games: ");
        for (Game game : Game.getAllGames()) {
            System.out.println("- " + game);
        }
    }
}