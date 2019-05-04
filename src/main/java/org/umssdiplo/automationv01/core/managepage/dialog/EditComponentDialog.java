package org.umssdiplo.automationv01.core.managepage.dialog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.managepage.components.Components;
import org.umssdiplo.automationv01.core.utils.CommonEvents;

import java.util.List;

public class EditComponentDialog extends BasePage {
    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> inputElements;

    @FindBy(xpath = "//span[.//text()='Save']")
    private WebElement saveButtonElement;

    @FindBy(xpath = "//div[contains(@class, 'sc-iYUSvU idJZPR')]")
    private List<WebElement> selectElements;


    public void deleteNameComponent() {
        CommonEvents.forceWait(4000);
        CommonEvents.setInputField(inputElements.get(1), " ");
    }

    public boolean isSaveButtonDisabled() {
        return CommonEvents.isVisible(saveButtonElement);
    }

    public void setDescriptionField(String newDescription) {
        CommonEvents.forceWait(4000);
        CommonEvents.setInputField(inputElements.get(2), newDescription);
    }

    public void editDefaultAssignee(String selectedAssignee) {
        CommonEvents.setSelectValueComponentsForm(selectElements.get(1), selectedAssignee);
    }

    public Components updateComponent() {
        CommonEvents.clickButton(saveButtonElement);
        return new Components();
    }
}
