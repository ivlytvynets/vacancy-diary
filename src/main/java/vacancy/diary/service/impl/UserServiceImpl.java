package vacancy.diary.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import vacancy.diary.dao.UserDao;
import vacancy.diary.exception.DataProcessingException;
import vacancy.diary.model.User;
import vacancy.diary.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get user with id: " + id));
    }
}
