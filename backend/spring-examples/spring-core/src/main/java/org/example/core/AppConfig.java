package org.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean(name = "basicSpellChecker", initMethod = "init", destroyMethod = "destroy")
    public SpellChecker createBasicSpellChecker() {
        return new BasicSpellChecker();
    }

    @Bean(name = "advancedSpellChecker")
    public SpellChecker createAdvancedSpellChecker() {
        return new AdvancedSpellChecker();
    }

    @Bean(name = "emailClient")
    public EmailClient createEmailClient() {
        return new EmailClient(createAdvancedSpellChecker());
    }
}
