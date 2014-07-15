package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;

@Controller
@RequestMapping("/dbmeta")
public class DbmetaController {
    private final  Logger log = Logger.getLogger(DbmetaController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index(@RequestParam Map<String, Object> map,HttpServletRequest request) {
        return "dbmeta/index";
    }
}
