package org.umssdiplo.automationv01.core.managepage.PagesJavierZapata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

public class HomePage extends BasePage {


    //maso:
    public static final String RUTA_PROYECTO = "//div[contains(@class, 'hJPhXs') or contains(@class, 'jGPTCR') or contains(@class, 'ibQRqA') or contains(@class, 'kRQwNv') or contains(@class, 'duLTLB')]//a[contains(text(), '%s')]";


    public BackLogPage seleccionarProyecto(String nombreProyecto) throws InterruptedException {
        Thread.sleep(5000);
        By ruta_proyecto = By.xpath(String.format(RUTA_PROYECTO, nombreProyecto));
        CommonEvents.clickButton(ruta_proyecto);
        return new BackLogPage();
    }
}
