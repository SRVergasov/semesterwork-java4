package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.UserForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.SignUpService;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .username(userForm.getUsername())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .rating(0L)
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();

        userRepository.save(newUser);
    }
}
