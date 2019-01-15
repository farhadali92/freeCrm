package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {


    @FindBy(xpath = "//a[contains(@href,'logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//td[contains(text(),'farhad ali')]")
    WebElement userNameLabel;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLogoutButton() {
        return logoutBtn.isDisplayed();

    }

    public boolean verifyUsernameLable() {
        return userNameLabel.isDisplayed();
    }

}

