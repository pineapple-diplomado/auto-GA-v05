package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class PanelConfiguracionTask extends BasePage {


    @FindBy(xpath = "//input[@placeholder='Añadir un comentario…']")   //CHANGE Add a comment...
    private WebElement fieldComentario;

    //@FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[3]/div[2]/div/div/div/div[1]/div/div/button")
    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[3]/div[2]/div/div/div/div[1]/div/div/button/span")   ////span[contains(text(), 'Por hacer')]
    private WebElement selectedItems;

    @FindBy(xpath ="//span[contains(text(), 'In Progress')]")
    private WebElement selectInProgress;

    //@FindBy(xpath ="div[(@id,'ghx-detail-view')]//span[(text()='Medium')]")
    @FindBy(xpath = "//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[5]/div/div[1]/div[7]/div[2]/div/div/div[2]/div/div/div/div/div/div/span")
    private WebElement itemMedium;

    public void setSelectInProgress() {
        CommonEvents.clickButton(selectedItems);
        CommonEvents.clickButton(selectInProgress);
    }

    public String verificandoInProgress() {
        String status = selectedItems.getText();
        return status;
    }

    public void setPrioridadToLow(String low) throws InterruptedException {
//        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"ghx-detail-view\"]/div/div[2]/div/div/div/div[3]/div/div[1]/div[1]/div/div/div/div/div[5]/div/div[1]/div[7]/div[2]/div/div/div[2]/div/div/div/div/div/div/span"));
//        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);
//        CommonEvents.clickButton(element);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,1000)");

    }
}
