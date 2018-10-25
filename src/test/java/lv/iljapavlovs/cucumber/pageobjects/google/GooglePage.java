package lv.iljapavlovs.cucumber.pageobjects.google;


import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    //Classic PO to work with PageFactory - https://selenide.org/documentation/page-objects.html
    @FindBy(name = "q")
    private SelenideElement inputField;

    //OR

    //    SIMPLE
//    private SelenideElement inputField = $("[name='q']") ;


    public GoogleSearchResultPage searchFor(String textToSearchFor) {
        inputField.val(textToSearchFor).pressEnter();

        // No need in PageFactory.initElements()
        return page(GoogleSearchResultPage.class);
    }

}