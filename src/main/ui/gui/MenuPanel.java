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
        addQuestButton.addActionListener(this);

        todayButton = new JButton("New day");
        todayButton.setActionCommand("day");
        add(todayButton);
        todayButton.addActionListener(this);

        allQuestButton = new JButton("All questions in store");
        allQuestButton.setActionCommand("all");
        add(allQuestButton);
        allQuestButton.addActionListener(this);

        loadButton = new JButton("Load project");
        loadButton.setActionCommand("load");
        add(loadButton);
        loadButton.addActionListener(this);

        feedbackLabel = new JLabel("Day 1", JLabel.CENTER);
        add(feedbackLabel, BorderLayout.PAGE_END);
        feedbackLabel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                // If this case is reached, say so
                feedbackLabel.setText("Adding a quest!");

                String s = JOptionPane.showInputDialog("Complete the sentence:\n"
                                + "\"Green eggs and...\"");

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
