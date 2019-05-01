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
    public static final String RUTA_PROYECTO = "//div[contains(@class, 'hJPhXs')]//a[contains(text(), '%s')]";
    //private WebElement nombreProy;

    public void seleccionarProyecto(String nombreProyecto) {
        By ruta_proyecto = By.xpath(String.format(RUTA_PROYECTO, nombreProyecto));
        CommonEvents.clickButton(ruta_proyecto);
        //CommonEvents.clickButton(nombreProy);
    }
}
