package com.crm.pages;

import com.crm.base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

   @FindBy(name = "username")
    WebElement username;

    @FindBy(name ="password")
    WebElement password;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    WebElement loginBtn;

    @FindBy(xpath ="//img[@class = 'img-responsive']")
    WebElement crmLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCrmLogo(){
        return crmLogo.isDisplayed();
    }

    public void enterUsername(String un){
        username.sendKeys(un);
    }
    public void enterPassword(String pw){
        password.sendKeys(pw);
    }
    public HomePage clickLoginBtn(){
        //loginBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);
        return new HomePage();
    }



}
