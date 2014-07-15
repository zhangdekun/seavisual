package dao.localDomain;

import java.util.List;
import java.util.Map;

import dao.localDomain.model.User;

public interface UserDAO {
    public List<User>  getUserList(Map<String,Object> map);
    public User getUserBynameAndPwd(Map<String,Object> map);
}
