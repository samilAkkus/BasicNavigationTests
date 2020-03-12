package utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = BrowserFactory.createADriver("chrome");

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/",
                "https://walmart.com" ,
                "https://westelm.com/");

        List<String> titles = new ArrayList<>();

        for (String url : urls) {

            driver.get(url);
            titles.add(driver.getTitle().toLowerCase().replace(" ", "").trim());

            Thread.sleep(2000);

        }
        for (int i = 0; i < urls.size() ; i++) {

            if(urls.get(i).contains(titles.get(i))){

                System.out.println("TEST PASSED");
            }else {

                System.out.println("TEST FAILED");
            }

        }

        driver.quit();
    }
}
