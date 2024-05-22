package org.example.test;

import org.example.ApplicationManager;
import org.example.model.AccountData;
import org.example.settings.Settings;


public class AuthBase extends TestBase {

    protected static final AccountData accountData = new AccountData();

    public AuthBase() {
        super();
        accountData.setUsername(Settings.getLogin());
        accountData.setPassword(Settings.getPassword());
        accountData.setFirstName("Ludwig");
        accountData.setLastName("Andreas");
    }

    public void setUp() {
//        TestBase.setUpManager();
        if (manager.toLogin().isLoggedIn()) {
            if (manager.toLogin().isLoggedIn(accountData.getUsername())) {
                return;
            }
            manager.toLogin().logout();
        }
        manager.toLogin().login(accountData);
    }
    public static void tearDown() {
        manager.toLogin().logout();
        TestBase.tearDownManager();
    }

    public AccountData getAccountData() {
        return accountData;
    }
}
