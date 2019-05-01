package org.umssdiplo.automationv01.core.managepage.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.umssdiplo.automationv01.core.managepage.BasePage;
import org.umssdiplo.automationv01.core.utils.CommonEvents;
import org.umssdiplo.automationv01.core.utils.LoadPage;

public class StoryCreationMenu extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'iic-trigger iic-trigger_hidden')]")
    private WebElement container;

    @FindBy(xpath = "//button[@original-title='Open create dialog']")
    private WebElement openCreateDialogButton;

    public StoryCreationMenu() {
        CommonEvents.waitElementVisible(openCreateDialogButton);
    }

    public void clickCreateDialogButton() {
        CommonEvents.clickButton(openCreateDialogButton);
    }
}
