package com.propertyfinder.practicetest.steps;

import com.propertyfinder.practicetest.pages.AgentPage;
import com.propertyfinder.practicetest.utils.FIleWriterUtils;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;


public class AgentSteps {

    AgentPage agentPage;

    public void user_searches_for_agents_who_can_speak_languages(String languages) {
        agentPage.clickAgentTab();
        agentPage.clickLanguageList();
        agentPage.selectLanguages(languages);
        agentPage.clickSearch();
    }

    public void user_notes_down_the_total_count_of_Agents(String country) {
        int previouscount = agentPage.getAgentCount();
        agentPage.filterByCountry(country);
        int newcount = agentPage.getAgentCount();
        assertThat("Previous agent count (" + previouscount + ") should be greater than new agent count (" + newcount + ")",
                previouscount > newcount);

    }

    public void user_traverses_to_agent_page_and_selects_the_first_agent() {
        agentPage.clickAgentTab();
        agentPage.selectFirstAgent();

    }

    public void user_captures_agent_info_in_text_file() throws IOException {
        FIleWriterUtils fIleWriterUtils = new FIleWriterUtils();
        String details = agentPage.captureDetails();
        fIleWriterUtils.writeToTxt(details);
    }


    public void user_language_change_to_arabic() throws IOException {
        agentPage.changetoArabic();
    }

}