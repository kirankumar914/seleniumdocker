package com.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        //browser=>chrome/firefox
        //HUB_HOST=> localhost/10.0.1.3/hostname

        String host ="localhost";
        DesiredCapabilities dc= DesiredCapabilities.chrome();

        if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
        {
            dc=DesiredCapabilities.firefox();
        }

        if(System.getProperty("HUB_HOST")!=null)
        {
            host=System.getProperty("HUB_HOST");
        }

        String completeUrl= "http://" + host + ":4444/wd/hub";
        this.driver= new RemoteWebDriver(new URL(completeUrl),dc);

        System.setProperty("webdriver.chrome.driver","chromedriver_win32\\chromedriver.exe");
        this.driver=new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void closeTheBrowser()
    {
        this.driver.quit();
    }
}

