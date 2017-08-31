package lv.iljapavlovs.cucumber.pageobjects.azure;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(css = " div.App-main > div.App-content > div:nth-child(2) > div > div > div:nth-child(1) > span:nth-child(1)")
    private SelenideElement pageTitleHeader;

    @FindBy(css = ".SolutionDetails-footer-action")
    private SelenideElement subscribeButton;

    public String getPageTitleHeaderText() {
        return pageTitleHeader.getText();
    }
}
