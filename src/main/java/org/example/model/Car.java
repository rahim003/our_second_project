package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    private Long id;
    private String name;
    private String colour;
    private int yearOfIssue;
    private int price;


}
