package com.crm.testcases;

import com.crm.base.BaseTest;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
        initialisation();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyPageTitleTest(){
        String pageTitle = loginPage.getPageTitle();
        Assert.assertEquals(pageTitle,"#1 Free CRM software in the cloud for sales and service" );
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
