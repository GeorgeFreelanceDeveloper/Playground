package org.example.core;

import org.springframework.stereotype.Component;

@Component
public class EmailClient {

    private final SpellChecker spellChecker;

    public EmailClient(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
    }

    void sendEmail(String emailMessage) {
        spellChecker.checkSpelling(emailMessage);
        // Logic to Send Email
    }

}
