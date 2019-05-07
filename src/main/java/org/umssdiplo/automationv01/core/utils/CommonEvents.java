package org.umssdiplo.automationv01.core.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.umssdiplo.automationv01.core.customwebdriver.ManageDriver;

import java.util.List;

public class CommonEvents {

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

    public static void selectValue(WebElement webElement, String content) {
        WebDriverWait waitDriver = ManageDriver.getInstance().getWebDriverWait();
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();

        waitDriver.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();

        WebElement selectItem = webDriver.findElement(By.xpath(
               "//span[@class='mat-option-text'] [contains(text(),'" + content +"')]"));
        waitDriver.until(ExpectedConditions.visibilityOf(selectItem));
        selectItem.click();
    }

    public static void clickElement(By by) {
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();
        WebDriverWait waitDriver = ManageDriver.getInstance().getWebDriverWait();

        WebElement element =  webDriver.findElement(by);
        waitDriver.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static WebElement getElement(By by){
        WebDriver webDriver = ManageDriver.getInstance().getWebDriver();
        WebDriverWait waitDriver = ManageDriver.getInstance().getWebDriverWait();

        WebElement element = webDriver.findElement(by);
        //return waitDriver.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public static void isVisible(By by) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void isNotVisible(By by) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
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

    public static void clickButton(By by) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
        WebElement button = getElement(by);
        button.click();
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
     * This method get title of current page.
     *
     * @return title of the current page.
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

}
