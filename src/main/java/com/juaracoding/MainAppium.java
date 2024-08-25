package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MainAppium {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","Pixel 2 API 30");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("platformName","Android");
        dc.setCapability("platformVersion","11");
        dc.setCapability("appPackage","com.chad.financialrecord");
        dc.setCapability("appActivity","com.chad.financialrecord.MainActivity");
        dc.setCapability("noReset",true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);

        // Tambah Pemasukan
        driver.findElement(By.id("com.chad.financialrecord:id/fab_add")).click();
        delay(2);

        // Input Nominal
        MobileElement nominalField = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/et_nominal"));
        nominalField.sendKeys("4000000");

        // Pilih Kategori
        driver.findElement(By.id("com.chad.financialrecord:id/sp_kategori")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Gaji']")).click();

        // Simpan Pemasukan
        driver.findElement(By.id("com.chad.financialrecord:id/btn_simpan")).click();
        delay(2);

        // Verifikasi Saldo
        MobileElement result = (MobileElement) driver.findElement(By.id("com.chad.financialrecord:id/tv_saldo"));
        String txtResult = result.getText();
        System.out.println("Saldo saat ini: " + txtResult);

        // Verifikasi apakah saldo bertambah sesuai pemasukan
        if(txtResult.contains("4000000")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // Quit driver
        driver.quit();
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}