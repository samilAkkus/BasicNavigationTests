package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TestCases1_5 {

    private WebDriver driver;
    private By wrongDob = By.xpath("//small[text()='The date of birth is not valid']");
    private By cPlus = By.xpath("//input[@id='inlineCheckbox1']/following-sibling::label");
    private By java = By.xpath("//input[@id='inlineCheckbox2']/following-sibling::label");
    private By javaS = By.xpath("//input[@id='inlineCheckbox3']/following-sibling::label");
    private By firstName = By.cssSelector("[name='firstname']");
    private By lastName = By.cssSelector("[name='lastname']");
    private By userName = By.cssSelector("[name='username']");
    private By eMail = By.cssSelector("[name='email']");
    private By password = By.cssSelector("[name='password']");
    private By phone = By.cssSelector("[name='phone']");
    private By gender = By.cssSelector("[value='male']");
    private By birthday = By.cssSelector("[name='birthday']");
    private By department = By.cssSelector("[name='department']");
    private By job = By.cssSelector("[name='job_title']");
    private By javaButton = By.xpath("//input[@id='inlineCheckbox2']");
    private By sign = By.id("wooden_spoon");
    private By message = By.xpath("//h4");

    @Test
    public void testCase5(){

        driver.findElement(firstName).sendKeys("Samil");
        BrowserUtils.wait(2);
        driver.findElement(lastName).sendKeys("Gorbacov");
        BrowserUtils.wait(2);
        driver.findElement(userName).sendKeys("Adigeg");
        BrowserUtils.wait(2);
        driver.findElement(eMail).sendKeys("anan123@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(password).sendKeys("cokguclu");
        BrowserUtils.wait(2);
        driver.findElement(phone).sendKeys("123-459-1234");
        BrowserUtils.wait(2);
        driver.findElement(gender).click();
        BrowserUtils.wait(2);
        driver.findElement(birthday).sendKeys("03/02/1992");
        BrowserUtils.wait(2);
        WebElement pass1 = driver.findElement(department);
        Select s1 = new Select(pass1);
        s1.selectByVisibleText("Department of Engineering");
        BrowserUtils.wait(2);
        WebElement pass2 = driver.findElement(job);
        Select s2 = new Select(pass2);
        s2.selectByVisibleText("Manager");
        BrowserUtils.wait(2);
        driver.findElement(javaButton).click();
        BrowserUtils.wait(2);
        driver.findElement(sign).click();

        BrowserUtils.wait(5);

        Assert.assertTrue(driver.findElement(message).isDisplayed());



    }




    @Test
    public void testCase4(){

        driver.findElement(lastName).sendKeys("f");

        BrowserUtils.wait(3);

        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).isDisplayed());

    }



    @Test
    public void testCase3(){

        driver.findElement(firstName).sendKeys("f");

        BrowserUtils.wait(3);

        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).isDisplayed());

    }


    @Test
    public void testCase2(){

        Assert.assertTrue(driver.findElement(cPlus).isDisplayed());
        Assert.assertTrue(driver.findElement(java).isDisplayed());
        Assert.assertTrue(driver.findElement(javaS).isDisplayed());


    }


    @Test
    public void testCase1(){

    driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob", Keys.ENTER);

    WebElement dobElement = driver.findElement(wrongDob);

        Assert.assertTrue(dobElement.isDisplayed());

        BrowserUtils.wait(3);
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

        driver.findElement(By.linkText("Registration Form")).click();

        BrowserUtils.wait(4);
    }
}
