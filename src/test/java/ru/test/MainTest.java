package ru.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MainTest {
    private static WebDriver driver = null;
    String BaseURL, NodeURL;

    @Before
    public void before() throws Exception {
        BaseURL = "http://www.google.com";
        NodeURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capa = DesiredCapabilities.chrome();
        capa.setBrowserName("chrome");
        capa.setPlatform(Platform.ANY);
        driver = new RemoteWebDriver(new URL(NodeURL), capa);
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }


    @Test
    public void main() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PasswordPage passwordPage = loginPage.addLogin();
        MailHomePage mailHomePage = passwordPage.startMail();
        MailHomePage searchpage = mailHomePage.searchPage();
        int resultmail = searchpage.countMail();
        System.out.println(resultmail);
        NewMessagePage newMessagePage = searchpage.clickNewMailButton();
        newMessagePage.clickButtonMail(resultmail);

    }
    @AfterClass
    public static void closeSession(){
        driver.close();
    }

}


        

