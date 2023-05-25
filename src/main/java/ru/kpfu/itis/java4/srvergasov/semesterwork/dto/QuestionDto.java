package ru.kpfu.itis.java4.srvergasov.semesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.java4.srvergasov.semesterwork.model.Question;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    private Long id;
    private String title;
    private String description;
    private String username;
    private String category;

    public static QuestionDto from(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .username(question.getUser().getUsername())
                .description(question.getDescription())
                .category(question.getCategory().getName())
                .build();
    }

    public static List<QuestionDto> from(List<Question> list) {
        return list.stream().map(QuestionDto::from).collect(Collectors.toList());
    }
}
