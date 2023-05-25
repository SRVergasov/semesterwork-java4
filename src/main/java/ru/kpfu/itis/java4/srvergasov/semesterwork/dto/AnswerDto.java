package ru.kpfu.itis.java4.srvergasov.semesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Answer;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDto {
    private Long id;
    private String text;
    private String username;
    private String likes;

    public static AnswerDto from(Answer answer) {
        return AnswerDto.builder()
                .id(answer.getId())
                .text(answer.getText())
                .username(answer.getUser().getUsername())
                .likes(String.valueOf(answer.getLikedUsers().size()))
                .build();
    }

    public static List<AnswerDto> from(List<Answer> list) {
        return list.stream().map(AnswerDto::from).collect(Collectors.toList());
    }
}
