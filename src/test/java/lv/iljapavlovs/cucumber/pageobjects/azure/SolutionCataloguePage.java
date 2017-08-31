package lv.iljapavlovs.cucumber.pageobjects.azure;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SolutionCataloguePage {

    @FindBy(css = ".PageTitle-main")
    private SelenideElement pageTitleHeader;

    @FindBy(css = ".Card")
    private ElementsCollection servicesCardList;

    private SelenideElement getServiceCardByTitle(String serviceTitle) {
        return $(byXpath("//*[@class='Card'][descendant::*[text()='" + serviceTitle + "']]"));
    }

    private SelenideElement getServiceCardMoreDetailsButtonByTitle(String serviceTitle) {
        return getServiceCardByTitle(serviceTitle).find(".Card-footer");
    }

    public String getPageTitleHeaderText() {
        return pageTitleHeader.getText();
    }


    public void verifyServiceCountIsGreaterOrEqualThan(int serviceCount) {
        servicesCardList.shouldHave(sizeGreaterThanOrEqual(serviceCount));
    }

    public ServiceInfoPage getMoreDetailsOnService(String serviceTitle) {
        getServiceCardMoreDetailsButtonByTitle(serviceTitle).click();
        return page(ServiceInfoPage.class);
    }

}
