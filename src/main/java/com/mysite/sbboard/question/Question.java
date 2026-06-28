package com.mysite.sbboard.question;

import com.mysite.sbboard.answer.Answer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // @Setter < 생성자 권장
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // 1:N
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

/*
    @Builder
    public Question(String subject, String content, LocalDateTime createDate){
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
    }
*/
}
