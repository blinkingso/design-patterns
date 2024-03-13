package prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBank implements Cloneable {
    public QuestionBank(String candidate, String number) {
        this.candidate = candidate;
        this.number = number;
    }

    private String candidate; //考生
    private String number; // 学号

    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();
    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<>();

    public QuestionBank append(ChoiceQuestion question) {
        this.choiceQuestions.add(question);
        return this;
    }

    public QuestionBank append(AnswerQuestion question) {
        this.answerQuestions.add(question);
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public QuestionBank clone() {
        try {
            QuestionBank bank = (QuestionBank) super.clone();
            bank.choiceQuestions = (ArrayList<ChoiceQuestion>) this.choiceQuestions.clone();
            bank.answerQuestions = ((ArrayList<AnswerQuestion>) this.answerQuestions.clone());
            Collections.shuffle(bank.choiceQuestions);
            Collections.shuffle(bank.answerQuestions);
            final List<ChoiceQuestion> ques = bank.choiceQuestions;
            for (ChoiceQuestion choiceQuestion : ques) {
                Topic topic = TopicRandomUtil.random(choiceQuestion.getCandidates(), choiceQuestion.getAnswer());
                choiceQuestion.setCandidates(topic.getOption());
                choiceQuestion.setAnswer(topic.getKey());
            }
            return bank;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getCandidate() {
        return candidate;
    }

    public String getNumber() {
        return number;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "QuestionBank{" + "candidate='" + candidate + '\'' + ", number='" + number + '\'' + ", choiceQuestions=" + choiceQuestions + ", answerQuestions=" + answerQuestions + '}';
    }
}
