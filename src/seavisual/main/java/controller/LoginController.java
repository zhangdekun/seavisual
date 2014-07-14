package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;
import dao.localDomain.model.User;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(" ")
    public String index(@RequestParam Map<String, Object> map,Model model) {
        map.put("name", "zhangdekun");
        map.put("pwd", "123456");
        List<User> userList = userService.login(map);
        if(userList !=null && userList.size()>0){
            model.addAttribute("user", userList.get(0));
        }
        return "index";
    }
}
