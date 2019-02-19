package ru.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailHomePage {
    private SearchPage seachfield;

    private WebDriver driver = null;

    public MailHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        seachfield = new SearchPage(driver);
    }
    public MailHomePage searchPage(){
        return seachfield.inputText();
    }
    public int countMail(){
        List<WebElement> selectElement = driver.findElements(By.cssSelector("#\\3a 7j tr.zA"));
        return selectElement.size();
    }

    public NewMessagePage clickNewMailButton() throws InterruptedException {
        newmailbutton.click();
        Thread.sleep(5000);
        return new NewMessagePage(driver);
    }

    @FindBy(css =".T-I-KE")
    private WebElement newmailbutton;
}


