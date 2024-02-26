package practice04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_RegisterTest extends TestBase {
    @Test
    void loginTest() {

        Faker faker = new Faker();

        driver.get("https://www.trvlcar.com/");

        // Title: TrvlCar | Premium Car Rental
        // URL: https://www.trvlcar.com/

        Assertions.assertEquals("https://www.trvlcar.com/", driver.getCurrentUrl(), "HATA VAR");
        Assertions.assertEquals("TrvlCar | Premium Car Rental", driver.getTitle(), "HATA VAR");

        WebElement registerButton = driver.findElement(By.xpath("//a[@href=\"/auth\"]"));
        registerButton.click();

        driver.findElement(By.xpath("//button[@data-rr-ui-event-key=\"register\"]")).click();

        WebElement firstNameTextBox = driver.findElement(By.cssSelector("input[name='firstName']"));
        firstNameTextBox.sendKeys(faker.name().firstName());

        WebElement lastNameTextBox = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastNameTextBox.sendKeys(faker.name().lastName());

        WebElement phoneNumberTextBox = driver.findElement(By.cssSelector("input[name=\"phoneNumber\"]"));
        phoneNumberTextBox.click();
        phoneNumberTextBox.sendKeys("1234567890");

        WebElement adresTextBox = driver.findElement(By.xpath("//input[@name='address']"));
        adresTextBox.sendKeys(faker.address().fullAddress());

        WebElement zipCodeTextBox = driver.findElement(By.cssSelector("input[name='zipCode']"));
        zipCodeTextBox.sendKeys(faker.address().zipCode());

        WebElement emailTextBox = driver.findElement(By.xpath("(//input[@name=\"email\"])[2]"));
        emailTextBox.sendKeys("veli@can.com");

        WebElement passwordTextBox = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
        passwordTextBox.sendKeys("Deneme1?");

        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPasswordTextBox.sendKeys("Deneme1?");

        driver.findElement(By.xpath("//button[.='Register']")).click();

        waitForSecond(5);

        // //div[contains(text(), "ARANACAK METiN")]
        WebElement uyariMesaji = driver.findElement(By.xpath("//div[contains(text(), \"You are registered successfully\")]"));
        Assertions.assertTrue(uyariMesaji.getText().contains("You are registered successfully"), "HATA VAR");
    }
}
