package org.farhan.tests;


import org.farhan.pages.LoginPage;
import org.farhan.pages.FlightPage;
import org.farhan.pages.ScheduleFlightPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    FlightPage flightPage;
    ScheduleFlightPage scheduleFLightPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupPages(){
        flightPage = new FlightPage(driver);
        scheduleFLightPage = new ScheduleFlightPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void validationBangkoktoSingapura() throws InterruptedException {
        flightPage.setUpFormCity();
        flightPage.setUpToCity();
        flightPage.setUpDepature();
        flightPage.setUpReturn();
        scheduleFLightPage.scheduleFlight();
    }

    @Test(priority = 2)
    public void checkFilterFlight() {
       scheduleFLightPage.filterFlight();
    }

    @Test(priority = 3)
    public void checkValidationErrorOTP(){
        loginPage.loginPageMyTrip();
    }
}
