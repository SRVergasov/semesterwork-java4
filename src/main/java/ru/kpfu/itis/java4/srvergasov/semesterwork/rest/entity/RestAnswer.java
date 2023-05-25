package ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity;

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
public class RestAnswer {

    private Long id;
    private String text;
    private int likes;
    private String authorName;

    public static RestAnswer from(Answer answer) {
        return RestAnswer.builder()
                .id(answer.getId())
                .authorName(answer.getUser().getUsername())
                .text(answer.getText())
                .likes(answer.getLikedUsers().size())
                .build();
    }

    public static List<RestAnswer> from(List<Answer> list) {
        return list.stream().map(RestAnswer::from).collect(Collectors.toList());
    }

}
