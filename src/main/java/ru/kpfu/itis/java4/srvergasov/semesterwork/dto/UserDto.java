package ru.kpfu.itis.java4.srvergasov.semesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private Long rating;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .rating(user.getRating())
                .build();
    }

    public static List<UserDto> from(List<User> list) {
        return list.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
