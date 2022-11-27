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

// Panel with all buttons
public class MenuPanel extends JPanel implements ActionListener {
    protected MainFrame mainFrame;
    JButton addQuestButton;
    JButton todayButton;
    JButton allQuestButton;
    JButton saveButton;
    JLabel textLabel;
    JLabel latexLabel;
    JPanel storeDisplay; // pack up shop

    //add buttons with action listener
    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        addButtons();

        textLabel = new JLabel("Day " + mainFrame.model.project.getDay(), JLabel.CENTER);
        add(textLabel, BorderLayout.PAGE_END);
        textLabel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        latexLabel = new JLabel();
        add(latexLabel);

        storeDisplay = new JPanel();
        // do not add to this or main frame

        setOpaque(true);
    }

    // EFFECTS: adds buttons with actionlistener
    private void addButtons() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.remove(storeDisplay);
        switch (e.getActionCommand()) {
            case "add":
                addQuest();
                break;
            case "day":
                newDay();
                break;
            case "all":
                getStore();
                break;
            case "save":
                mainFrame.model.saveProject(mainFrame.model);
                textLabel.setText("Safe.");
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

    // EFFECTS: dialog to add a question with source by current user
    void addQuest() {
        // If this case is reached, say so
        textLabel.setText("Adding a quest!");

        String s = JOptionPane.showInputDialog("Give me some \"inverted\" inline latex.\n"
                + "(All text to be enclosed in \\textrm{} and all math to be wild.)",
                "\\textrm{Integrate } \\int \\sqrt{1+e^x} dx.");

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            // System.out.println("Tex input received: " + s);
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
    }

    // EFFECTS: post a question from store and increment day number
    void newDay() {
        // System.out.println("Getting a new day!");
        try {
            Quest q = mainFrame.model.project.sealQuest();
            setLatex(q.getTex(),latexLabel);

            mainFrame.model.project.incrementDay();
            textLabel.setText("Day " + mainFrame.model.project.getDay()
                    + "\n--"
                    + q.getContributor().getName() + " & Source: " + q.getSource());
        } catch (EmptyStoreException ex) {
            textLabel.setText("Nothing in store. Put something in there quick!");
        }
    }

    // EFFECTS: post all questions in store
    // REQUIRES: non-empty store
    void getStore() {
        for (Quest q : mainFrame.model.project.getStore()) {
            JLabel newLabel = new JLabel();
            setLatex(q.getTex(),newLabel);
            storeDisplay.add(newLabel);
        }
        mainFrame.add(new JScrollPane(storeDisplay),BorderLayout.PAGE_END);
    }
}
