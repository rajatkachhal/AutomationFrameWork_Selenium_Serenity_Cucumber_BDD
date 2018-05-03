package com.propertyfinder.practicetest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;


public class AgentPage extends PageObject {

    private String nationalitylist = "//div[@class='dropdown_popup dropdown_popup-opened false']//div[@class='dropdown_item ']";

//    private String languageMenu = "//select[@name='languages_ids[]']/..//div[@class='ms-drop multiple']//li[@data-value]";

    private String languageMenu = "//div[@class='dropdown_popup dropdown_popup-opened dropdown_popup-mulitple']//div";

    private String agentdetailslink = "//a[@class='tiles_tile']";

    //    @FindBy(xpath = "//select[@name='languages_ids[]']/..//button")
    @FindBy(xpath = "//div[contains(text(),'Languages')]")
    private WebElementFacade agentropdown;

    @FindBy(xpath = "//div[@class='menu']//a[contains(text(),'Find agent')]")
    private WebElementFacade agentTab;

//    @FindBy(xpath = "//button[@type='submit']")
@FindBy(xpath = "//button[@class='button button-fullheight button-connectedright']")
    private WebElementFacade agentSearch;

//    @FindBy(xpath = "//div/h1[@class='serp-h1']")
    @FindBy(xpath = "//div/h1[@class='title']")
    private WebElementFacade agentNo;

    @FindBy(xpath = "//div[text()='Nationality' and @class='dropdown_text dropdown_text-serp']")
    private WebElementFacade agentNationalityBtn;

    @FindBy(xpath = "//h1[@class='title title-size1 bioinfo_name']")
    private WebElementFacade agentName;

    @FindBy(xpath = "//span[contains(text(), 'Nationality:')]//following-sibling::span[@class='table_column']")
    private WebElementFacade agentNationality;

    @FindBy(xpath = "//span[contains(text(), 'Languages:')]//following-sibling::span[@class='table_column']")
    private WebElementFacade agentLanguages;

    @FindBy(xpath = "//span[contains(text(), 'License No.')]//following-sibling::span[@class='table_column']")
    private WebElementFacade agentLicenseNo;

    @FindBy(xpath = "//a[@title='About me']")
    private WebElementFacade aboutMe;

    @FindBy(xpath = "//div[@class='tab_content tab_content-size1 tab_content-active']")
    private WebElementFacade aboutMeData;

    @FindBy(xpath = "//a[@class='button pane_button']")
    private WebElementFacade agentPhoneBtnEarlier;

    @FindBy(xpath = "//span[@class='button_text button_text-value button_phone-ltr']")
    private WebElementFacade agentPhoneBtnLater;

//    @FindBy(xpath = "//div[@class='brokerthumbnail_text']//p[@class='text text-size1']")
//    private WebElementFacade agentCompanyName;

    @FindBy(xpath = "//div[@class='user-experience']//div[@class='content']")
    private WebElementFacade agentExperience;

    @FindBy(xpath = "//div[@class='user-active-listing']//div[@class='content']")
    private WebElementFacade agentActListings;


    @FindBy(xpath = "//div[@class='user-linkedin']//a[contains(text(),'View profile')]")
    private WebElementFacade agentLinkedin;

    @FindBy(xpath = "//div[@class='globalswitch_language']//a[@class='globalswitch_langlink globalswitch_langlink-ar']")
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
//        String companyname = agentCompanyName.getText();
//        String experience = agentExperience.getText();
//        String listings = agentActListings.getText();
//        String linkedin = agentLinkedin.getAttribute("href");
        aboutMe.click();
        String aboutme = aboutMeData.getText();
        agentPhoneBtnEarlier.click();
        String phoneno = agentPhoneBtnLater.getText();
        waitABit(1000);
        return String.format("Agent Name  -->  %s\nAgent Nationality  -->  %s\nAgent Languages  -->  %s\nAgent LicenseNo  -->   %s\n" +
                        "Phone no  -->  %s\nAbout Me  -->  %s",
                name, nationality, languages, licenseno, phoneno, aboutme);
    }

    public void changetoArabic() {
        arabicChange.click();
        String newUrl = getDriver().getCurrentUrl();
        waitABit(1000);
        assertThat("The new url after changing to Arabic (" + newUrl + ")",
                newUrl.matches("https://www.propertyfinder.ae/ar(.*)"));
    }

}