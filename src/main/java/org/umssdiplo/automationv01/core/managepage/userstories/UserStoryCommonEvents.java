package org.umssdiplo.automationv01.core.managepage.userstories;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

import java.util.List;

public class UserStoryCommonEvents {

    /**
     * This method set text content to web element.
     *
     * @param webElement Is web element.
     * @param content    Is the content that will be set to the web element.
     */
    public static void setInputField(WebElement webElement, String content) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(content);
    }

    /**
     * This method perform a click action in a web element.
     *
     * @param webElement Is the web element that will be pressed.
     */
    public static void clickButton(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method perform a click in a non visible element in the UI.
     *
     * @param webElement the WebElement non visible in the UI.
     */
    public static void jsClickElement(WebElement webElement) {
        ((JavascriptExecutor) ManageDriver.getInstance().getWebDriver())
                .executeScript("arguments[0].click();", webElement);
    }

    /**
     * This method verifies if a web element is visible.
     *
     * @param webElement is the web element.
     * @return true if web element is visible or false if it isn't visible.
     */
    public static boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element do not exits.");
            return false;
        }
    }

    /**
     * This method verifies if a web element is visible.
     *
     * @param webElement is the web element.
     * @return true if web element is visible or false if it isn't visible.
     */
    public static boolean isPresent(WebElement webElement) {
        try {
            return webElement.isEnabled();
        } catch (NoSuchElementException e) {
            System.out.println("Element do not exits.");
            return false;
        }
    }

    /**
     * This method perform a search in a WebElement list based on a content string parameter.
     *
     * @param elements is the WebElements lists.
     * @param content  is the content parameter.
     * @return the WebElement search result.
     */
    public static WebElement findWebElement(List<WebElement> elements, String content) {
        return elements.stream()
                .filter(element -> content.equals(element.getText()))
                .findAny()
                .orElse(null);
    }

    /**
     * This method return the text content of a WebElement.
     *
     * @param webElement is the WebElement to extract the text.
     * @return the text content of the WebElement.
     */
    public static String getTextContent(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method get title of current userstories.
     *
     * @return title of the current userstories.
     */
    public static String getPageTitle() {
        return ManageDriver.getInstance().getWebDriver().getTitle();
    }

    /**
     * This method press enter key to web element.
     *
     * @param webElement is the WebElement.
     */
    public static void pressEnterKey(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    public static void waitElementVisible(WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitElementVisible(By webElement) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(webElement);
        waitElementVisible(element);
    }

    public static void clickButton(By by) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        clickButton(element);
    }

    public static String getTextContent(By by) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        return getTextContent(element);
    }

    public static void setInputField(By by, String content) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        setInputField(element, content);
    }

    public static void pressEnterKey(By by) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        pressEnterKey(element);
    }

    public static String getAttribute(String attribute, By by) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        return getAttribute(attribute, element);
    }

    public static String getAttribute(String attribute, WebElement webElement) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);
    }

    public static void hoverOn(WebElement webElement) {
        Actions action = new Actions(ManageDriver.getInstance().getWebDriver());
        action.moveToElement(webElement).build().perform();;
    }

    public static void hoverOn(By by) {
        WebElement element = ManageDriver.getInstance().getWebDriver().findElement(by);
        hoverOn(element);
    }
}
