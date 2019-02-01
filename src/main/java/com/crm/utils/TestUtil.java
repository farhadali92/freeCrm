package com.crm.utils;

import com.crm.base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestUtil extends BaseTest {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static void switchToPanel() {
        driver.switchTo().frame("mainpanel");
    }
}
