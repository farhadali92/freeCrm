package com.crm.pages;

import com.crm.base.BaseTest;
import com.crm.utils.TestUtil;
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

    public void clickLogoutButton() {
            //driver.switchTo().frame("mainpanel");
            logoutBtn.click();
    }

    public boolean verifyUsernameLable() {
        //driver.switchTo().frame("mainpanel");
        TestUtil.switchToPanel("mainpanel");
        return userNameLabel.isDisplayed();
    }

}

