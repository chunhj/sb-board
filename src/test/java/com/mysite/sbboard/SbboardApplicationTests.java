package com.mysite.sbboard;

import com.mysite.sbboard.answer.Answer;
import com.mysite.sbboard.question.Question;
import com.mysite.sbboard.answer.AnswerRepository;
import com.mysite.sbboard.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbboardApplicationTests {

    // 생성자로 객체 주입 방식 권장
    @Autowired    // Dependency Injection
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    void testJpa() {
        Optional<Question> qa = this.questionRepository.findById(2);
        assertTrue(qa.isPresent());
        Question q = qa.get();
        List<Answer> answerList = q.getAnswerList();
        assertEquals(1, answerList.size());
        assertEquals("네, 자동으로 생성됩니다.", answerList.get(0).getContent());

/*
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        // answer entity data insert
        Answer a = new Answer();
        a.setContent("네, 자동으로 생성됩니다.");
        a.setQuestion(q); // 어떤 질문의 답변인지 알기 위함
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
*/

        // question entity data update

        /* question entity data select
        // 기댓값 실젯값 테스트
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());

        // NullPointerException 방지
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()){
            Question q2 = oq.get();
            assertEquals("sbb가 무엇인가요?", q2.getSubject());
        }

        // JPA는 findeBySubject 메서드 미제공
        Question q3 = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q3.getId());
        Question q4 = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해 알고 싶습니다.");
        assertEquals(1, q4.getId());
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q5 = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q5.getSubject());
        */

    }
}
