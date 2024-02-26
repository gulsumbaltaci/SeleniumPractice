package practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05 extends TestBase {

    // https://demo.guru99.com/test/radio.html
   // checkbox1 ve checkbox3 seçili değilse seçin
   // checkbox1 ve checkbox3 seçili olduğunu test edein
   // checkbox2 elementinin seçili olmadığını test edin


    @Test
    public void test01() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3 seçili değilse seçin

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        if (!checkbox3.isSelected()){
            checkbox3.click();
        }
        //Thread.sleep(3000);
        // checkbox1 ve checkbox3 seçili olduğunu test edin
        Assertions.assertTrue(checkbox1.isSelected(),"Checkbox1 Secilmedi");
        Assertions.assertTrue(checkbox3.isSelected(), "Checkbox3 Secilmedi");

        // checkbox2 elementinin seçili olmadığını test edin
        //Assertions.assertFalse(checkbox2.isSelected());
        Assertions.assertTrue(!checkbox2.isSelected(),"Mesaj");

    }
}
