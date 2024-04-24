package org.example.test;

import org.example.model.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginTest() {
        manager.navigationHelper().openUrl();
        manager.setWindowSize();
        AccountData user = new AccountData(
                "LudwigAndreas",
                "xnG^xWkX4aV",
                "Ludwig",
                "Andreas");
        manager.toLogin().login(user);

        Assert.assertTrue(manager.toLogin().isLogged(user));
    }
}
