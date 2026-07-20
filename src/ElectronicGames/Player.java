package ElectronicGames;

import java.util.ArrayList;

public class Player extends User {
    private double balance;

    private static ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Game> ownedGames;

    public Player(String name, String email, String password, double balance) {
        super(name, email, password);

        this.balance = balance;
        this.ownedGames = new ArrayList<>();
        Player.players.add(this);

        if (!(checkBalance())) System.out.println("Your Balance Must Be Greater Than Or Equal $10");
    }

    private boolean checkBalance() {
        return this.balance >= 10;
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

    public void deductBalance(double amount) {
        this.balance -= amount;
    }

    public void playWithFriend(Player yourFriend, String gameName) {
        boolean myGameFound = false;

        for (Game ownedGame : ownedGames) {
            if (ownedGame.getName().equals(gameName)) {
                myGameFound = true;
                break;
            }
        }

        int sizeOfArrayFriendGame = yourFriend.ownedGames.size();
        boolean friendGameFound = false;

        for (int i = 0; i < sizeOfArrayFriendGame; i++) {
            if (yourFriend.ownedGames.get(i).getName().equals(gameName)) {
                friendGameFound = true;
                break;
            }
        }

        if (myGameFound && friendGameFound) {
            System.out.println("Sync successfully, enjoy!");
        } else {
            if (!myGameFound) {
                System.out.println("You do not own the game: " + gameName);
            }
            if (!friendGameFound) {
                System.out.println(yourFriend.getName() + " does not own the game: " + gameName);
            }
        }
    }

    public ArrayList<String> getOwnedGamesName() {
        ArrayList<String> gamesName = new ArrayList<>();

        for (Game game : ownedGames) {
            gamesName.add(game.getName());
        }
        return gamesName;
    }

//    public void searchForGames(String name) {
//        if (Game.getAllGames().isEmpty()) {
//            System.out.println("There are no games currently, create an object of the Game class and set isAvailable to true");
//            return;
//        }
//
//        boolean found = false;
//
//        for (Game game : Game.getAllGames()) {
//            if (game.getName().equals(name)) {
//                found = true;
//                if (game.isAvailable()) {
//                    System.out.println("The game is found and available for you");
//                } else {
//                    System.out.println("The game is found but not available now");
//                }
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("The game is not found!");
//        }
//    }


    public ArrayList<Game> getOwnedGames() {
        return ownedGames;
    }

    public double getBalance() {
        return balance;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }
}