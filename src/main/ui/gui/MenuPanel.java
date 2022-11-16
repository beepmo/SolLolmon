package ui.gui;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MenuPanel extends JPanel implements ActionListener {

    protected MainFrame mainFrame;
    JButton addQuestButton;
    JButton todayButton;
    JButton allQuestButton;
    JButton loadButton;
    JLabel textLabel;

    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

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

        textLabel = new JLabel("Day 1", JLabel.CENTER);
        add(textLabel, BorderLayout.PAGE_END);
        textLabel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                // If this case is reached, say so
                textLabel.setText("Adding a quest!");

                String s = JOptionPane.showInputDialog("Complete the sentence:\n"
                                + "\"Green eggs and...\"");

                //If a string was returned, say so.
                if ((s != null) && (s.length() > 0)) {
                    JLabel latexLabel = new JLabel();
                    setLatex(s, latexLabel);
                    add(latexLabel);
                    textLabel.setText("Quest added.");
                    break;
                }

                textLabel.setText("Cmon, add a tex.");
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

    // EFFECTS: puts latex on given label
    private void setLatex(String s, JLabel label) {
        TeXFormula teXFormula = new TeXFormula(s);
        TeXIcon teXIcon = teXFormula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 40);
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

        teXIcon.paintIcon(new JLabel(), bufferedImage.getGraphics(), 0, 0);
        label.setIcon(teXIcon);
    }


}
