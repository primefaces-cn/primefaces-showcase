package com.prime.showcase.integration.accordion;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AccordionMultipleSelectIntegrationTest extends AbstractAccordionIntegrationTest{
    
    protected static final String TEST_URL = PRIME_SHOWCASE_UI + "accordionPanelMultiple.jsf";
    
    @BeforeClass
    public static void init(){
        driver.get(TEST_URL);
    }
    
    @Test
    @Override
    public void shouldVerifyDOM(){
        super.shouldVerifyDOM();
    }
    
    @Test
    public void shouldManageAccordion(){
        
        WebElement accordion = findElementById("accordion");
            
        List<WebElement> headers = findElementsBySelector(accordion, "h3.ui-accordion-header[role='tab']");

        List<WebElement> contents = findElementsBySelector(accordion, "h3.ui-accordion-header[role='tab'] + div.ui-accordion-content[role='tabpanel']");
        
        for ( int i = 0; i < headers.size(); i++) {
            
            findElementBySelector(headers.get(i), "a").click();
            
            waitUntilAllAnimationsComplete();
            
            accordionItemShouldBe(headers.get(i), contents.get(i), i == 0 ? NOT_EXPANDED : EXPANDED);
        }
    }
}
