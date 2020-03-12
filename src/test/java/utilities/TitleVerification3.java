package utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) throws Exception {



        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com" ,
                "https://westelm.com/");


        for (String url : urls) {
            WebDriver driver = BrowserFactory.createADriver("chrome");
            driver.get(url);

            Thread.sleep(2000);
            driver.close();

        }


    }
}
