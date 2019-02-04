package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends BaseTest {


    @FindBy(xpath = "//td[@class = 'datacardtitle' and contains(text(),'Contacts') ]")
    WebElement contactsTextOnContactsPage;

    @FindBy(xpath = "//legend[@class ='fieldset' and contains(text(),'Contact Information')]")
    WebElement contactInformationLabel;

    @FindBy(name = "title")
    WebElement contactTitle;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "surname")
    WebElement lastName;

    @FindBy(name = "client_lookup")
    WebElement company;

    @FindBy(xpath = "//input[@type ='submit']")
    WebElement saveBtn;

    ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyContactsTextOnContactsPage() {
        return contactsTextOnContactsPage.getText();
    }

    public boolean verifyThatContactInformationLabelIsDisplayed() {
        return contactInformationLabel.isDisplayed();
    }

    public void createNewContact(String title, String fname, String lname, String companyName) {
        Select select = new Select(contactTitle);
        select.selectByVisibleText(title);
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        company.sendKeys(companyName);
        //saveBtn.click();
    }

}
