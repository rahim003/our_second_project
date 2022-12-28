package org.example.model;

import lombok.*;
import org.example.enums.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private Long id;
    private String name;
    private int age;
    private Gender gender;
    private String email;
    private String phoneNumber;

}
