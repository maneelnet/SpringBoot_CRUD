package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> usersList();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user, Long id);

    User showUser(Long id);
}
