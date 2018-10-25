package lv.iljapavlovs.cucumber.pageobjects.google;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;

public class SimplePO {
  private ElementsCollection eventRows = $$(".el-table__row"),
      tabs = $$(".el-tabs__nav [id*=tab]");
  private SelenideElement page = $("main.v-match-parent"),
      refreshButton = $("el-icon-refresh");

  public static SimplePO navigate(String sport) {
    // base path should be set as Configuration.baseUrl before invoking open()
    return open("/#/" + sport, SimplePO.class);
  }

  public List<String> getTexts() {
    return eventRows.texts();
  }

  public SimplePO navigateToSportByTab(String sport) {
    tabs.filter(Condition.text(sport))
        .shouldHave(CollectionCondition.size(1))
        .get(0)
        .click();
    return this;
  }

  public boolean isPageDisplayed() {
    return page.isDisplayed();
  }

  public SimplePO refreshPage() {
    refreshButton.click();
    return this;
  }
}
