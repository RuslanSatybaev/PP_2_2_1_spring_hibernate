package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    String USER_BY_CAR = "FROM User u WHERE u.car.model=:model AND u.car.series=:series";

    void add(User user);

    List<User> listUsers();

    User getUserByCarModelAndSeries(String model, int series);
}
