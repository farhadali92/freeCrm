package com.crm.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;

    public BaseTest() {
        try{
            prop = new Properties();
            FileInputStream inputStream = new FileInputStream("D:\\FA Automation Projects\\freeCrmTest"
                +"\\src\\main\\java\\com\\crm\\config\\config.properties");
            prop.load(inputStream);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialisation(){
            String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));
    }

}
