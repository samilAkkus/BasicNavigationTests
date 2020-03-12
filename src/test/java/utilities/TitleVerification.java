package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) throws Exception {

        WebDriver driver= BrowserFactory.createADriver("chrome");

        List<String>title=new ArrayList<>();

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");



        for (String url : urls) {

            driver.get(url);
            title.add(driver.getTitle());

            if(driver.getCurrentUrl().startsWith("http://practice.cybertekschool.com")){

                System.out.println("TEST PASSED");

                System.out.println(driver.getTitle());
            }else {

                System.out.println("TEST FAILED");
            }
            Thread.sleep(2000);

        }

        for (int i = 0; i < title.size()-1 ; i++) {

            StringUtility.checkEquality(title.get(i),title.get(i+1));

        }

        driver.quit();
    }
}
