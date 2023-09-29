package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User userWithCar = new User("Ruslan", "Satybaev", "medtehnik850@gmail.com");
        User user2WithCar = new User("Fedya", "Orlov", "orlov@gmail.com");
        Car car = new Car("bmw", 100);
        Car car2 = new Car("mers", 1001);
        userWithCar.setCar(car);
        user2WithCar.setCar(car2);

        userService.add(userWithCar);
        userService.add(user2WithCar);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        User user = userService.getUserByCarModelAndSeries("mers", 1001);
        System.out.println(user);
        context.close();
    }
}
