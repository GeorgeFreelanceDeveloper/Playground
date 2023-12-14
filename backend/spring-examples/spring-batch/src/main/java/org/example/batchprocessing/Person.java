package org.example.batchprocessing;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Person {
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
}
