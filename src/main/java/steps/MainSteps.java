package steps;
import pages.MainPage;
import org.junit.*;
import io.qameta.allure.Step;
public class MainSteps {

    @Step("выбрали калькулятор из основных сервисов главной страницы - {itemName}")
    public void selectMainService(String serviceName){
        new MainPage().selectMainServicesCalc(serviceName);
    }

}
