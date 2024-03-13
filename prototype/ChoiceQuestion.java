package prototype;

import java.util.Map;

public class ChoiceQuestion implements Cloneable {
    public ChoiceQuestion(String title, Map<Select, String> candidates, Select answer) {
        this.title = title;
        this.candidates = candidates;
        this.answer = answer;
    }

    private String title;
    private Map<Select, String> candidates;
    private Select answer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<Select, String> getCandidates() {
        return candidates;
    }

    public void setCandidates(Map<Select, String> candidates) {
        this.candidates = candidates;
    }

    public Select getAnswer() {
        return answer;
    }

    public void setAnswer(Select answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ChoiceSubject{" + "title='" + title + '\'' + ", candidates=" + candidates + ", answer=" + answer + '}';
    }


    @Override
    public ChoiceQuestion clone() {
        try {
            ChoiceQuestion clone = (ChoiceQuestion) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}