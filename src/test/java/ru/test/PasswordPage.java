package ru.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PasswordPage {
    private WebDriver driver;
    @FindBy(className = "whsOnd")
    private WebElement password;
    @FindBy(className = "RveJvd")
    private WebElement passlast;

    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public MailHomePage startMail()
        {
            password.sendKeys("007700gbc");
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            passlast.click();
            return new MailHomePage(driver);
        }
    }

