package ru.test.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.test.pages.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private static WebDriver driver;
    private static Properties prop = new Properties();

    @Before
    public void before() throws Exception {
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("config.properties"), "windows-1251"))
        {
            prop.load(inputStreamReader);
        }
        DesiredCapabilities capa = DesiredCapabilities.chrome();
        capa.setBrowserName(prop.getProperty("browser"));
        capa.setPlatform(Platform.ANY);
        driver = new RemoteWebDriver(new URL(prop.getProperty("nodeUrl")), capa);
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void main() throws InterruptedException {
        addLogin();
        addPassword();
        searchMail();
        int resultMail = countMail();
        clickNewMailButton();
        sendMail(resultMail);
    }
    @AfterClass
    public static void closeSession(){
        driver.close();
    }
    public void addLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        WebElement userName = loginPage.getUserName();
        userName.sendKeys(prop.getProperty("login"));
        WebElement pass = loginPage.getPass();
        pass.click();
        Thread.sleep(2000);
    }
    public void addPassword() {
        PasswordPage passwordPage = new PasswordPage(driver);
        WebElement password = passwordPage.getPassword();
        password.sendKeys(System.getProperty("Password"));
        WebElement next = passwordPage.getNext();
        next.click();
    }
    public void searchMail() {
        SearchPage searchPage = new SearchPage(driver);
        WebElement seachField = searchPage.getSeachfield();
        seachField.sendKeys(prop.getProperty("filter"));
        seachField.sendKeys(Keys.RETURN);
    }
    public int countMail() {
        List<WebElement> selectElement = driver.findElements(By.cssSelector("div.av"));
        return selectElement.size();
    }
    public void clickNewMailButton() {
        MailHomePage mailHomePage = new MailHomePage(driver);
        WebElement newMailButton = mailHomePage.getNewmailbutton();
        newMailButton.click();

    }
    public void sendMail(int resultMail) {
        NewMessagePage newMessagePage = new NewMessagePage(driver);
        WebElement receiver = newMessagePage.getReceiver();
        receiver.sendKeys(prop.getProperty("recipient"));
        WebElement topic = newMessagePage.getTopic();
        topic.sendKeys(prop.getProperty("titleEmail"));
        WebElement textBody = newMessagePage.getTextbody();
        textBody.sendKeys(String.valueOf(resultMail));
        String keysPressed =  Keys.chord(Keys.CONTROL, Keys.RETURN);
        textBody.sendKeys(keysPressed) ;
    }
}




        

