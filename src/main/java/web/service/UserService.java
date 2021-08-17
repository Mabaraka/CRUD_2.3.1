package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public User getUser(int id);

    public void save(User user);

    public void update(int id, User user);

    public void delete(int id);
}
