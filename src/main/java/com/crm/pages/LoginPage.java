package com.crm.pages;
import com.crm.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

   @FindBy(name ="username")
    WebElement username;

    @FindBy(name ="password")
    WebElement password;

    @FindBy(xpath = "//input[@type= 'submit']")
    WebElement loginBtn;
//
//    @FindBy(xpath ="//img[@class = 'img-responsive']")
//    WebElement crmLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }




}
