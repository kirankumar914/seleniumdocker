package com.SearchModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchboxTxt;

    @FindBy(id="search_button_homepage")
    private WebElement searchbtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void gotTo()
    {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String searchText)
    {
        this.wait.until(ExpectedConditions.visibilityOf(searchboxTxt));
         this.searchboxTxt.sendKeys(searchText);
         this.searchbtn.click();
    }

    public void goToVideos()
    {
        this.wait.until(ExpectedConditions.visibilityOf(videosLink));
        this.videosLink.click();
    }

    public int getResult()
    {
        By by= By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }
}
