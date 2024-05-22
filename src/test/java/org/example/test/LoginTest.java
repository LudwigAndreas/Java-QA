package org.example.test;

import org.example.model.AccountData;
import org.example.settings.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTest extends TestBase {

    @Test
    public void loginWithValidDataTest() {
        manager.navigationHelper().openUrl();
        manager.setWindowSize();
        AccountData user = new AccountData(
                Settings.getLogin(),
                Settings.getPassword(),
                Settings.getFirstName(),
                Settings.getLastName());
        manager.toLogin().login(user);

        Assertions.assertTrue(manager.toLogin().isLoggedIn(user.getUsername()));
    }

    @Test
    public void loginWithInvalidDataTest() {
        manager.navigationHelper().openUrl();
        manager.setWindowSize();
        AccountData user = new AccountData(
                Settings.getLogin() + "1",
                Settings.getPassword(),
                Settings.getFirstName(),
                Settings.getLastName());
        manager.toLogin().login(user);

        Assertions.assertFalse(manager.toLogin().isLoggedIn(user.getUsername()));
    }
}
