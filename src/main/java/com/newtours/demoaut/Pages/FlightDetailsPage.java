package com.newtours.demoaut.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="passCount")
    private WebElement passengersDropDown;

    @FindBy(name="findFlights")
    private WebElement submitButton;

    public FlightDetailsPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String numberOfPax)
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersDropDown));
        Select select=new Select(passengersDropDown);
        select.selectByValue(numberOfPax);
    }

    public void goToFindFlightsPage()
    {
        this.submitButton.click();
    }


}
