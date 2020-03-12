package tests;

import utilities.BrowserFactory;
import utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args)throws Exception {
        testChrome();
        Thread.sleep(3000);
        testFirefox();
        Thread.sleep(3000);
        testSafari();
    }
    public static void testChrome(){
        WebDriver driver= BrowserFactory.createADriver("chrome");
        driver.get("http://google.com");
        driver.manage().window().maximize();

        String google=driver.getTitle();

        driver.get("http://etsy.com");

        String etsy=driver.getTitle();
        driver.navigate().back();

        String googleTitle2=driver.getTitle();
        StringUtility.checkEquality(google,googleTitle2);

        driver.navigate().forward();

        String etsyTitle2=driver.getTitle();
        StringUtility.checkEquality(etsy,etsyTitle2);

        driver.quit();


    }

    public static void testFirefox(){

        WebDriver driver= BrowserFactory.createADriver("firefox");
        driver.get("http://google.com");
        driver.manage().window().maximize();
        String google = driver.getTitle();
        driver.get("http://etsy.com");
        String etsy = driver.getTitle();
        driver.navigate().back();

        String googleTitle2 = driver.getTitle();
        StringUtility.checkEquality(google,googleTitle2);
        driver.navigate().forward();

        String etsyTitle2 = driver.getTitle();
        StringUtility.checkEquality(etsy,etsyTitle2);

        driver.quit();
    }

    public static void testSafari(){
        WebDriver driver = BrowserFactory.createADriver("safari");
        driver.get("http://google.com");
        driver.manage().window().maximize();
        String google = driver.getTitle();
        driver.get("http://etsy.com");
        String etsy = driver.getTitle();
        driver.navigate().back();

        String googleTitle2 = driver.getTitle();
        StringUtility.checkEquality(google,googleTitle2);
        driver.navigate().forward();

        String etsyTitle2 = driver.getTitle();
        StringUtility.checkEquality(etsy,etsyTitle2);

        driver.quit();
    }



}