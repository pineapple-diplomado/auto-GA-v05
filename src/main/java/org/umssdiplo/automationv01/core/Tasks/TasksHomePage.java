package org.umssdiplo.automationv01.core.Tasks;

import org.openqa.selenium.By;
import org.umssdiplo.automationv01.core.managepage.BasePage;

public class TasksHomePage extends BasePage {


    //maso:  YA NO ESTOY USANDO
    public static final String RUTA_PROYECTO = "//div[contains(@class, 'hJPhXs') or contains(@class, 'jGPTCR') or contains(@class, 'ibQRqA') or contains(@class, 'kRQwNv') or contains(@class, 'duLTLB')]//a[contains(text(), '%s')]";


    public TasksBackLogPage seleccionarProyecto(String nombreProyecto) throws InterruptedException {
        Thread.sleep(5000);
        By ruta_proyecto = By.xpath(String.format(RUTA_PROYECTO, nombreProyecto));
        TasksCommonEvents.clickButton(ruta_proyecto);
        return new TasksBackLogPage();
    }
}
