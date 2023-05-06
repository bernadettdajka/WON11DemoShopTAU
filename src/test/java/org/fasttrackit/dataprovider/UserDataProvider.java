package org.fasttrackit.dataprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "validUserDataProvider")
    public Object[][] feedUserDataProvider() {
        User beetleUser = new User("beetle", "choochoo");
        User dinoUser = new User("dino", "choochoo");
        User turtleUser = new User("turtle", "choochoo");

        return new Object[][]{
                {beetleUser},
                {dinoUser},
                {turtleUser}
        };
    }

    @DataProvider(name = "invalidUserDataProvider")
    public Object[][] feedInvalidUserDataProvider() {
        User lockedUser = new User("locked", "choochoo");
        lockedUser.setErrorMsg("The user has been locked out.");

        User invalidPassword = new User("beetle", "choochoo1");
        invalidPassword.setErrorMsg("Incorrect username or password!");

        User invalidUser = new User("beatle", "choochoo");
        invalidUser.setErrorMsg("Incorrect username or password!");

        return new Object[][]{
                {lockedUser},
                {invalidUser},
                {invalidPassword}
        };
    }
}
