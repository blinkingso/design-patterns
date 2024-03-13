package prototype;

public class AnswerQuestion {

    public AnswerQuestion(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    private String title;
    private String answer;

    @Override
    public String toString() {
        return "QuestionSubject{" + "title='" + title + '\'' + ", answer='" + answer + '\'' + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
