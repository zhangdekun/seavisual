package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.localDomain.UserDAO;
import dao.localDomain.model.User;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public User login(Map<String,Object> map){
        return userDAO.getUserBynameAndPwd(map);
    }
}
