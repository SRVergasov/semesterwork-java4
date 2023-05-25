package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.HtmlUtils;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.UserForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.SignUpService;

@Controller
@AllArgsConstructor
public class SignUpController {

    private SignUpService signUpService;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(UserForm userForm) {
        userForm.setUsername(HtmlUtils.htmlEscape(userForm.getUsername()));
        userForm.setPassword(HtmlUtils.htmlEscape(userForm.getPassword()));
        signUpService.signUp(userForm);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("PC#profile").build();
    }

}
