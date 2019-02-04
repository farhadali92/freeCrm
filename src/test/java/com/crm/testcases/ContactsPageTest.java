package com.crm.testcases;

import com.crm.base.BaseTest;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private ContactsPage contactsPage;
    String sheetName = "contacts";

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

    }

    @Test
    public void verifyNewContact(){
        contactsPage = homePage.clickNewContactSubMenu();
        Assert.assertTrue(contactsPage.verifyThatContactInformationLabelIsDisplayed());
        Assert.assertTrue(contactsPage.verifyThatContactInformationLabelIsDisplayed());
    }

    @DataProvider
    public Object[][] getCrmTestData(){
        Object data[][]=TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getCrmTestData")
    public void verifyThatuserCanEnterNewContact(String title, String fname, String lname, String comp_name){
        contactsPage = homePage.clickNewContactSubMenu();
        contactsPage.createNewContact(title,fname,lname,comp_name);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
