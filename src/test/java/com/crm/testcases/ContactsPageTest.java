package com.crm.testcases;

import com.crm.base.BaseTest;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
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
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
        homePage = loginPage.clickLoginBtn();

    }

    @Test
    public void verifyThatuserCanOpenContactsPage() {
        contactsPage = homePage.openContactsPage();
        Assert.assertEquals(contactsPage.verifyContactsTextOnContactsPage(), "Contacts");
    }

    @Test
    public void verifyNewContact(){
        contactsPage = homePage.clickNewContactSubMenu();
        Assert.assertTrue(contactsPage.verifyThatContactInformationLabelIsDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
