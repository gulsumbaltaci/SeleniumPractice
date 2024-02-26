package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSE2 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement searchTextBox = (WebElement) jse
                .executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");

        waitForSecond(5);

        searchTextBox.sendKeys("BU KADAR");

        // #shodow-root-open: (Gölge) Normal methodlar ile
        // web elemente ulaşmamız çok zordur. JSE kullanacağız.

        //Bu sayfada ki searcBox'a ait dom gorunuyor fakat locate almak istedigimizde "Shadow-root" sebebiyle locate
       //alamiyoruz. Bunu asmak icin; Dom uzerine sag click/copy/copy js path yapiyoruz
       //Sonra; JavascriptExecutor objesinin executeScript methodu ile locate alabiliriz.
       //yapistirdigimiz path onune return ifadesini eklemeyi unutmayalim


    }
}
