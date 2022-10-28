package model;

// a solution writeup for a question
public class Soln extends WriteUp {

    // EFFECTS: creates a solution under a question, accredited to current user
    public Soln(Quest question,User user) {
        super(user);
    }

    // EFFECTS: moves the solution to a different question in case of error
    // REQUIRES: question is not null
    public void setQuestion(Quest question) {
        question.removeSoln(this);
    }
    
}
