package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import steps.BaseSteps;
import  org.junit.*;
import java.util.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.*;
public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class='service']")
    List<WebElement> mainServices ;

    public void selectMainServicesCalc(String itemName){
        for (WebElement item : mainServices ){

            if (item.findElement(By.xpath(".//div[@class='service__title-text']")).getText().equalsIgnoreCase(itemName)){
                wait.until(ExpectedConditions.visibilityOf(item.findElement(By.xpath(".//a[@class='service__title-action']"))));
                wait.until(ExpectedConditions.elementToBeClickable(item.findElement(By.xpath(".//a[@class='service__title-action']")))).click();
                return;
            }
        }
        Assert.fail("Не найден элемент коллеции - " + itemName);
    }

}
