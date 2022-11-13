package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    protected Frame frame;
    JButton addQuestButton;
    JButton todayButton;
    JButton allQuestButton;
    JButton loadButton;
    JLabel feedbackLabel;

    public MenuPanel(Frame frame) {
        this.frame = frame;

        addQuestButton = new JButton("Add question");
        addQuestButton.setActionCommand("add");
        add(addQuestButton);

        todayButton = new JButton("New day");
        todayButton.setActionCommand("day");
        add(todayButton);

        allQuestButton = new JButton("All questions in store");
        allQuestButton.setActionCommand("all");
        add(allQuestButton);

        loadButton = new JButton("Load project");
        loadButton.setActionCommand("load");
        add(loadButton);

        feedbackLabel = new JLabel("Day 1", JLabel.CENTER);
        add(feedbackLabel, BorderLayout.PAGE_END);

        setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                String s = (String) JOptionPane.showInputDialog(
                        frame,
                        "Complete the sentence:\n"
                                + "\"Green eggs and...\"",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,null,
                        null,
                        "ham");

                //If a string was returned, say so.
                if ((s != null) && (s.length() > 0)) {
                    feedbackLabel.setText(s);
                    return;
                }

                //If you're here, the return value was null/empty.
                //setLabel("Come on, finish the sentence!");
                break;
            case "day":
                break;
            case "all":
                break;
            case "load":

            default:
                // pass
        }

    }
}
