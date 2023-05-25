package ru.kpfu.itis.java4.srvergasov.semesterwork.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.java4.srvergasov.semesterwork.rest.entity.RestQuestion;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.QuestionService;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.RestQuestionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/questions")
public class QuestionsRestController {

    private RestQuestionService restQuestionService;

    @GetMapping("/list")
    public ResponseEntity<List<RestQuestion>> getQuestionsList() {
        return ResponseEntity.ok(restQuestionService.getAllQuestions());
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<RestQuestion> getQuestion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(restQuestionService.getQuestion(id));
    }

    @PostMapping("/question")
    public ResponseEntity<RestQuestion> addQuestion(@RequestBody RestQuestion restQuestion) {
        return ResponseEntity.ok(restQuestionService.addQuestion(restQuestion));
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        restQuestionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/question")
    public ResponseEntity<RestQuestion> updateQuestion(@RequestBody RestQuestion restQuestion) {
        return ResponseEntity.ok(restQuestionService.updateQuestion(restQuestion));
    }

}
