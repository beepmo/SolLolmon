package ui.gui;

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

        if (n == 0) {
            model.loadProject();
        } else {
            // create new project
        }

        menuPanel = new MenuPanel(this);
        add(menuPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // initiate game
    }

}
