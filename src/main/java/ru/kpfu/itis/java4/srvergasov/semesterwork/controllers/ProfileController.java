package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.java4.srvergasov.semesterwork.security.details.UserDetailsImpl;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProfileController {

    private UserService userService;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetailsImpl user, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserByUsername(user.getUsername()));
        return "profile";
    }

}
