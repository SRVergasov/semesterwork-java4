package ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestQuestion {

    private Long id;
    private String title;
    private String description;
    private String authorName;
    private String category;
    private List<RestAnswer> answerList;

    public static RestQuestion from(Question question) {
        return RestQuestion.builder()
                .id(question.getId())
                .category(question.getCategory().getName())
                .title(question.getTitle())
                .description(question.getDescription())
                .authorName(question.getUser().getUsername())
                .answerList(RestAnswer.from(question.getAnswers()))
                .build();
    }

    public static RestQuestion fromWithoutAnswers(Question question) {
        return RestQuestion.builder()
                .id(question.getId())
                .category(question.getCategory().getName())
                .title(question.getTitle())
                .description(question.getDescription())
                .authorName(question.getUser().getUsername())
                .build();
    }

    public static List<RestQuestion> from(List<Question> list) {
        return list.stream().map(RestQuestion::from).collect(Collectors.toList());
    }

    public static List<RestQuestion> fromWithoutAnswers(List<Question> list) {
        return list.stream().map(RestQuestion::fromWithoutAnswers).collect(Collectors.toList());
    }

}
