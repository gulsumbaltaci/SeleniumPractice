package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_FirstTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
    //Amazon web sayfasına git

    driver.get("https://www.ebay.com");
    driver.navigate().to("https://www.ebay.com");

    //Sayfanın title test et, ekrana yazdır

     String expectedData = "Electronics, Cars, Fashion, Collectibles & More | eBay";
     String actualData = driver.getTitle();
     System.out.println("Title = " + driver.getTitle());

     if (actualData.equals(expectedData)){
         System.out.println("test passed");
     }else {
         System.out.println("test failed");
     }

    //Sayfanın Url test et, ekrana yazdır

    System.out.println("URL: " + driver.getCurrentUrl());

    String expectedUrl = "https://www.ebay.com";
    String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }




    }
}
