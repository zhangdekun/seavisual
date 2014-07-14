package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.localDomain.UserDAO;
import dao.localDomain.model.User;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public List<User> login(Map<String,Object> map){
        return userDAO.getUserList(map);
    }
}
