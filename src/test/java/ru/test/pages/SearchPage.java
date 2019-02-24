package ru.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    @FindBy(className = "gb_Df")
    private WebElement seachfield;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getSeachfield() {
        return seachfield;
    }
}









