package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    CalcSteps calcSteps = new CalcSteps();


    @When("^Выбрали калькулятор для сервиса -  \"(.+)\"$")
    public void selectMainServicesCalc(String serviceName){
        mainPageSteps.selectMainService(serviceName);
    }

    @Then("^Заголовок страницы равен - \"(.+)\"$")
    public void checkTitle(String title){
        calcSteps.checkTitle(title);
    }
    @When("^выбрали валюту -  \"(.+)\"$")
    public void selectCurrency(String currency){
        calcSteps.selectCurrency(currency);
    }
    @When("^выбрали опцию -  \"(.+)\" и значение - \"(.+)\"$")
    public void selectOption(String option,String value){ calcSteps.setOption(option,value);
    }
    @When("^установили срок на - \"(.+)\" месяцев$")
    public void selectPeriod(String option){ calcSteps.selectPeriod(option);
    }
    @When("установили чекбокс -  \"(.+)\"$")
    public void setUpCheckBox(String name){
        calcSteps.setUpCheckBoxes(name);
    }
    @Then("^проверили ставку - \"(.+)\"$")
    public void checkRate(String rate){ calcSteps.checkRate(rate);
    }
    @Then("^проверили начисление -  \"(.+)\"$")
    public void checkEarning(String earning){ calcSteps.checkEarning(earning);
    }
    @Then("^проверили пополнение -  \"(.+)\"$")
    public void checkReplenish(String replenish){
        calcSteps.checkReplenish(replenish);
    }
    @Then("^проверили результат к снятию - \"(.+)\"$")
    public void checkResult(String res){
        calcSteps.checkResult(res);
    }

}
