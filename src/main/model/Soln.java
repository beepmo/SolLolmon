package model;

// a solution writeup for a question
public class Soln extends ProjectEntry {
    private Quest question; // question that this solution answers

    // EFFECTS: creates a solution under a question, accredited to current user
    public Soln(Quest question,User user) {
        super(user,question.project);
        this.question = question;
    }

    // EFFECTS: moves the solution to a different question in case of error
    // REQUIRES: question is not null
    public void setQuestion(Quest question) {
        question.removeSoln(this);
        this.question = question;
    }

    // EFFECTS: changes question to null
    public void removeQuestion() {
        this.question = null;
    }

    public Quest getQuestion() {
        return question;
    }

}
