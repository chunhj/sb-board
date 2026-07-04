package com.mysite.sbboard.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /* SELECT * FROM question WHERE subject = ?(String subject)
    * JPA에는 Repository의 메서드명을 분석해 쿼리 생성 및 실행
    */
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    // paging
    // Pageable 객체를 입력받아 Page<Question> 타입 객체를 리턴하는 findAll 메서드 생성
    Page<Question> findAll(Pageable pageable);
}
