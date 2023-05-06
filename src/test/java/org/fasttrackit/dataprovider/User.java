package org.fasttrackit.dataprovider;

public class User {
    private final String username;
    private final String password;
    private final String expectedGreetingsMsg;
    private final String defaultGreetingsMgs = "Hello guest!";
    private String errorMsg = "";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.expectedGreetingsMsg = "Hi " + username + "!";
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedGreetingsMsg() {
        return expectedGreetingsMsg;
    }

    public String getDefaultGreetingsMgs() {
        return defaultGreetingsMgs;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "Test run with: " + username;
    }
}
