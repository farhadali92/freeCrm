package com.crm.pages;

import com.crm.base.BaseTest;
import com.crm.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {


    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//td[contains(text(),'farhad ali')]")
    private WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

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


}

