package com.propertyfinder.practicetest.pages;

import com.propertyfinder.practicetest.utils.FIleWriterUtils;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomePage extends PageObject {

    private String propertytypelist = "//select[contains(@data-url,'propertytype')]/..//div[@class='ms-drop ']/ul/li";

    private String leasetypelist = "//div[@class='pure-g search-wrapper']//div[@class='ms-drop ']/ul/li";

    private String bedroomcontentlist = "//div[@id='bedroom_group']//div[@class='ms-drop ']/ul/li";

    private String bedroomlist = "//div[@id = 'bedroom_group']//button[@class = 'ms-choice']";

    @FindBy(xpath = "//select[contains(@data-url,'propertytype')]/..//button")
    private WebElementFacade typedropdown;

    @FindBy(xpath = "//div[@class='pure-g search-wrapper']//button[@class='ms-choice']")
    private WebElementFacade leasetypedropdown;

    @FindBy(xpath = "//input[@name='q']")
    private WebElementFacade locationsearchbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade findbtn;


    @FindBy(xpath = "//div[@class='title-sort-area']//button[@type='button']")
    private WebElementFacade sortByBtn;

    @FindBy(xpath = "//ul[@class='header-menu']//a[contains(text(),'Find agent')]")
    private WebElementFacade agenTab;

    private String sortByFilterList = "//div[@class='title-sort-area']//div[@class='ms-drop ']/ul/li";

    @FindBy(xpath = "//span[@class='price ']")
    private List<WebElementFacade> priceList;

    @FindBy(xpath = "//bdi")
    private List<WebElementFacade> propertyTitles;

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public void search_by_property_and_lease_type(String propertyType, String leaseType) {

        selectLease(leaseType);
        selectPropertytype(propertyType);
    }

    public void search_by_location(String location) {
        waitFor(locationsearchbox).sendKeys(location);
    }

    public void selectBeds(String minimumBed, String maximumBed) {
        selectMinBeds(minimumBed);
        selectMaxBeds(maximumBed);
    }

    public void selectLease(String leaseType) {
        waitFor(leasetypedropdown).click();
        WebElement leasetypeselection = find(By.xpath(leasetypelist));
        leasetypeselection.findElements(By.xpath(leasetypelist)).stream()
                .filter(list -> list.getText().equalsIgnoreCase(leaseType))
                .findFirst().get().click();
        waitABit(500);
    }

    public void selectPropertytype(String propertyType) {
        waitFor(typedropdown).click();
        WebElement propertytypeselection = find(By.xpath(propertytypelist));
        propertytypeselection.findElements(By.xpath(propertytypelist)).stream()
                .filter(list -> list.getText().equalsIgnoreCase(propertyType))
                .findFirst().get().click();
        waitABit(500);
    }

    public void selectMinBeds(String minimumBed) {
        WebElement bedroomdropdown = find(By.xpath(bedroomlist));
        bedroomdropdown.findElements(By.xpath(bedroomlist)).get(0).click();
        WebElement propertytypeselection = find(By.xpath(bedroomcontentlist));
        propertytypeselection.findElements(By.xpath(bedroomcontentlist)).stream()
                .filter(list -> list.getText().equalsIgnoreCase(minimumBed))
                .findFirst().get().click();
        waitABit(500);

    }

    public void selectMaxBeds(String maximumBed) {

        WebElement bedroomdropdown = find(By.xpath(bedroomlist));
        bedroomdropdown.findElements(By.xpath(bedroomlist)).get(1).click();

        WebElement propertytypeselection = find(By.xpath(bedroomcontentlist));
        propertytypeselection.findElements(By.xpath(bedroomcontentlist)).stream()
                .filter(list -> list.getText().equalsIgnoreCase(maximumBed))
                .findFirst().get().click();
        waitABit(1000);

    }


    public void click_find() {
        waitFor(findbtn).click();
    }

    public boolean isSearchResultsDisplayed() {
        return waitFor(sortByBtn).isDisplayed();
    }

    public void selectSortBy(String sortType) {
        waitFor(sortByBtn).click();
        waitABit(1000);
        List<WebElement> sortList = getDriver().findElements(By.xpath(sortByFilterList));
        for (WebElement sortItem : sortList) {
            if (sortItem.getText().trim().equalsIgnoreCase(sortType)) {
                sortItem.click();
                break;
            }
        }
    }

    public void exportPriceToCSV() {
        Map<String, String> result = new LinkedHashMap<>();
        FIleWriterUtils FIleWriterUtils = new FIleWriterUtils();
        result.put("Property Title", "Property Price-Currency");
        for (int counter = 0; counter < priceList.size(); counter++)
            result.put(propertyTitles.get(counter).getText(),
                    String.format("%s-%s",
                            priceList.get(counter).findElements(By.tagName("span")).get(0).getText(),
                            priceList.get(counter).findElements(By.tagName("span")).get(1).getText()));
        try {
            FIleWriterUtils.generateCsv("src/test/csv.csv", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void newopen() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        getDriver().navigate().to(environmentVariables.getProperty("webdriver.ae.base.url"));
        waitABit(1000);
    }
}