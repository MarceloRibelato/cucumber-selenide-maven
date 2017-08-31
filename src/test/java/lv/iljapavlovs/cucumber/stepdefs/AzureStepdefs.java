package lv.iljapavlovs.cucumber.stepdefs;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lv.iljapavlovs.cucumber.pageobjects.azure.LoginPage;
import lv.iljapavlovs.cucumber.pageobjects.azure.ServiceInfoPage;
import lv.iljapavlovs.cucumber.pageobjects.azure.SolutionCataloguePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class AzureStepdefs {
    private SolutionCataloguePage solutionCataloguePage;
    private ServiceInfoPage serviceInfoPage;
    private LoginPage loginPage;

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateToGoogleCom(String url) throws Throwable {
        solutionCataloguePage = Selenide.open("https://" + url, SolutionCataloguePage.class);
    }

    @Then("^Solution Catalogue is presented$")
    public void solutionCatalogueIsPresented() throws Throwable {
        assertThat(solutionCataloguePage.getPageTitleHeaderText(), is("Solution Catalogue"));
    }

    @And("^there should be at least (\\d+) service provided$")
    public void thereShouldBeAtLeastServiceProvided(int numberOfServices) throws Throwable {
        solutionCataloguePage.verifyServiceCountIsGreaterOrEqualThan(numberOfServices);
    }

    @When("^I want to see more details for \"([^\"]*)\" service$")
    public void iWantToSeeMoreDetailsForSwiftReService(String serviceTitle) throws Throwable {
        serviceInfoPage = solutionCataloguePage.getMoreDetailsOnService(serviceTitle);
    }

    @Then("^I am navigated to \"([^\"]*)\" page$")
    public void iAmNavigatedToInfoPage(String pageTitle) throws Throwable {
        switch (pageTitle) {
            case "Solution Catalogue":
                assertThat(solutionCataloguePage.getPageTitleHeaderText(), is("Solution Catalogue"));
                break;
            case "SwiftRe":
                assertThat(serviceInfoPage.getPageTitleHeaderText(), is("SwiftRe"));
                break;
            case "Login":
                assertThat(loginPage.getPageTitleHeaderText(), is("Login"));
                break;
        }
    }

    @When("^I want to subscribe for the service$")
    public void iWantToSubscribeForTheService() throws Throwable {
        loginPage = serviceInfoPage.subscribe();
    }
}
