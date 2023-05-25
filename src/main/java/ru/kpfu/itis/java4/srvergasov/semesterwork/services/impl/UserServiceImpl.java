package ru.kpfu.itis.java4.srvergasov.semesterwork.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.UserDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.exceptions.UserNotFoundException;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;
import ru.kpfu.itis.java4.srvergasov.semesterwork.repository.local.UserRepository;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.UserService;

import java.util.List;
import java.util.Optional;

import static ru.kpfu.itis.java4.srvergasov.semesterwork.dto.UserDto.from;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto getUserByUsername(String username) {;
        return userRepository.findByUsername(username).map(UserDto::from).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<UserDto> getSortedByRatingUsers() {
        return from(userRepository.findAllOrderByRating());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAll());
    }


}
