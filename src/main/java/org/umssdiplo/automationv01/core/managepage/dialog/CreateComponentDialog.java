package org.umssdiplo.automationv01.core.managepage.dialog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class CreateComponentDialog extends BasePage {
//    @FindBy(xpath = "//div[contains(@class, 'Content-ve26fj-1 hqyPWx')]/input[@type='text']"
    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> inputElements;

    @FindBy(xpath = "//div[contains(@class, 'sc-iYUSvU idJZPR')]")
    private List<WebElement> selectElements;

    @FindBy(xpath = "//span[.//text()='Save']")
    private WebElement saveButtonElement;

    @FindBy(xpath = "//td[contains(@class, 'sc-GMQeP ihzuLG')]")
    private List<WebElement> componentElements;

    @FindBy(xpath = "//div[contains(@class, 'styled-knyj0u-0 bkyfAV')]")
    private WebElement backgroundElement;

    public CreateComponentDialog setComponentName(String componentName) {
        CommonEvents.setInputField(inputElements.get(1), componentName);
        return this;
    }

    public void setComponentDescription(String componentDescription) {
        CommonEvents.setInputField(inputElements.get(2), componentDescription);
    }

    public void setComponentLead(String componentLead) {
        CommonEvents.setInputField(inputElements.get(3), componentLead);
    }

    public void setDefaultAssignee(String assignee) {
        CommonEvents.setSelectValueComponentsForm(selectElements.get(1), assignee);
    }

    public void clickSaveButton() {
        CommonEvents.clickButton(saveButtonElement);
    }

    public Boolean verifyCreation(String componentName) {
        String currentValue = "";
        for ( WebElement component: componentElements)
        {
            System.out.println(currentValue);
            if(CommonEvents.getTextContent(component).equals(componentName))
            {
                return true;
            }
        }
        return false;
    }

    public void clickOutSideForm() {
        CommonEvents.forceWait(4000);
        CommonEvents.jsClickElement(backgroundElement);
    }

    public boolean isCancelButtonEnable() {
        return CommonEvents.isPresent(saveButtonElement);
    }
}
