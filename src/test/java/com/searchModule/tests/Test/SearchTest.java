package com.searchModule.tests.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SearchModules.SearchPage;
import com.tests.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchTest(String keyword)
    {
        SearchPage searchPage=new SearchPage(driver);
        searchPage.gotTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size=searchPage.getResult();
        Assert.assertTrue(size>0);
    }

}
