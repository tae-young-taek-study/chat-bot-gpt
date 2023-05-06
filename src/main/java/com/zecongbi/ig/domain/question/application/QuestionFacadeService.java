package com.zecongbi.ig.domain.question.application;

import com.zecongbi.ig.domain.keyword.entity.Keyword;
import com.zecongbi.ig.domain.keyword.repository.KeywordRepository;
import com.zecongbi.ig.domain.question.dto.InterviewQuestion;
import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import com.zecongbi.ig.domain.question.entity.Question;
import com.zecongbi.ig.domain.question.repository.QuestionRepository;
import com.zecongbi.ig.domain.questionKeyword.entity.QuestionKeyword;
import com.zecongbi.ig.domain.questionKeyword.repository.QuestionKeywordRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionFacadeService {

  private final QuestionRepository questionRepository;
  private final KeywordRepository keywordRepository;
  private final QuestionKeywordRepository questionKeywordRepository;


  public QuestionFacadeService(QuestionRepository questionRepository,
      KeywordRepository keywordRepository, QuestionKeywordRepository questionKeywordRepository) {
    this.questionRepository = questionRepository;
    this.keywordRepository = keywordRepository;
    this.questionKeywordRepository = questionKeywordRepository;
  }

  @Transactional
  public void saveQuestions(List<InterviewResponse> interviews) {
    for(InterviewResponse interview : interviews) {
      saveQuestion(interview);
    }
  }

  private void saveQuestion(InterviewResponse interview) {
    String category = interview.getCategory();
    List<InterviewQuestion> interviewQuestions = interview.getQuestions();
    interviewQuestions.forEach(interviewQuestion -> {
      String question = interviewQuestion.getQuestion();
      List<Keyword> savedKeywords = saveKeywords(interviewQuestion);
      Question savedQuestion = questionRepository.save(Question.of(question, category));
      savedKeywords.forEach(savedKeyword -> {
        questionKeywordRepository.save(QuestionKeyword.of(savedQuestion, savedKeyword));
      });
    });
  }

  private List<Keyword> saveKeywords(InterviewQuestion interviewQuestion) {
    List<String> keywords = interviewQuestion.getKeywords();
    return keywords.stream().map(keyword -> {
      if (!keywordRepository.existsKeywordByKeyword(keyword)) {
        return keywordRepository.save(Keyword.toEntity(keyword));
      } else {
        return keywordRepository.findKeywordByKeyword(keyword);
      }
    }).collect(Collectors.toList());
  }

}
