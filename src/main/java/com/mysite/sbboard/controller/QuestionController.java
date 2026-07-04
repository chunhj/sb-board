package com.mysite.sbboard.controller;

import com.mysite.sbboard.answer.AnswerForm;
import com.mysite.sbboard.question.Question;
import com.mysite.sbboard.question.QuestionForm;
import com.mysite.sbboard.question.QuestionRepository;
import com.mysite.sbboard.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        /* data -> template 전달 */
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    // @Valid 바로 뒤에 BindingResult 위치해야
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        // bindingResult: @Valid로 검증이 수행된 결과
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        // 질문 저장
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 저장 후 목록으로 이동
    }
}
