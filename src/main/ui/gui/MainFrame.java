package ui.gui;

import model.Event;
import model.EventLog;
import model.User;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// Frame with main panel
public class MainFrame extends JFrame {
    Model model;
    MenuPanel menuPanel;

    public MainFrame() {
        super("SolLolmon");
        model = new Model();

        createProject();
        logUser();

        menuPanel = new MenuPanel(this);
        add(new JScrollPane(menuPanel));

        // print event log on close
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                JFrame frame = (JFrame) evt.getSource();
                System.out.println("Closing frame " + frame.getTitle() + ".\n");

                System.out.println("\nEvent log of all that happened this session: \n");

                EventLog el = EventLog.getInstance();
                for (Event e : el) {
                    System.out.println(e.getDescription());
                }
            }
        };

        pack();
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // EFFECTS: dialog to load project from file or scrap that and create project
    void createProject() {
        int n = JOptionPane.showConfirmDialog(
                this,
                "Load project from file?",
                "Pick up or start fresh",
                JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            model.loadProject();
        } else {
            String title = JOptionPane.showInputDialog("Entitle new project: ");
            model.createProject(title);
        }
    }

    // EFFECTS: dialog to set user's name for this session
    void logUser() {
        String name = JOptionPane.showInputDialog(this,
                "Questions and solutions that you contribute will be accredited to your name. \n"
                        + "Who are you?");
        model.logUser(new User(name));
    }
}
