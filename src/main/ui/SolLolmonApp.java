package ui;

import exceptions.NoMatchingResultException;
import model.*;

import java.util.List;
import java.util.Scanner;

// Question of the day application
public class SolLolmonApp {
    private Project project;
    private User user;
    private Scanner input;

    // EFFECTS: runs the SolLolmon application
    public SolLolmonApp() {
        runSolLolmon();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runSolLolmon() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addQuestion();
        } else if (command.equals("s")) {
            addSolution();
        } else if (command.equals("d")) {
            postSoln();
            project.newDay();
            postQuest();
        } else {
            System.out.println("Selection invalid.");
        }
    }

    // EFFECTS: posts any solutions for the previous day's question
    private void postSoln() {
        print("=====================================================");

        if (project.getDay() == 0) { // first day: yesterQuest is null
            print("Welcome to Day 1.\n"
                    + "On subsequent days, any solutions to the previous day's question will be posted here.");
        } else {
            List<Soln> prevSolns = project.getYesterQuest().getSolutions();
            if (prevSolns.size() == 0) {
                print("Yesterday's question is wild and untamed.");
            } else {
                for (Soln soln : prevSolns) {
                    String tex = soln.getTex();
                    print("Behold a solution:");
                    print(tex);
                }
            }
        }
    }

    // EFFECTS: prepares and posts new question of the day
    // MODIFIES: this
    private void postQuest() {
        Quest q = project.sealQuest();
        presentQuest(q);
    }

    // EFFECTS: prints out prepared question of the day
    private void presentQuest(Quest chosen) {
        print("=====================================================");
        print("                Day " + project.getDay() + " of " + project.getProject());
        print("Contributor: " + chosen.getContributor().getName());
        print("Source: " + chosen.getSource());
        print("Behold...");
        String tex = chosen.getTex();
        print(tex);
        print("=====================================================");

    }

    // EFFECTS: selects a question and adds solution to it
    // MODIFIES: this
    private void addSolution() {
        try {
            Quest q = selectQuest();
            Soln s = new Soln(q,user);
            q.addSoln(s);

            print("Enter your solution!\n" + "As of now, as plain text without line breaks please.");
            String tex = input.next();
            s.scanTex(tex);
            print("Solution added. Cheers,\nLolmon");

        } catch (NoMatchingResultException e) {
            print("Sorry, my search capability is insufficient for locating the desired quest."
                    + "\n Try some other exact wording?");
        }
    }

    // EFFECTS: takes input for question search, displays options, takes selection
    private Quest selectQuest() throws NoMatchingResultException {
        print("Enter a keyword from the question that you remember: ");
        String s = input.next();
        List<Quest> options = project.searchProject(s);

        print("Here are the search results. Enter label number to select a question.");
        for (int i = 0; i < options.size(); i++) {
            print(i + ": " + options.get(i).getTex());
        }
        int i = Integer.parseInt(input.next());

        return options.get(i);
    }

    // EFFECTS: adds a question to the project
    // MODIFIES: this
    private void addQuestion() {
        Quest q = new Quest(user,project);
        print("Please enter a question, in plain text without newline.\n"
                + "(Latex support coming soon!)\n"
                + "Enter question:\n");
        String tex = input.next();
        q.scanTex(tex);

        print("Please describe how this question came to you.\n"
                + "(Book, course, inspiration?)\n"
                + "Enter source:\n");
        String source = input.next();
        q.setSource(source);
        print("Source all set.");

        print("Add relevant tags? (y/n)"
                + "\n Right now, n has been selected for you.");
        // TODO support nutrition
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> input a question");
        System.out.println("\ts -> input a solution to a question");
        System.out.println("\td -> get the question of the day");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: initializes input, user, project
    // MODIFIES: this
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");

        header();

        logUser();

        createProject();
    }

    // EFFECTS: prints neat banner
    private void header() {
        print("=====================================================");
        print("                      SolLolmon");
        print("=====================================================");
    }

    // EFFECTS: initializes project, prompts for question to be added
    // MODIFIES: this
    private void createProject() {
        print("Creating new question of the day project.\n"
                + "Enter title:");
        String title = input.next();
        this.project = new Project(title);

        print("Project created. Cheers,\nLolmon");
        print("To get started, add a question.");
        addQuestion();
    }

    // EFFECTS: initializes user
    // MODIFIES: this
    private void logUser() {
        System.out.println("Questions and solutions that you contribute will be accredited to your username.");
        print("Enter user name:");
        String name = input.next();
        this.user = new User(name);
    }

    // EFFECTS: prints with new line
    private void print(String x) {
        System.out.println("\n" + x);
    }
}
