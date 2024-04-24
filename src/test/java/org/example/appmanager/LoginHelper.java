package org.example.appmanager;

import org.example.model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void Login(AccountData accountData) {
        manager.Navigate().WayToLogin();
        driver.findElement(By.id("username")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    }
}
