package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_HelloSeleniumEdge {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(3000);
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://selenium.dev");
        Thread.sleep(3000);
        driver.quit();





















    }


}
