package com.crm.testcases;

import com.crm.base.BaseTest;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;


    HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        loginPage = new LoginPage();
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        homePage = loginPage.clickLoginBtn();
    }

    @Test
    public void verifyThatUserCanLoginAndCheckHomePageTitleTest() {

        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals("CRMPRO",homePageTitle);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

