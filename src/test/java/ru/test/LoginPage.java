package ru.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    @FindBy(id = "identifierId")
    private WebElement userName;
    @FindBy(className = "RveJvd")
    private WebElement pass;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public PasswordPage addLogin () throws InterruptedException {
        userName.sendKeys("testsofttest2@gmail.com");
        pass.click();
        Thread.sleep(2000);
        return new PasswordPage(driver);
    }
}

