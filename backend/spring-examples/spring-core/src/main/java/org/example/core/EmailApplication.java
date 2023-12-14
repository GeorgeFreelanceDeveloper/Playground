package org.example.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmailApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        EmailClient emailClient = applicationContext.getBean("emailClient", EmailClient.class);
        emailClient.sendEmail("Hey, " +
                "This is my first email message.");
        emailClient.sendEmail("Hey, " +
                "This is my second email message.");

        // Bean Scopes
        AdvancedSpellChecker advancedSpellChecker = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
        System.out.println(advancedSpellChecker);
        AdvancedSpellChecker advancedSpellChecker1 = applicationContext.getBean("advancedSpellChecker", AdvancedSpellChecker.class);
        System.out.println(advancedSpellChecker1);

        applicationContext.registerShutdownHook();
    }
}
