package lv.iljapavlovs.pageobjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {

    @FindBy(name = "q")
    private SelenideElement inputField;

    public GoogleSearchResultPage searchFor(String textToSearchFor) {
        inputField.val(textToSearchFor).pressEnter();
        return page(GoogleSearchResultPage.class);
    }

}