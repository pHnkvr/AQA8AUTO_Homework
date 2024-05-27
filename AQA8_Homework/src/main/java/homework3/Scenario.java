package homework3;

import homework1.task1.DriverInit;
import org.openqa.selenium.*;

public class Scenario {
    public static void main(String[] args) {
        WebDriver driver = DriverInit.setUpDriver();
        ScenarioActions scenarioActions = new ScenarioActions(driver);
        scenarioActions.executeScenario();
    }
}

