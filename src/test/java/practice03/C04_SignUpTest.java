package practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_SignUpTest extends TestBase {

    @Test
    void test01() {

        Faker faker = new Faker();

        // 1) 'https://automationexercise.com' adresine gidin
        driver.get("https://automationexercise.com");

        // 2) Sayfaya girildigini dogrulayin
        Assertions.assertEquals("Automation Exercise", driver.getTitle());
        Assertions.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());

        // 3) "Signup / Login" butonuna TIKLAYIN
        WebElement signUpLoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLoginButton.click();


        // 4) "Signup / Login" sayfasina girildigini dogrulayin
        Assertions.assertTrue(driver.getTitle()
                .contains("Automation Exercise - Signup / Login"), "Login Test FAILED");

        Assertions.assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());

        // 5) "New User Signup!" Name ve Email Address gir
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        nameTextBox.sendKeys("Ali Can");
        emailTextBox.sendKeys("alican35@alican.com");

        // 6) "Signup" buttonuna TIKLA
        WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUpButton.click();;

        // 7) "ENTER ACCOUNT INFORMATION" bilgilerini gir
        // Mr.
        driver.findElement(By.cssSelector("#id_gender1")).click();

        // Password
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");

        // Date of Bird (15 April 2000)
        WebElement day = driver.findElement(By.cssSelector("#days"));
        WebElement month = driver.findElement(By.cssSelector("#months"));
        WebElement year = driver.findElement(By.cssSelector("#years"));

        selectVisibleText(day, "15");
        selectVisibleText(month, "April");
        selectVisibleText(year, "2000");

        // 8) "Sign up for our newsletter!" onay kutusunu seçin.
        driver.findElement(By.cssSelector("#newsletter")).click();

        // 9) "Receive special offers from our partners!" onay kutusunu seçin.
        driver.findElement(By.cssSelector("#optin")).click();

        // 10) "ADDRESS INFORMATION" bilgilerini gir
        // First Name
        WebElement firstNameTextBox = driver.findElement(By.cssSelector("#first_name"));
        firstNameTextBox.sendKeys(faker.name().firstName());

        // Last Name
        WebElement lastNameTextBox = driver.findElement(By.cssSelector("#last_name"));
        lastNameTextBox.sendKeys(faker.name().lastName());

        // Address
        WebElement addressTextBox = driver.findElement(By.cssSelector("#address1"));
        addressTextBox.sendKeys(faker.address().fullAddress());

        // Country
        WebElement countrySelect = driver.findElement(By.cssSelector("#country"));
        selectIndex(countrySelect, 2);

        // State
        WebElement stateTextBox= driver.findElement(By.cssSelector("#state"));
        stateTextBox.sendKeys(faker.address().state());

        // City
        WebElement cityTextBox= driver.findElement(By.cssSelector("#city"));
        cityTextBox.sendKeys(faker.address().city());

        // Zip Code
        WebElement zipCodeTextBox= driver.findElement(By.cssSelector("#zipcode"));
        zipCodeTextBox.sendKeys(faker.address().zipCode());

        // Mobile Number
        WebElement mobileNumberTextBox= driver.findElement(By.cssSelector("#mobile_number"));
        mobileNumberTextBox.sendKeys(faker.phoneNumber().cellPhone());

        // Create Account
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // 11) Hesap olusturuldugunu dogrula
        Assertions.assertEquals("https://automationexercise.com/account_created", driver.getCurrentUrl());
    }
}
