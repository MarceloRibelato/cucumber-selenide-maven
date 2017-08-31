package lv.iljapavlovs.cucumber.pageobjects.azure;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ServiceInfoPage {

    @FindBy(css = ".PageTitle-main")
    private SelenideElement pageTitleHeader;

    @FindBy(css = ".SolutionDetails-footer-action")
    private SelenideElement subscribeButton;

    public String getPageTitleHeaderText() {
        return pageTitleHeader.getText();
    }

    public LoginPage subscribe() {
        subscribeButton.click();
        return page(LoginPage.class);
    }
}
