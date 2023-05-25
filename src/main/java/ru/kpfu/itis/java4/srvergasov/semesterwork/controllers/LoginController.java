package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", defaultValue = "none") String error, ModelMap modelMap) {
        if (!error.equals("none")) {
            modelMap.addAttribute("errorText", "Wrong username or password");
        }
        return "loginPage";
    }
}
