package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends BaseTest {


    @FindBy(xpath = "//td[@class = 'datacardtitle' and contains(text(),'Contacts') ]")
    WebElement contactsTextOnContactsPage;

    @FindBy(xpath = "//a[@title ='New Contact']")
    WebElement subMenuNewContact;

    @FindBy(xpath = "//legend[@class ='fieldset' and contains(text(),'Contact Information')]")
    WebElement contactInformationLabel;


    ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyContactsTextOnContactsPage() {
        return contactsTextOnContactsPage.getText();
    }

    public void openContactsMenuAndSelectSubMenuWithLableNewContacts() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsTextOnContactsPage).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(subMenuNewContact));
        subMenuNewContact.click();


    }

    public boolean verifyThatContactInformationLabelIsDisplayed() {
        driver.switchTo().frame("processFrame");
        return contactInformationLabel.isDisplayed();
    }

}
