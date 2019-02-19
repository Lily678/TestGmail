package ru.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {
    private WebDriver driver;
    @FindBy(css = "textarea[name='to']")
    private WebElement receiver;
    @FindBy(css ="input[name='subjectbox']")
    private WebElement topic;
    @FindBy(css = "div[aria-label='Тело письма']")
    private WebElement textbody;


    public NewMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public MailHomePage clickButtonMail (int resultmail) throws InterruptedException {
        receiver.sendKeys("ilya.filinin@simbirsoft.com");
        topic.sendKeys("Тестовое задание. Ибатулина");
        textbody.sendKeys(String.valueOf(resultmail));
        String keysPressed =  Keys.chord(Keys.CONTROL, Keys.RETURN);
        textbody.sendKeys(keysPressed) ;
        Thread.sleep(5000);
        MailHomePage mailHomePage = new MailHomePage((WebDriver) driver);
        return mailHomePage;
    }

}
