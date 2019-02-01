package com.crm.pages;

import com.crm.base.BaseTest;
import com.crm.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {


    @FindBy(xpath = "//a[contains(@href,'logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//td[contains(text(),'farhad ali')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[@title = 'New Contact']")
    WebElement subMenuNewContact;

    HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLogoutButton() {
        TestUtil.switchToPanel();
        logoutBtn.click();
    }

    public boolean verifyUsernameLable() {
        TestUtil.switchToPanel();
        return userNameLabel.isDisplayed();
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ContactsPage openContactsPage() {
        TestUtil.switchToPanel();
        contactsLink.click();
        return new ContactsPage();
    }

    public ContactsPage clickNewContactSubMenu(){
        Actions action = new Actions(driver);
        TestUtil.switchToPanel();
        action.moveToElement(contactsLink).build().perform();
        subMenuNewContact.click();
        return new ContactsPage();

    }
}

