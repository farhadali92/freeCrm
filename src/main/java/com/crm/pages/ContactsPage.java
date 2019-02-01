package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BaseTest {


    @FindBy(xpath = "//td[@class = 'datacardtitle' and contains(text(),'Contacts') ]")
    WebElement contactsTextOnContactsPage;

    @FindBy(xpath = "//legend[@class ='fieldset' and contains(text(),'Contact Information')]")
    WebElement contactInformationLabel;


    ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyContactsTextOnContactsPage() {
        return contactsTextOnContactsPage.getText();
    }

    public boolean verifyThatContactInformationLabelIsDisplayed() {
        return contactInformationLabel.isDisplayed();
    }

}
