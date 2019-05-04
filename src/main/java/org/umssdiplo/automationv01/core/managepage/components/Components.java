package org.umssdiplo.automationv01.core.managepage.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.dialog.CreateComponentDialog;
import org.umssdiplo.automationv01.core.managepage.dialog.EditComponentDialog;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class Components extends BasePage {
    @FindBy(xpath = "//a[@href=\"/projects/JAG?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page\"]")
//    @FindBy(id = "productLogoGlobalItem")
    private WebElement componentsOption;

    @FindBy(xpath = "//h1[contains(@class, 'sc-caSCKo hRKYHI')]")
    private WebElement titleElement;

    @FindBy(xpath = "//span[.//text()='Create component']")
    private WebElement createComponentElement;

    @FindBy(xpath = "//tr[.//text()='Frontend side 14']/td[6]")
    private WebElement selectComponentElement;

    @FindBy(xpath = "//tr[.//text()='Frontend side 14']/td[]")
    private WebElement updatedComponentElement;

    @FindBy(xpath = "//td[contains(@class, 'sc-GMQeP ihzuLG')]")
    private List<WebElement> createdComponentsList;

    @FindBy(name = "search")
    private WebElement searchInputElement;

    @FindBy(xpath = "//tr[1]/td[1]")
    private WebElement foundedComponent;


    public Components() {

    }

    public void redirect() {
        CommonEvents.forceWait(4000);
        CommonEvents.clickButton(componentsOption);
    }

    public String getTitle() {
        return CommonEvents.getTextContent(titleElement);
    }

    public CreateComponentDialog clickCreateComponentButton() {
        CommonEvents.clickButton(createComponentElement);
        return new CreateComponentDialog();
    }

    public Components deleteComponent(String componentName) {
        return this;
    }

    public Components deleteComponent() {
        CommonEvents.setSelectValueComponentsForm(selectComponentElement, "Delete");
        return this;
    }

    public boolean verifyDeletedComponent(String componentName) {
        return CommonEvents.findWebElement(createdComponentsList, componentName) != null ? true : false;
//        {
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    public EditComponentDialog openEditComponentDialog() {
        CommonEvents.setSelectValueComponentsForm(selectComponentElement, "Edit");
        return new EditComponentDialog();
    }

    public String getDescription() {
        return CommonEvents.getTextContent(updatedComponentElement);
    }

    public Components findComponent(String component) {
        CommonEvents.setInputField(searchInputElement, component);
        return this;
    }

    public boolean isCurrent(String component) {
        CommonEvents.forceWait(4000);
        return CommonEvents.getTextContent(foundedComponent).equals(component)? true : false;
    }
}
