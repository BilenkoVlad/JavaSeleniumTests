package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By addRemoveElementsLink = By.xpath("//*[contains(text(), 'Add/Remove Elements')]");
    private final By basicAuthLink = By.xpath("//*[contains(text(), 'Basic Auth')]");
    private final By checkboxesLink = By.xpath("//*[contains(text(), 'Checkboxes')]");
    private final By contextMenuLink = By.xpath("//*[contains(text(), 'Context Menu')]");
    private final By disappearingElementsLink = By.xpath("//*[contains(text(), 'Disappearing Elements')]");
    private final By dropdownLink = By.xpath("//*[contains(text(), 'Dropdown')]");
    private final By dynamicControlsLink = By.xpath("//*[contains(text(), 'Dynamic Controls')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomeUrl() {
        driver.get("https://the-internet.herokuapp.com");
    }

    public By getAddRemoveElementsLink() {
        return addRemoveElementsLink;
    }

    public By getBasicAuthLink() {
        return basicAuthLink;
    }

    public By getCheckboxesLink() {
        return checkboxesLink;
    }

    public By getContextMenuLink() {
        return contextMenuLink;
    }

    public By getDisappearingElementsLink() {
        return disappearingElementsLink;
    }

    public By getDropdownLink() {
        return dropdownLink;
    }

    public By getDynamicControlsLink() {
        return dynamicControlsLink;
    }
}
