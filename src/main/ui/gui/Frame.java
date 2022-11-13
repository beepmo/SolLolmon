package ui.gui;

import javax.swing.*;

public class Frame extends JFrame {

    MenuPanel menuPanel;

    public Frame() {
        super("SolLolmon");

        menuPanel = new MenuPanel(this);
        add(menuPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // initiate game
    }

}
