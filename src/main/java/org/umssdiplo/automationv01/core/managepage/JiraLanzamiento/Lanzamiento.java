package org.umssdiplo.automationv01.core.managepage.JiraLanzamiento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.PropertyAccessor;

import java.util.List;

public final class Lanzamiento extends BasePage {

    @FindBy(xpath = "//button[@id=\"login-submit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//a[@class='css-t3yiul']")
    private WebElement linkLanzamiento;

    @FindBy(xpath = "//button[@class='sc-EHOje dCmFoj']")
    private WebElement newReleaseButton;

    @FindBy(xpath = "//input[@class='sc-tilXH xhjOD']")
    private WebElement releaseTitle;

    @FindBy(xpath = "//input[@class='sc-tilXH xhjOD']")
    private List<WebElement> releaseComment;

    @FindBy(xpath = "//button[@class='sc-EHOje dCmFoj']")
    private List<WebElement> submitReleaseButton;

    @FindBy(xpath = "//a[text()='version 2']/parent::div/parent::td/parent::tr/td[7]/div/div/div/div/div/div/div/div/button")
    private WebElement iconMenu;

    @FindBy(xpath = "//a[text()='version 2.1']/parent::div/parent::td/parent::tr/td[7]/div/div/div/div/div/div/div/div/button")
    private WebElement iconMenuDelete;

    @FindBy(xpath = "//a[text()='version-_?']/parent::div/parent::td/parent::tr/td[7]/div/div/div/div/div/div/div/div/button")
    private WebElement iconMenuPublish;

    @FindBy(xpath = "//span[text()='Editar']/parent::span/parent::span")
    private WebElement linkEditar;

    @FindBy(xpath = "//span[text()='Eliminar']/parent::span/parent::span")
    private WebElement linkEliminar;

    @FindBy(xpath = "//span[text()='Archivar']/parent::span/parent::span")
    private WebElement linkArchivar;

    @FindBy(xpath = "//span[text()='Publicar']/parent::span/parent::span")
    private WebElement linkPublicar;

    @FindBy(xpath = "//span[text()='Publicar']/parent::span/parent::span")
    private WebElement publishButton;

    @FindBy(xpath = "//span[text()='Sin publicar']/parent::span/parent::button")
    private WebElement SelectFilter;

    public void Authentication()
    {
        String username = PropertyAccessor.getInstance().getUser();
        CommonEvents.setInputField(usernameInputField, username);
        CommonEvents.clickButton(loginBtn);
        String password = PropertyAccessor.getInstance().getPassword();
        CommonEvents.setInputField(passwordInputField, password);
        CommonEvents.clickButton(loginBtn);
    }

    public void goToReleasePage()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(linkLanzamiento);
    }

    public void openNewReleaseForm()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(newReleaseButton);
    }

    public  void submitForm(String release, String commentRelease)
    {
        String title = release;
        String comment = commentRelease == null?"":commentRelease;
        CommonEvents.setInputField(releaseTitle, title);
        CommonEvents.setInputField(releaseComment.get(1),comment);
        CommonEvents.forceWait(2000);
        List<WebElement> submitList = webDriver.findElements(By.xpath("//button[@class='sc-EHOje dCmFoj']"));
        CommonEvents.clickButton(submitList.get(1));
    }

    public void GoToEditar()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(iconMenu);
        CommonEvents.clickButton(linkEditar);
    }

    public void GoToEliminar()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(iconMenuDelete);
        CommonEvents.clickButton(linkEliminar);
    }

    public void GoToArchive()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(iconMenuDelete);
        CommonEvents.clickButton(linkArchivar);
    }

    public void GoToPublish()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(iconMenuPublish);
        CommonEvents.clickButton(linkPublicar);
    }

    public void PublishRelease()
    {
        CommonEvents.forceWait(10000);
        publishButton = webDriver.findElement(By.xpath("//span[text()='Publicar']/parent::span/parent::button"));
        CommonEvents.clickButton(publishButton);
    }

    public void OpenFilter()
    {
        CommonEvents.forceWait(10000);
        CommonEvents.clickButton(SelectFilter);
    }

    public void SelectPublishes()
    {
        CommonEvents.forceWait(10000);
        WebElement publishButtonSelect = webDriver.findElement(By.xpath("//span[text()='Publicada']/parent::span/parent::span"));
        CommonEvents.clickButton(publishButtonSelect);
    }

    public void SelectArchives()
    {
        CommonEvents.forceWait(10000);
        WebElement archiveButtonSelect = webDriver.findElement(By.xpath("//span[text()='Archivada']/parent::span/parent::span"));
        CommonEvents.clickButton(archiveButtonSelect);
    }
}
