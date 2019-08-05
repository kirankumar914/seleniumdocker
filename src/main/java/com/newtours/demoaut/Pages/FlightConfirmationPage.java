package com.newtours.demoaut.Pages;

import javax.xml.xpath.XPath;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Confirmation')]")
    private WebElement confirmationHeader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signoffBtn;


    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String getPrice()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmationHeader));
        System.out.println(this.confirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String price=this.prices.get(1).getText();
        return price;
    }

    public void signoff()
    {
        this.signoffBtn.click();
    }
}
