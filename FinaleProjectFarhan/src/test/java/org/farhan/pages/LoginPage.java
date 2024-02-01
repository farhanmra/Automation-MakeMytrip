package org.farhan.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    int seconds = 5;
    Duration duration = Duration.ofSeconds(seconds);
    WebDriverWait wait = new WebDriverWait(driver,duration);

   @FindBy(xpath = "//div[@id=\"loginTrigger\"]")
   private WebElement buttonLogin;
   @FindBy(xpath = "//input[@id=\"username\"]")
   private WebElement emailTextBox;
   @FindBy(xpath = "//button[@data-cy=\"continueBtn\"]")
   private WebElement buttonContinue;
   @FindBy(xpath="//input[@id=\"password\"]")
   private WebElement passTextBox;
   @FindBy(xpath = "//button[@data-cy=\"login\"]")
   private WebElement buttonLoginform;
   @FindBy(xpath = "//span[@data-cy=\"modalClose\"]")
   private WebElement buttonClose;
   @FindBy(xpath="//span[@class=\"chUserInfoName latoBold\"]")
   private WebElement lableProfile;
   @FindBy(xpath="//input[@id=\"otp\"]")
   private WebElement otpTextBox;
   @FindBy(xpath = "//p[@class=\"validity font12 redText appendTop5 makeFlex\"]")
   private WebElement messageOtpFailed;
   @FindBy(xpath="//span[@class=\"validity font12 redText appendTop5 makeFlex\"]")
   private WebElement messageSecOtpFailed;
   @FindBy(xpath = "//button[@data-cy=\"verifyAndCreate\"]")
   private WebElement buttonVerifyOtp;
   @FindBy(xpath="//input[@data-cy=\"enterOtp\"]")
   private WebElement otpSexTextBox;



   public WebElement getMessgeOtp(){
       return messageOtpFailed;
   }
   public WebElement getSecMessageOtp(){
       return messageSecOtpFailed;
   }


    public void loginPageMyTrip(){
        buttonLogin.click();
        emailTextBox.clear();
        emailTextBox.sendKeys("farhanrivha146@gmail.com");
        buttonContinue.click();
        try {
            WebElement boxPass = wait.until(ExpectedConditions.visibilityOf(passTextBox));
            boxPass.sendKeys("Admin@12345");
            buttonLoginform.click();
            otpTextBox.sendKeys("12333");
            buttonLoginform.click();
            String ActualLableProfile= getMessgeOtp().getText();
            String ExpectedLableProfile= "Incorrect OTP! Please enter the OTP delivered to you.";
            Assert.assertEquals(ActualLableProfile,ExpectedLableProfile,"Tidak Sesuai Message Error yang muncul");
        } catch (TimeoutException e) {
            System.out.println("Tidak ada password muncul");
        }
        finally {
            otpSexTextBox.sendKeys("12333");
            buttonVerifyOtp.click();
            String ActualLableProfile= getSecMessageOtp().getText();
            String ExpectedLableProfile= "Incorrect OTP Entered. Please try again.";
            Assert.assertEquals(ActualLableProfile,ExpectedLableProfile,"Tidak Sesuai Message Error yang muncul");
        }

    }
}
