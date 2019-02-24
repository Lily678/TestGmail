package ru.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {
    @FindBy(css = "textarea[name='to']")
    private WebElement receiver;
    @FindBy(css ="input[name='subjectbox']")
    private WebElement topic;
    @FindBy(css = "div[aria-label='Тело письма']")
    private WebElement textbody;

    public NewMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getReceiver() {
        return receiver;
    }

    public WebElement getTopic() {
        return topic;
    }

    public WebElement getTextbody() {
        return textbody;
    }
}
