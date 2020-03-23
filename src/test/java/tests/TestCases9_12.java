package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

    public class TestCases9_12 {

    WebDriver driver;

    @Test
    public void testCase9(){

        driver.findElement(By.xpath("//div[@id='content']//a[text()='200']")).click();

        BrowserUtils.wait(3);

        String expected = "This page returned a 200 status code";

        String actual = driver.findElement(By.cssSelector("div[class='example'] > p")).getText();

        Assert.assertTrue(actual.contains(expected));

    }

        @Test
        public void testCase10(){

            driver.findElement(By.xpath("//div[@id='content']//a[text()='301']")).click();

            BrowserUtils.wait(3);

            String expected = "This page returned a 301 status code";

            String actual = driver.findElement(By.cssSelector("div[class='example'] > p")).getText();

            Assert.assertTrue(actual.contains(expected));

        }

        @Test
        public void testCase11(){

            driver.findElement(By.xpath("//div[@id='content']//a[text()='404']")).click();

            BrowserUtils.wait(3);

            String expected = "This page returned a 404 status code";

            String actual = driver.findElement(By.cssSelector("div[class='example'] > p")).getText();

            Assert.assertTrue(actual.contains(expected));

        }

        @Test
        public void testCase12(){

            driver.findElement(By.xpath("//div[@id='content']//a[text()='500']")).click();

            BrowserUtils.wait(3);

            String expected = "This page returned a 500 status code";

            String actual = driver.findElement(By.cssSelector("div[class='example'] > p")).getText();

            Assert.assertTrue(actual.contains(expected));

        }













    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.createADriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();

        BrowserUtils.wait(3);

        driver.findElement(By.linkText("Status Codes")).click();

        BrowserUtils.wait(4);
    }
}
