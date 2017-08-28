package com.arrobaautowired.cejodejota.arch.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jose on 28/8/17.
 */
@Controller("customLoginController")
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }

}

