package ui.gui;

import model.User;

import javax.swing.*;

public class MainFrame extends JFrame {

    Model model;
    MenuPanel menuPanel;

    public MainFrame() {
        super("SolLolmon");
        model = new Model();

        //default icon, custom title
        int n = JOptionPane.showConfirmDialog(
                this,
                "Load a saved project?",
                "Progression",
                JOptionPane.YES_NO_OPTION);

        // load or create project
        if (n == 0) {
            model.loadProject();
        } else {
            String title = JOptionPane.showInputDialog("Entitle new project: ");
            model.createProject(title);
        }

        String name = JOptionPane.showInputDialog(this,
                "Questions and solutions that you contribute will be accredited to your name. \n Who are you?");
        model.logUser(new User(name));

        menuPanel = new MenuPanel(this);
        add(menuPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // initiate game
    }


}
