package steps;
import pages.CalcPage;
import org.junit.*;
import io.qameta.allure.Step;
public class CalcSteps {

    @Step("проверили что появился заголовок на странице - {titleName}")
    public void checkTitle(String titleName){
        new CalcPage().checkTitleOfPage(titleName);
    }

    @Step("выбрали валюту - {currency}")
    public void selectCurrency(String currency){
        new CalcPage().selectCurrency(currency);
    }
    @Step("Выбрали опцию - {0} и установили ей значение - {1}")
    public void setOption(String option, String valueOfOption){
        new CalcPage().setOptions(option,valueOfOption);
    }
    @Step("установили срок на {0} месяцев")
    public void selectPeriod(String option){
        new CalcPage().selectPeriod(option);
    }
    @Step("установили чекбокс - {itemName}")
    public void setUpCheckBoxes(String itemName){
        new CalcPage().setUpCheckBox(itemName);
    }
    @Step("проверили ставку - {rate}")
    public void checkRate(String rate){
        new CalcPage().checkRate(rate);
    }
    @Step("проверили начисление - {earning}")
    public void checkEarning(String earning){
        new CalcPage().checkEarning(earning);
    }
    @Step("проверили пополнение - {repl}")
    public void checkReplenish(String repl){
        new CalcPage().checkReplenishment(repl);
    }
    @Step("проверили результат к снятию - {result}")
    public void checkResult(String result){
        new CalcPage().checkResult(result);
    }

}
