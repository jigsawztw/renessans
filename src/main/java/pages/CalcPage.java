package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;
import  org.junit.*;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.*;
public class CalcPage extends BasePage{


    @FindBy(xpath = "//h2[@class='calculator-block__title block-title']")
    public WebElement titleOfPage;

    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    public List<WebElement> currencies;

    @FindBy(xpath = "//div[@data-property='amount']")
    public WebElement sumOption;


    WebElement selectElem = BaseSteps.getDriver().findElement(By.tagName("select"));

    @FindBy(xpath = "//div[@class='calculator__check-row']//span[@class='calculator__check-text']")
    public List<WebElement> checkBoxes;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement calcRate;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement earned;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement calcResult;


    @FindBy(xpath = "//div[@data-property='replenish']")
    public WebElement replenishOption;

    public void checkTitleOfPage(String itemName){
        Assert.assertEquals("Ожидаемый заголовок страницы не совпадает с фактическим",itemName ,titleOfPage.getText());
    }

    public void selectCurrency(String itemName){
        selectCollectionItem(itemName,currencies);}


    public void setOptions(String option, String valueOfOption){
        switch(option){
            case "Сумма":
                sumOption.findElement(By.xpath(".//input")).sendKeys(valueOfOption);
                break;
            case "Ежемесячное пополнение" :
                replenishOption.findElement(By.xpath(".//input")).sendKeys(valueOfOption);
                break;
        }
    }

    public void selectPeriod(String valueOfOption){
        Select select = new Select(selectElem);
        select.selectByValue(valueOfOption);
    }

    public void setUpCheckBox(String itemName){
        try {
            Thread.sleep(1000);     //если убрать не успевает получить обновленные данные после установки опций и не пройдет проверку
        }
        catch (InterruptedException e){}
        for (WebElement item : checkBoxes ){
            wait.until(ExpectedConditions.visibilityOf(item));
            wait.until(ExpectedConditions.elementToBeClickable(item));
            if (item.getText().equalsIgnoreCase(itemName)){
                item.findElement(By.xpath(".//parent::*/parent::*//div[@class='jq-checkbox calculator__check']")).click();
                try {
                    Thread.sleep(1000); //если убрать не успевает получить обновленные данные после установки опций и не пройдет проверку
                }
                catch (InterruptedException e){}
                return;
            }
        }
        Assert.fail("Не найден элемент коллеции - " + itemName);
    }


    public void checkRate(String rate){
        wait.until(ExpectedConditions.visibilityOf(calcRate));
        Assert.assertEquals("фактическая ставка не соответствует ожидаемой",rate , calcRate.getText());
    }
    public void checkEarning(String earning){
       wait.until(ExpectedConditions.visibilityOf(earned));
        Assert.assertEquals("Фактическое начисление не соответствует ожидаемому", earning, earned.getText());
    }
    public void checkReplenishment(String repl){
        wait.until(ExpectedConditions.visibilityOf(replenish));
        Assert.assertEquals("Фактическое пополнение не соответствует ожидаемому",repl , replenish.getText());
    }
    public void checkResult(String res){
        wait.until(ExpectedConditions.visibilityOf(calcResult));
        Assert.assertEquals("Фактический  результат к снятию не соответствует ожидаемому",res , calcResult.getText());
    }


}



