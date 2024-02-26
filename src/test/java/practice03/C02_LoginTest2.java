package practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_LoginTest2 extends TestBase {

    @Test
    void test01() {

        orangeHRMlogin();

        // 4) Admin butonunun görüdüğünü doğrula
        WebElement adminButton = driver
                .findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name"));
        Assertions.assertTrue(adminButton.isDisplayed());

        // 5) Sayfadan çıkıç yap
        WebElement logoutButton1 = driver
                .findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
        logoutButton1.click();

        WebElement logoutButton2 = driver
                .findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
        logoutButton2.click();

        // 6) Sayfadan Çıkış Yapıldığını Doğrula

        Assertions.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
    }
}

