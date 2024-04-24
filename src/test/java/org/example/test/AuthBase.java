package org.example.test;

import org.example.model.AccountData;

public class AuthBase {

    protected final AccountData accountData = new AccountData();

    public AuthBase() {
        accountData.setUsername("LudwigAndreas");
        accountData.setPassword("xnG^xWkX4aV");
        accountData.setFirstName("Ludwig");
        accountData.setLastName("Andreas");
    }

    public AuthBase(AccountData accountData) {
        this.accountData.setUsername(accountData.getUsername());
        this.accountData.setPassword(accountData.getPassword());
        this.accountData.setFirstName(accountData.getFirstName());
        this.accountData.setLastName(accountData.getLastName());
    }

    public AccountData getAccountData() {
        return accountData;
    }
}
