package lv.iljapavlovs.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class GoogleSearchResultPage {

    @FindBy(className = "g")
    private ElementsCollection searchResultElements;


    public ElementsCollection getResults() {
        return searchResultElements;
    }
}
