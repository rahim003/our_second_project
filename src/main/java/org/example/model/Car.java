package org.example.model;

import lombok.*;
import org.example.enums.Country;

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
    private Country countryOfOrigin;
    private int price;



}
