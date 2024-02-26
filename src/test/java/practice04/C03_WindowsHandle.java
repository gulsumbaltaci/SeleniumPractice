package practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_WindowsHandle extends TestBase {
    @Test
    void test() {

        // Web sayfasına git https://allovercommerce.com/
        driver.get("https://allovercommerce.com/");

        // Sayfaya girildiği doğrula
        Assertions.assertEquals("Allover Commerce", driver.getTitle(), "HATA VAR");
        Assertions.assertEquals("https://allovercommerce.com/", driver.getCurrentUrl(), "HATA VAR");

        // Register butonu tıkla
        driver.findElement(By.xpath("//a[@class='register inline-type']")).click();
        waitForSecond(3);

        //become a vendor
        driver.findElement(By.partialLinkText("Become a Vendor")).click();
        waitForSecond(3);


        // Handle Değerini al
        String allOverCommerceHandle = driver.getWindowHandle();
        System.out.println(allOverCommerceHandle);

        // https://www.fakemail.net/ sayfasına geç
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.fakemail.net/");
        String fakeMailHandle = driver.getWindowHandle();

        // Mail adresi al
        String emailAdres = driver.findElement(By.xpath("//span[@id='email']")).getText();
        System.out.println(emailAdres);
        waitForSecond(2);

        // https://allovercommerce.com/ sayfasına geç
        driver.switchTo().window(allOverCommerceHandle);
        waitForSecond(2);

        // mail adresini yapıştır
        driver.findElement(By.cssSelector("#user_email")).sendKeys(emailAdres, Keys.TAB);
        waitForSecond(3);

        // Mail adresine kod gonderildi metni
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mailOnay = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".wcfm-message.email_verification_message.wcfm-success")));
        System.out.println(mailOnay.getText());
        Assertions.assertTrue(mailOnay.getText().contains(emailAdres));

        // https://www.fakemail.net/ sayfasına geç
        driver.switchTo().window(fakeMailHandle);

        waitForSecond(3);
        driver.navigate().refresh();

        waitForSecond(5);
        // En son gönderilen maile tıklıyor
        driver.findElement(By.cssSelector(".from")).click();
        waitForSecond(2);

        // iframe gir
        driver.switchTo().frame(1);
        waitForSecond(3);

        // maille gelen codu al
        String verificationCode = driver.findElement(By.tagName("b")).getText();
        System.out.println(verificationCode);

        // https://allovercommerce.com/ sayfasına geç
        driver.switchTo().window(allOverCommerceHandle);

        // doğrulama kodu gönder
        driver.findElement(By.xpath("//input[@name=\"wcfm_email_verified_input\"]"))
                .sendKeys(verificationCode);

        //password girisi
        WebElement passwordTextBox= driver.findElement(By.xpath("//input[@id='passoword']"));
        passwordTextBox.sendKeys("Deneme123?");

        //confirm password girisi
        WebElement confirmPasswordTextBox= driver.findElement(By.xpath("//input[@id='confirm_pwd']"));
        confirmPasswordTextBox.sendKeys("Deneme123?");

        //register butonuna tikla
        //driver.findElement(By.xpath("//input[@name='save-data']")).click();

    }
}
