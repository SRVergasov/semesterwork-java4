package ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeForm {
    private Long answerId;
    private String username;
}
