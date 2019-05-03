package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class HomePage extends BasePage {

    //public static final String RUTA_PROYECTO = "//td[contains(@class, 'dFFwSl')]//div[contains(@class, 'hJPhXs')]//a[contains(text(), '%s')]";
    //@FindBy(xpath = "//a[contains(text(), '%s')]");



    //    //*[@id="jira-frontend"]/div[1]/div[2]/async-bundle/async-bundle/div/div/div[2]/div/div/table/tbody/tr/td[1]/div/a
    public static final String RUTA_PROYECTO = "//div[contains(@class, 'hJPhXs') or contains(@class, 'jGPTCR') or contains(@class, 'ibQRqA')]//a[contains(text(), '%s')]";
    //public static final String RUTA_PROYECTO = "//*[@id=\"jira-frontend\"]/div[1]/div[2]/async-bundle/async-bundle/div/div/div[2]/div/div/table/tbody/tr/td[1]/div/a";
    //public static final String RUTA_PROYECTO = "//div[@id='jira-frontend']//async-bundle[@data-id='async-projects-directory-page']//a[contains(text(), '%s')]";

    //public static final String RUTA_PROYECTO = "//div[contains(@class, 'ibQRqA') or contains(@class, 'duLTLB') or contains(@class, 'jGPTCR') or contains(text(), '%s')]";
    //private WebElement nombreProy;  a class  sc-bEufUU ibQRqA
    //public static final String RUTA_PROYECTO = "//div[@data-test-id='directory-base.content.table.container']//a[.//text()='%s']";
    //@FindBy(xpath = "//*[@id=\"jira-frontend\"]/div[1]/div[2]/async-bundle/async-bundle/div/div/div[2]/div/div/table")
    //private WebElement contenido;


    public BackLogPage seleccionarProyecto(String nombreProyecto) {
        By ruta_proyecto = By.xpath(String.format(RUTA_PROYECTO, nombreProyecto));
        CommonEvents.clickButton(ruta_proyecto);
        return new BackLogPage();
    }
}
