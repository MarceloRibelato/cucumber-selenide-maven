package lv.iljapavlovs.cucumber.pageobjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {

    @FindBy(name = "q")
    private SelenideElement inputField;

    public GoogleSearchResultPage searchFor(String textToSearchFor) {
        inputField.val(textToSearchFor).pressEnter();
        return page(GoogleSearchResultPage.class);
    }

}