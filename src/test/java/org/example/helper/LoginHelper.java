package org.example.helper;

import org.example.ApplicationManager;
import org.example.model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData accountData) {
        manager.navigationHelper().wayToLogin();
        driver.findElement(By.id("username")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    }

    public boolean isLoggedIn() {
        try {
            return driver.findElement(By.linkText("Sign out")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        try {
            return driver.findElement(By.linkText(username)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void logout() {
        driver.findElement(By.linkText("Sign out")).click();
    }
}
