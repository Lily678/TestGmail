package ru.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailHomePage {
    private SearchPage seachfield;

    public MailHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        seachfield = new SearchPage(driver);
    }

    @FindBy(css =".T-I-KE")
    private WebElement newmailbutton;

    public SearchPage getSeachfield() {
        return seachfield;
    }

    public WebElement getNewmailbutton() {
        return newmailbutton;
    }
}


