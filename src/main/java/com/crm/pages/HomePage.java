package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(xpath = "//td[contains(text(),'User: farhad ali')]")
    WebElement user;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getUserName(){
        return user.getText();
    }
}
