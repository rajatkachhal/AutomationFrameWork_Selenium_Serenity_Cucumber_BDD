package com.propertyfinder.practicetest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;

public class DefinitionSteps {

    @Steps
    HomeSteps homeSteps;
    @Steps
    AgentSteps agentSteps;

    @Given("the user is on Qatar Property Finder home page")
    public void givenTheUserIsOnTheQatarPropertyFinderHomePage() {
        homeSteps.is_the_home_page();
    }

    @When("^User search for property \"([^\"]*)\" to \"([^\"]*)\" in location \"([^\"]*)\" with minimum \"([^\"]*)\" and maximum \"([^\"]*)\"$")
    public void user_search_for_property_to_in_location_with_minimum_and_maximum(
            String PropertyType, String LeaseType, String Location, String MinimumBed, String MaximumBed) {
        homeSteps.search_by_property_and_lease_type(PropertyType, LeaseType);
        homeSteps.select_beds(MinimumBed, MaximumBed);
        homeSteps.search_by_location(Location);
        homeSteps.click_find();
    }

    @Then("^User should see the search results$")
    public void user_should_see_the_search_results() {
        assertThat("display of ticket number", homeSteps.searchResultsisDisplayed());
    }

    @Then("^User should be able sort results by \"([^\"]*)\"$")
    public void user_should_be_able_sort_results_by(String FilterValue) {
        homeSteps.SortOption(FilterValue);
    }

    @Then("^User able to store results in an CSV file$")
    public void user_able_to_store_results_in_an_CSV_file() {
        homeSteps.exportPriceToCSV();
    }

    @Given("The User is on UAE property Finder home page")
    public void givenTheUserIsOnTheUAEFinderHomePage() {
        homeSteps.is_the_uae_home_page();
    }

    @When("^User searches for agents who can speak languages \"([^\"]*)\"$")
    public void user_searches_for_agents_who_can_speak_languages(String languages) throws Exception {
        agentSteps.user_searches_for_agents_who_can_speak_languages(languages);
    }

    @When("^User notes down the total count of Agents and selects \"([^\"]*)\" and verifies with present count$")
    public void user_notes_down_the_total_count_of_Agents(String country) throws Exception {
        agentSteps.user_notes_down_the_total_count_of_Agents(country);

    }

    @Given("The User traverses to agent page and selects the first agent")
    public void user_traverses_to_agent_page_and_selects_the_first_agent() throws Exception {
        agentSteps.user_traverses_to_agent_page_and_selects_the_first_agent();
    }

    @Given("The User captures the information of agent in text file")
    public void user_captures_agent_info_in_text_file() throws Exception {
        agentSteps.user_captures_agent_info_in_text_file();
    }

    @Given("User Changes the language to Arabic")
    public void user_language_change_to_arabic() throws Exception {
        agentSteps.user_language_change_to_arabic();
    }
}
