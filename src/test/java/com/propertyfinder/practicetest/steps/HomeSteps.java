package com.propertyfinder.practicetest.steps;

import com.propertyfinder.practicetest.pages.HomePage;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class HomeSteps extends ScenarioSteps {

    HomePage homePage;

    public void is_the_home_page() {
        homePage.open();
    }


    public void is_the_uae_home_page() {
        homePage.open();
        homePage.newopen();
    }

    public void search_by_property_and_lease_type(String propertyType, String leaseType) {
        homePage.search_by_property_and_lease_type(propertyType, leaseType);
    }

    public void search_by_location(String location) {
        homePage.search_by_location(location);
    }

    public void click_find() {
        homePage.click_find();
    }

    public boolean searchResultsisDisplayed() {
        return homePage.isSearchResultsDisplayed();
    }

    public void select_beds(String minimumBed, String maximumBed) {
        homePage.selectBeds(minimumBed, maximumBed);
    }

    public void SortOption(String filterValue) {
        homePage.selectSortBy(filterValue);
    }

    public void exportPriceToCSV() {
        homePage.exportPriceToCSV();
    }

}