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

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyPageTitleTest() {
        String pageTitle = loginPage.getPageTitle();
        Assert.assertEquals(pageTitle, "#1 Free CRM software in the cloud for sales and service");
    }

    @Test
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateCrmLogo();
        Assert.assertTrue(flag);
    }

    @Test
    public void loginTest() {
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        homePage = loginPage.clickLoginBtn();
        boolean flag = homePage.verifyUsernameLable();
        Assert.assertTrue(flag);
        homePage.clickLogoutButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
