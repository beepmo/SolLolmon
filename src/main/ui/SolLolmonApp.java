package ui;

import exceptions.NoMatchingResultException;
import model.*;

import java.util.List;
import java.util.Scanner;

public class SolLolmonApp {
    private Project project;
    private User user;
    private Scanner input;

    public SolLolmonApp() {
        runSolLolmon();
    }

    private void runSolLolmon() {
        boolean keepGoing = true;
        String command = null;

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

    private void processCommand(String command) {
        if (command.equals("a")) {
            addQuestion();
        } else if (command.equals("s")) {
            addSolution();
        } else if (command.equals("d")) {
            postSoln();
            postQuest();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void postSoln() {
        if (project.getDay() == 1) {
            System.out.println("Welcome to Day 1."
                    + "On subsequent days, any solutions to the previous day's question will be posted here.");
        } else {
            List<Soln> prevSolns = project.getYesterQuest().getSolutions();
            for (Soln soln : prevSolns) {
                String tex = soln.getTex();
                System.out.println("\n" + tex);
            }
        }
    }

    private void postQuest() {
        Quest chosen = project.chooseQuestion();
        String tex = chosen.getTex();

        postPreamble(chosen);

        System.out.println("\n" + tex);
    }

    private void postPreamble(Quest chosen) {
        System.out.println("Day " + project.getDay() + " of " + project.getProject());
        print("Contributor: " + chosen.getContributor());
        print("Source: " + chosen.getSource());
        print("Behold...");
    }

    private void addSolution() {
        try {
            Quest q = selectQuest();
            Soln s = new Soln(q,user);
            q.addSoln(s);
        } catch (NoMatchingResultException e) {
            print("Sorry, my search capability is insufficient for locating the desired quest."
                    + "\n Try some other exact wording?");
        }
    }

    private Quest selectQuest() throws NoMatchingResultException {
        print("Enter a keyword from the question that you remember: ");
        String s = input.next();
        List<Quest> options = project.searchProject(s);

        print("Here are the search results. Enter label number to select a question.");
        for (int i = 0; i < options.size(); i++) {
            print(String.valueOf(i));
            print(String.valueOf(options.get(i)));
        }
        int i = Integer.parseInt(input.next());

        return options.get(i);
    }


    private void addQuestion() {
        Quest q = new Quest(user,project);
        System.out.println("\nInput a question in tex without newline:"
                + "(Will figure out better support for latex later)");
        String tex = input.next();
        q.scanTex(tex);

        System.out.println("Add relevant tags? (y/n)"
                + "just n right now");
        // TODO support nutrition
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tq -> input a question");
        System.out.println("\ts -> input a solution to a question");
        System.out.println("\td -> get the question of the day");
        System.out.println("\tq -> quit");
    }

    // EFFECTS: initializes input, user, project
    // MODIFIES: this
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");

        logUser();

        createProject();
    }

    private void createProject() {
        System.out.println("Enter title of this Question ritual: \n");
        String title = input.next();
        this.project = new Project(title);
    }

    private void logUser() {
        System.out.println("Enter username: \n "
                + "(Questions and solutions that you contribute will be accredited to this name)");
        String name = input.next();
        this.user = new User(name);
    }

    private void print(String x) {
        System.out.println("\n" + x);
    }
}
