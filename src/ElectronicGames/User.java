package ElectronicGames;

public abstract class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        checkValidation();
    }

    private boolean isNameValid() {
        return name != null && name.length() > 2;
    }

    private boolean isEmailValid() {
        if (email == null) {
            return false;
        }
        // Regular expression for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private boolean isPasswordValid() {
        if (password == null || password.length() < 4) {
            return false;
        }

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        // Check for at least one digit
        boolean hasDigit = password.matches(".*\\d.*");
        // Check for at least one special character
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    private boolean isValid() {
        return isNameValid() && isEmailValid() && isPasswordValid();
    }

    public final void checkValidation() {
        if (!(isValid())) {
            System.out.println("Validation failed:");
            if (!(isNameValid())) {
                System.out.println("- Name is not valid.");
            }
            if (!(isEmailValid())) {
                System.out.println("- Email is not valid.");
            }
            if (!(isPasswordValid())) {
                System.out.println("- Password is not valid.");
            }
        }
    }

    /// You can search for the company's name, player name, or game name
    public static void search(String name) {
        searchForGames(name);
        searchForCompany(name);
        searchForPlayer(name);
    }

    public static void checkArray(Action className) {
        switch (className) {
            case PLAYERS:
                if (Player.getPlayers().isEmpty())
                    System.out.println("There are no player available !!");
                break;
            case GAMES:
                if (Game.getAllGames().isEmpty())
                    System.out.println("There are no games currently, create an object of the Game class and set isAvailable to true");
                break;
            case COMPANIES:
                if (Company.getAllInstances().isEmpty())
                    System.out.println("There are no companies currently !!");
                break;
        }
    }

    public static void searchForGames(String name) {
        checkArray(Action.GAMES);

        boolean found = false;

        for (Game game : Game.getAllGames()) {
            if (game.getName().equals(name)) {
                found = true;
                if (game.isAvailable()) {
                    System.out.println("The game is found and available for you");
                } else {
                    System.out.println("The game is found but not available now");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("The game is not found!");
        }
    }

    public static void searchForCompany(String name) {
        checkArray(Action.COMPANIES);

        for (Company company : Company.getAllInstances()) {
            if (company.getName().equals(name)) {
                System.out.println("The company is already, the location of the company is in " + company.getCountry());
            } else {
                System.out.println("The company is not found!");
            }
            break;
        }
    }

    public static void searchForPlayer(String name) {
        checkArray(Action.PLAYERS);

        for (Player player : Player.getPlayers()) {
            if (player.getName().equals(name)) {
                System.out.println("The player is already here There are some games that this player plays: " + player.getOwnedGamesName());
            } else {
                System.out.println("The player is not found!");
            }
            break;
        }
    }

    public abstract void addGame(Game game);

    public abstract void displayGame();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}