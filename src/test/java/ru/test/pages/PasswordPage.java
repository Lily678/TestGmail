package ru.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    @FindBy(className = "whsOnd")
    private WebElement password;
    @FindBy(className = "RveJvd")
    private WebElement next;

    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getNext() {
        return next;
    }
}

