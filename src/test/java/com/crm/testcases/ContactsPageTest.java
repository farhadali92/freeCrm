package com.crm.testcases;

import com.crm.base.BaseTest;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private ContactsPage contactsPage;

    ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialisation();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyThatuserCanOpenContactsPage() {
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        homePage = loginPage.clickLoginBtn();
        contactsPage = homePage.openContactsPage();
        Assert.assertEquals(contactsPage.verifyContactsTextOnContactsPage(), "Contacts");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
