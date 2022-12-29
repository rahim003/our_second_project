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

    public Car(String name, String colour, int yearOfIssue, int price) {
        this.name = name;
        this.colour = colour;
        this.yearOfIssue = yearOfIssue;
        this.price = price;
    }
}
