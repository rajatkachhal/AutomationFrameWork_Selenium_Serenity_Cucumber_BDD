package com.propertyfinder.practicetest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AgentPage extends PageObject {

    private String nationalitylist = "//select[@name='nationality']/..//div[@class='ms-drop ']//li[@data-value]";

    private String languageMenu = "//select[@name='languages_ids[]']/..//div[@class='ms-drop multiple']//li[@data-value]";

    private String agentdetailslink = "//div[@class='img-container placeholder-agent-lg']";

    @FindBy(xpath = "//select[@name='languages_ids[]']/..//button")
    private WebElementFacade agentropdown;

    @FindBy(xpath = "//ul[@class='header-menu']//a[contains(text(),'Find agent')]")
    private WebElementFacade agentTab;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade agentSearch;

    @FindBy(xpath = "//div/h1[@class='serp-h1']")
    private WebElementFacade agentNo;

    @FindBy(xpath = "//select[@name='nationality']/..//button")
    private WebElementFacade agentNationalityBtn;

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElementFacade agentName;

    @FindBy(xpath = "//div[@class='user-nationality']//div[@class='content']")
    private WebElementFacade agentNationality;

    @FindBy(xpath = "//div[@class='user-language']//div[@class='content']")
    private WebElementFacade agentLanguages;

    @FindBy(xpath = "//div[@class='user-rera-no']//div[@class='content']")
    private WebElementFacade agentLicenseNo;

    @FindBy(xpath = "//button[@data-tab='aboutMe']")
    private WebElementFacade aboutMe;

    @FindBy(xpath = "//div[@data-tab-ref='aboutMe']")
    private WebElementFacade aboutMeData;

    @FindBy(xpath = "//a[@class='action-button call-agent reveal']")
    private WebElementFacade agentPhoneBtnEarlier;

    @FindBy(xpath = "//a[@class='action-button call-agent reveal revealed']")
    private WebElementFacade agentPhoneBtnLater;

    @FindBy(xpath = "//div[@class='company-name']")
    private WebElementFacade agentCompanyName;

    @FindBy(xpath = "//div[@class='user-experience']//div[@class='content']")
    private WebElementFacade agentExperience;

    @FindBy(xpath = "//div[@class='user-active-listing']//div[@class='content']")
    private WebElementFacade agentActListings;


    @FindBy(xpath = "//div[@class='user-linkedin']//a[contains(text(),'View profile')]")
    private WebElementFacade agentLinkedin;

    @FindBy(xpath = "//header//div[@class='language-wrapper']/a[@dir]")
    private WebElementFacade arabicChange;


    public void clickLanguageList() {
        waitFor(agentropdown).click();
        waitABit(1000);
    }

    public void clickAgentTab() {
        waitFor(agentTab).click();
        waitABit(1000);
    }

    public void selectLanguages(String languages) {
        String[] myArray = languages.split(", ");
        for (String language : myArray) {
            WebElement languageselection = find(By.xpath(languageMenu));
            languageselection.findElements(By.xpath(languageMenu)).stream()
                    .filter(list -> list.getText().equalsIgnoreCase(language))
                    .findFirst().get().click();
            waitABit(1000);
        }
    }

    public void clickSearch() {
        waitFor(agentSearch).click();
        waitABit(1000);
    }

    public int getAgentCount() {
        String agentsCountText = agentNo.getText();
        return Integer.valueOf(agentsCountText.split(" ")[0].trim());
    }

    public void filterByCountry(String country) {
        waitFor(agentNationalityBtn).click();
        WebElement nationalityselection = find(By.xpath(nationalitylist));
        nationalityselection.findElements(By.xpath(nationalitylist)).stream()
                .filter(list -> list.getText().equalsIgnoreCase(country))
                .findFirst().get().click();
        waitABit(1000);
    }

    public void selectFirstAgent() {
        WebElement agentImage = find(By.xpath(agentdetailslink));
        agentImage.findElements(By.xpath(agentdetailslink)).get(0).click();
        waitABit(1000);
    }

    public String captureDetails() {
        waitFor(agentName);
        String name = agentName.getText();
        String nationality = agentNationality.getText();
        String languages = agentLanguages.getText();
        String licenseno = agentLicenseNo.getText();
        String companyname = agentCompanyName.getText();
        String experience = agentExperience.getText();
        String listings = agentActListings.getText();
        String linkedin = agentLinkedin.getAttribute("href");
        aboutMe.click();
        String aboutme = aboutMeData.getText();
        agentPhoneBtnEarlier.click();
        String phoneno = agentPhoneBtnLater.getText();
        waitABit(1000);
        return String.format("Agent Name  -->  %s\nAgent Nationality  -->  %s\nAgent Languages  -->  %s\nAgent LicenseNo  -->  %s\nCompany Name  -->  %s\n" +
                        "Agent Experience  -->  %s\nActive Listings  -->  %s\nLinked In Profile URL  -->  %s\nPhone no  -->  %s\nAbout Me  -->  %s",
                name, nationality, languages, licenseno, companyname, experience,
                listings, linkedin, phoneno, aboutme);
    }

    public void changetoArabic() {
        arabicChange.click();
        waitABit(1000);
    }
}