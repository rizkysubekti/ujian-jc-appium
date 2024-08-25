package com.juaracoding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CatatanKeuanganTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.chad.financialrecord.MainActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void tearDown() {
        delay(3);
        driver.quit();
    }

    // Fitur Pemasukan(1)
    @Test
    public void testAddIncome1() {
        delay(10);
        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/incomeAmount").sendKeys("4000000");
        driver.findElementById("com.chad.financialrecord:id/incomeCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Gaji']").click();
        driver.findElementById("com.chad.financialrecord:id/saveButton").click();
        delay(3);
    }

    // Fitur Pemasukan(2)
    @Test
    public void testAddIncome2() {
        delay(10);
        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/incomeAmount").sendKeys("1000000");
        driver.findElementById("com.chad.financialrecord:id/incomeCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Hadiah']").click();
        driver.findElementById("com.chad.financialrecord:id/saveButton").click();
        delay(3);
    }

    // Fitur Pengeluaran(1)
    @Test
    public void testAddExpense1() {
        delay(10);
        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/incomeAmount").sendKeys("500000");
        driver.findElementById("com.chad.financialrecord:id/incomeCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Belanja']").click();
        driver.findElementById("com.chad.financialrecord:id/saveButton").click();
        delay(3);
    }

    // Fitur Pengeluaran(2)
    @Test
    public void testAddExpense2() {
        delay(10);
        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/incomeAmount").sendKeys("250000");
        driver.findElementById("com.chad.financialrecord:id/incomeCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Transport']").click();
        driver.findElementById("com.chad.financialrecord:id/saveButton").click();
        delay(3);
    }

    // Fitur Pengeluaran(3)
    @Test
    public void testAddExpense3() {
        delay(10);
        driver.findElementById("com.chad.financialrecord:id/fab_add").click();
        delay(3);
        driver.findElementById("com.chad.financialrecord:id/incomeAmount").sendKeys("100000");
        driver.findElementById("com.chad.financialrecord:id/incomeCategory").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Hiburan']").click();
        driver.findElementById("com.chad.financialrecord:id/saveButton").click();
        delay(3);
    }

    // Fitur Cek Saldo
    @Test
    public void testCheckBalance() {
        delay(10);
        String balance = driver.findElementById("com.chad.financialrecord:id/tv_saldo").getText();
        System.out.println("Saldo Saat Ini: " + balance);
        Assert.assertTrue(balance.contains("4150000")); // Verifikasi saldo yang diharapkan
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
