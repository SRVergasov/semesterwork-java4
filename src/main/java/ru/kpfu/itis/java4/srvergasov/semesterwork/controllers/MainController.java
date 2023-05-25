package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.UserService;

@Controller
@AllArgsConstructor
public class MainController {

    private UserService userService;

    @GetMapping("/")
    public String getMainPage() {
        return "mainPage";
    }

    @GetMapping("/users")
    public String getUsersPage(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.getAllUsers());
        return "usersList";
    }

}
