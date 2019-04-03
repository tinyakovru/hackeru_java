/*
package ru.tinyakov.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tinyakov.entity.Car;
import ru.tinyakov.exceptions.CarServicesException;
import ru.tinyakov.services.ICarServices;
import ru.tinyakov.services.JSONCarService;
import ru.tinyakov.utils.Help;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ICarServices service = context.getBean(JSONCarService.class);

        startApp(service);
    }

    private static void startApp(ICarServices service) {
        boolean flag = true;

        System.out.println(">>>>>>> Старт программы >>>>>>>");
        System.out.println("Для вывода справки введите help");
        Scanner sc = new Scanner(System.in);

        while (flag) {
            System.out.print("Введите команду: ");
            String[] command = sc.nextLine().split(" ");

            switch (command[0]) {
                case "help":
                    Help.printHelp();
                    break;
                case "cars":
                    try {
                        service.get().stream().forEach(System.out::println);
                    } catch (CarServicesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "find":
                    try {
                        System.out.println(service.get(Integer.valueOf(command[1])));
                    } catch (CarServicesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "delete": {
                    try {
                        service.delete(Integer.valueOf(command[1]));
                    } catch (CarServicesException e) {
                        e.printStackTrace();
                    }
                }
                break;
                case "update":
                    try {
                        Car car = new Car();
                        car.setId(Integer.valueOf(command[1]));
                        car.setMaker(command[2]);
                        car.setModel(command[3]);
                        car.setYear(Integer.parseInt(command[4]));
                        car.setVin(command[5]);
                        car.setOdometer(Integer.parseInt(command[6]));
                        service.update(car);
                    } catch (CarServicesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    flag = false;
                    sc.close();
                    System.out.println(">>>Спасибо что воспользовались нашим приложением");
                    break;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }
}
*/
