package ru.kpfu.itis.java4.srvergasov.semesterwork.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.HtmlUtils;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.AdvertisementDto;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.AnswerForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionEditForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.dto.forms.QuestionForm;
import ru.kpfu.itis.java4.srvergasov.semesterwork.security.details.UserDetailsImpl;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.AdvertisementService;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.AnswerService;
import ru.kpfu.itis.java4.srvergasov.semesterwork.services.api.QuestionService;

@Controller
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;
    private AdvertisementService advertisementService;
    private AnswerService answerService;

    @GetMapping()
    public String getQuestionsPage(ModelMap modelMap) {
        modelMap.addAttribute("questionsList", questionService.getAllQuestions());
        return "questionsList";
    }

    @PostMapping("/add")
    public String addQuestion(QuestionForm questionForm, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        questionForm.setTitle(HtmlUtils.htmlEscape(questionForm.getTitle()));
        questionForm.setDescription(HtmlUtils.htmlEscape(questionForm.getDescription()));
        questionService.addQuestion(questionForm, userDetails.getUsername());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#getQuestionsPage").build();
    }

    @GetMapping("/question")
    public String openQuestionPage(@RequestParam("id") Long questionId, ModelMap modelMap) {
        AdvertisementDto ad = advertisementService.getAdvertisement("TODO");
        modelMap.addAttribute("advertisement", ad);
        modelMap.addAttribute("question", questionService.getQuestion(questionId));
        modelMap.addAttribute("answersList", answerService.getAllAnswersByQuestion(questionId));
        return "question";
    }

    @GetMapping("question_delete")
    public String deleteQuestion(@RequestParam("questionId") Long questionId) {
        questionService.deleteQuestion(questionId);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#getQuestionsPage").build();
    }

    @GetMapping("question_edit")
    public String editQuestion(@RequestParam("questionId") Long questionId, ModelMap modelMap) {
        modelMap.addAttribute("question", questionService.getQuestion(questionId));
        return "questionEdit";
    }

    @PostMapping("question_edit")
    public String editQuestion(QuestionEditForm questionForm) {
        questionForm.setTitle(HtmlUtils.htmlEscape(questionForm.getTitle()));
        questionForm.setDescription(HtmlUtils.htmlEscape(questionForm.getDescription()));
        questionService.updateQuestion(questionForm);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#getQuestionsPage").build();
    }

    @PostMapping("answer_add")
    public String addAnswer(AnswerForm answerForm, @RequestParam("questionId") Long questionId, @AuthenticationPrincipal UserDetailsImpl user) {
        answerForm.setText(HtmlUtils.htmlEscape(answerForm.getText()));
        answerService.addAnswer(answerForm, user.getUsername(), questionId);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#openQuestionPage").arg(0, questionId).build();
    }

    @GetMapping("answer_delete")
    public String deleteAnswer(@RequestParam("answerId") Long answerId) {
        Long questionId = answerService.deleteAnswer(answerId);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("QC#getQuestionsPage").arg(0, questionId).build();
    }

}
