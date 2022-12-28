package org.example.model;

import lombok.*;


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
    private String email;
    private String phoneNumber;

}
