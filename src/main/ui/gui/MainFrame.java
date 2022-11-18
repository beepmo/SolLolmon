package ui.gui;

import model.User;

import javax.swing.*;

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

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
