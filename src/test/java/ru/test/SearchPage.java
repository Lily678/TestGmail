package ru.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;
    @FindBy(className = "gb_Df")
    private WebElement seachfield;


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public MailHomePage inputText() {
        seachfield.sendKeys("Филинин Илья");
        seachfield.sendKeys(Keys.RETURN);
        return new MailHomePage(driver);
    }
}









