package org.farhan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.type.IntersectionType;
import java.time.Duration;

public class FlightPage extends BasePage{
    public FlightPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//input[@id=\"fromCity\"]")
    private WebElement fromCity;
    @FindBy(xpath = "//input[@id=\"toCity\"]")
    private WebElement toCity;
    @FindBy(xpath ="//input[@placeholder=\"From\"]")
    private WebElement searchBarFromCity;
    @FindBy(xpath ="//input[@placeholder=\"To\"]")
    private WebElement searchBarToCity;
    @FindBy(xpath = "//li[@class=\"react-autosuggest__suggestion react-autosuggest__suggestion--first\"]")
    private WebElement chooseFirstchoice;
    @FindBy(xpath="//div[@aria-label=\"Wed Feb 14 2024\"]")
    private WebElement chooseDepature;
    @FindBy(xpath = "//div[@aria-label=\"Thu Feb 15 2024\"]")
    private WebElement chooseReturn;
    @FindBy(xpath = "//div[@data-cy=\"returnArea\"]")
    private WebElement openReturn;
    @FindBy(xpath = "//a[contains(text(),\"Search\")]")
    private WebElement buttonSearch;



    public void setUpFormCity() throws InterruptedException {
        fromCity.click();
        searchBarFromCity.click();
        searchBarFromCity.sendKeys("Bangkok");
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        chooseFirstchoice.click();
    }

    public void setUpToCity() throws InterruptedException {
        toCity.click();
        searchBarToCity.click();
        searchBarToCity.sendKeys("Singapura");
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        chooseFirstchoice.click();
    }

    public void setUpDepature(){
        chooseDepature.click();
    }
    public void setUpReturn(){
        openReturn.click();
        chooseReturn.click();
        buttonSearch.click();
    }
}
