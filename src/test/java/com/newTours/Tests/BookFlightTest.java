package com.newTours.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.demoaut.Pages.FindFlightPage;
import com.newtours.demoaut.Pages.FlightConfirmationPage;
import com.newtours.demoaut.Pages.FlightDetailsPage;
import com.newtours.demoaut.Pages.RegistrationConfirmationPage;
import com.newtours.demoaut.Pages.RegistrationPage;
import com.tests.BaseTest;

public class BookFlightTest extends BaseTest {

    private String expectedPrice;
    private String noOfPassengers;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setUpParameters(String noOfPassengers, String expectedPrice)
    {
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void registrationPage()
    {
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.gotoRegistrationPage();
        registrationPage.enterUserNameDetails("selenium","docker");
        registrationPage.enterUserCredentails("selenium","docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmation()
    {
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.gotToFlightsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    public void flightDetailsPage()
    {
        FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightsPage();

    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage()
    {
        FindFlightPage findFlightPage=new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage()
    {
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrice();
        Assert.assertEquals(expectedPrice,actualPrice);
        flightConfirmationPage.signoff();

    }

}
