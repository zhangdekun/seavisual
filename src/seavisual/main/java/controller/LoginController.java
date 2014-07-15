package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;
import util.Constant;
import dao.localDomain.model.User;

@Controller
public class LoginController {
    private final  Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(@RequestParam Map<String, Object> map,HttpServletRequest request) {
        String RETURN = "redirect:/index";
        User user = userService.login(map);
        if(user !=null){
            request.getSession().setAttribute(Constant.SESSION_KEY_USER, user);//set session for login
            Integer role = user.getRole();
            if(role == Constant.ROLE_ADMIN_DATABASE_META){//database meta page
                log.info("login success");
                RETURN = "redirect:dbmeta/index";
            }else if(role == Constant.ROLE_ADMIN_USER_META){//user meta page
                RETURN = "redirect:usermeta/index";
            }
        }else{
            return "login";
        }
        return RETURN;
    }
    @RequestMapping("/")
    public String index(@RequestParam Map<String, Object> map,Model model) {
        return "login";
    }
}
