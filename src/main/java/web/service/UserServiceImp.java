package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> usersList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user, Long id) {
        User userDB = userRepository.findById(id).get();

        if (Objects.nonNull(userDB.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
            userDB.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(userDB.getSecondName()) && !"".equalsIgnoreCase(user.getSecondName())) {
            userDB.setSecondName(user.getSecondName());
        }

        if (Objects.nonNull(userDB.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userDB.setEmail(user.getEmail());
        }
        userRepository.save(userDB);

    }

    @Override
    public User showUser(Long id) {
        return userRepository.findById(id).get();
    }

}
