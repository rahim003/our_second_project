package org.example;

import org.example.model.Car;
import org.example.service.CarService;
import org.example.service.impl.CarServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws SQLException {


        CarService carService = new CarServiceImpl();
        while (true){
            System.out.println("""
                    1 creat table,
                    2 save table,
                    3 drop table,
                    4 find by id,
                    5 delete by id,
                    6 clean table,
                    7 find all,
                    8 update
                    """);
            int number = new Scanner(System.in).nextInt();

            if (number == 1){
                System.out.println(carService.createTable());

            }else if (number == 2){
                System.out.println("write car name ->  ");
                String carName = new Scanner(System.in).nextLine();
                System.out.println("write car colour ->");
                String colour = new Scanner(System.in).nextLine();
                System.out.println("write car yearOfIssue");
                int  yearOfIssue= new Scanner(System.in).nextByte();
                System.out.println("write car price");
                int  price= new Scanner(System.in).nextInt();
                System.out.println(carService.saveStudent(new Car(carName, colour, yearOfIssue, price)));

            }else if (number == 3){
                System.out.println(carService.dropTable());
            }else if (number == 4){
                Long id=new Scanner(System.in).nextLong();
                System.out.println(carService.findById(id));
            }else if (number == 5){
                int id = new Scanner(System.in).nextInt();
                System.out.println(carService.deleteById((long) id));
            }else if (number == 6){
                System.out.println(carService.cleanTable());
            }else if (number == 7){
                System.out.println(carService.findAll());
            }else if (number == 8){
                Long id = new Scanner(System.in).nextLong();
                System.out.println("write car name");
                String carName = new Scanner(System.in).nextLine();
                System.out.println("write car colour");
                String colour = new Scanner(System.in).nextLine();
                System.out.println("write car yearOfIssue");
                int yearOfIssue = new Scanner(System.in).nextByte();
                System.out.println("write car price ->");
                int price = new Scanner(System.in).nextInt();
                carService.updateStudent(id, new Car(carName, colour, yearOfIssue,price));
            }
        }


    }

}
