package org.farhan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ScheduleFlightPage extends BasePage{

    public ScheduleFlightPage(WebDriver driver){
        super(driver);
    }
    int seconds = 5;
    Duration duration = Duration.ofSeconds(seconds);
    WebDriverWait wait = new WebDriverWait(driver,duration);

    @FindBy(xpath = "//p[@class=\"font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom\"]")
    private WebElement TitleSchedule;
    @FindBy(xpath = "//p[@class=\"checkboxTitle\" and text()=\" Refundable Fares   \"]")
    private WebElement chekcboxRefrund;
    @FindBy(xpath = "//li[text()=\"Refundable Fares\"]")
    private WebElement labelRefrund;
    @FindBy(xpath="//button[text()=\"OKAY, GOT IT!\"]")
    private WebElement popUp;
    @FindBy(xpath = "(//p[@class=\"intlRtAirlineInfo\"])[1]")
    private WebElement lableDepart;
    @FindBy(xpath = "(//p[@class=\"intlRtAirlineInfo\"])[2]")
    private WebElement lableReturn;

    public WebElement getLabelSchedule(){
        return TitleSchedule;
    }
    public WebElement getLableDepartDate(){
        return lableDepart;
    }
    public WebElement getLableReturnDate(){
        return lableReturn;
    }
    public void scheduleFlight(){
        wait.until(ExpectedConditions.visibilityOf(lableDepart));
        String ExpectedValue="Flights from Bangkok to Singapore, and back";
        String ExpectedValueDepart="Depart Wed, 14 Feb";
        String ExpectedValueReturn="Return Thu, 15 Feb";
        String ActualValue=  getLabelSchedule().getText();
        String DateValueDepart = getLableDepartDate().getText();
        String DateValueReturn = getLableReturnDate().getText();
        String ActualValueDepart = DateValueDepart.substring(DateValueDepart.indexOf("Depart"),DateValueDepart.indexOf("•")).trim();
        String ActualValueReturn = DateValueReturn.substring(DateValueReturn.indexOf("Return"),DateValueReturn.indexOf("•")).trim();
        Assert.assertEquals(ActualValue,ExpectedValue,"Jadwal Penerbangan salah");
        Assert.assertEquals(ActualValueDepart,ExpectedValueDepart,"Jadwal Depart Tanggal salah");
        Assert.assertEquals(ActualValueReturn,ExpectedValueReturn,"Jadwal Return tanggal salah");
    }

    public void filterFlight (){

        try {
            WebElement popUpElement = wait.until(ExpectedConditions.visibilityOf(popUp));
            popUpElement.click();
        } catch (TimeoutException e) {
            System.out.println("Tidak ada pop up muncul");
        }
        wait.until(ExpectedConditions.visibilityOf(chekcboxRefrund));
        chekcboxRefrund.click();
        Assert.assertTrue(chekcboxRefrund.isDisplayed(),"checkbox tidak ditemukan");
        Assert.assertTrue(labelRefrund.isDisplayed(), "Element Tidak ditemukan");
    }

}
