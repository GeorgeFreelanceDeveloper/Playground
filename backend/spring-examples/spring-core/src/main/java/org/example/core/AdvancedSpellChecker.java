package org.example.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/application.properties")
public class AdvancedSpellChecker implements SpellChecker, InitializingBean, DisposableBean {

    public void checkSpelling(String emailMessage) {
        if (emailMessage != null) {
            // Determining the Language of the email Message
            // Check grammatical errors in the email Message
            // Check spellings in the email Message
            System.out.println("Checking Spelling using Advanced Spell Checker..");
            System.out.println("Spell Checking Completed!!");
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed Properties");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Setting Properties after Bean is initialized");
    }
}
