package ui.gui;

import exceptions.EmptyStoreException;
import model.Quest;
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
    JButton saveButton;
    JLabel textLabel;
    JLabel latexLabel;

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

        saveButton = new JButton("Save project");
        saveButton.setActionCommand("save");
        add(saveButton);
        saveButton.addActionListener(this);

        textLabel = new JLabel("Day " + mainFrame.model.project.getDay(), JLabel.CENTER);
        add(textLabel, BorderLayout.PAGE_END);
        textLabel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        latexLabel = new JLabel();
        add(latexLabel);

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
                    System.out.println("Tex input received: " + s);
                    setLatex(s, latexLabel);
                    Quest newQuest = new Quest(mainFrame.model.user);
                    newQuest.setTex(s);
                    mainFrame.model.project.addQuestion(newQuest);
                    textLabel.setText("Quest added.");

                    String source = JOptionPane.showInputDialog(
                            "Please describe how this question came to you.\n"
                                    + "(Book, course, inspiration?)\n"
                                    + "Enter source:\n");
                    newQuest.setSource(source);
                } else {
                    textLabel.setText("Cmon, can't make a quest without tex.");
                }

                break;
            case "day":
                System.out.println("Getting a new day!");
                try {
                    Quest q = mainFrame.model.project.sealQuest();
                    setLatex(q.getTex(),latexLabel);

                    mainFrame.model.project.newDay();
                    textLabel.setText("Day " + mainFrame.model.project.getDay());
                } catch (EmptyStoreException ex) {
                    throw new RuntimeException(ex);
                    // FIXME in the end
                }
                break;
            case "all":
                for (Quest q : mainFrame.model.project.getStore()) {
                    JLabel newLabel = new JLabel("Question by "
                            + q.getContributor()
                            + ". Source: \n" + q.getSource());
                    setLatex(q.getTex(),newLabel);
                    add(newLabel);
                }
                break;
            case "save":
                System.out.println(mainFrame.model);
                mainFrame.model.saveProject(mainFrame.model);
                break;

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
