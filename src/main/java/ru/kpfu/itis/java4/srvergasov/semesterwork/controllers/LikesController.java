package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AnswerDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.LikeForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.LikeService;

@RestController
@RequestMapping("/api/likes")
@AllArgsConstructor
public class LikesController {

    private LikeService likeService;

    @PostMapping("/setLike")
    @ResponseBody
    public ResponseEntity<AnswerDto> like(@RequestBody LikeForm likeForm) {
        return ResponseEntity.ok(likeService.like(likeForm));
    }

}
