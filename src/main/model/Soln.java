package model;

public class Soln extends Pro {
    private Quest question;

    public Soln(Quest question,User user) {
        super(user);
        this.question = question;
    }

    public Quest getQuestion() {
        return question;
    }

    public void setQuestion(Quest question) {
        this.question = question;
    }
}
