package com.example.cashcard;


import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardJsonTest {
    @Autowired
    private JacksonTester<CashCard> json;

    @Autowired
    private JacksonTester<CashCard[]> jsonList;

    private CashCard[] cashCards;

    @BeforeEach
    void setUp(){
        cashCards = Arrays.array(
                new CashCard(99L, 123.45, "sarah"),
                new CashCard(100L, 1.00, "sarah"),
                new CashCard(101L, 150.00, "sarah"));
    }

    @Test
    void cashCardSerializationTest() throws IOException {
        final CashCard cashCard = new CashCard(99L, 123.45, "sarah");
        final JsonContent<CashCard> jsonContent = json.write(cashCard);
        assertThat(jsonContent).isStrictlyEqualToJson("single.json");
        assertThat(jsonContent).hasJsonPathNumberValue("@.id");
        assertThat(jsonContent).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(jsonContent).hasJsonPathNumberValue("@.amount");
        assertThat(jsonContent).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        final String expected = """
                           {
                               "id":99,
                               "amount":123.45,
                               "owner":"sarah"
                           }
                """;
        assertThat(json.parse(expected)).isEqualTo(new CashCard(99L, 123.45, "sarah"));
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }

    @Test
    void cashCardListSerializationTest() throws IOException {
        assertThat(jsonList.write(cashCards)).isStrictlyEqualToJson("list.json");
    }

    @Test
    void cashCardListDeserializationTest() throws IOException {
        String expected = """
                         [
                            { "id": 99, "amount": 123.45, "owner":"sarah"},
                            { "id": 100, "amount": 1.00, "owner":"sarah" },
                            { "id": 101, "amount": 150.00, "owner":"sarah"}
                         ]
                """;
        assertThat(jsonList.parse(expected)).isEqualTo(cashCards);
    }
}
