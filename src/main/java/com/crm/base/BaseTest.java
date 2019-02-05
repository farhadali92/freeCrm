package com.crm.base;

import com.crm.utils.TestUtil;
import com.crm.utils.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static Properties prop;
    protected static String projectPath = System.getProperty("user.dir");
    protected static EventFiringWebDriver e_driver;
    protected static WebEventListener eventListener;

    public BaseTest() {
        try {
            prop = new Properties();

            FileInputStream inputStream = new FileInputStream(projectPath
                    + "\\src\\main\\java\\com\\crm\\config\\config.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void initialisation() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

}
