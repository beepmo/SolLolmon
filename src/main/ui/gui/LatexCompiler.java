package ui.gui;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LatexCompiler extends JFrame {
    public LatexCompiler() {
        super("How does jlatexmath work");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        JFrame app = new LatexCompiler();

        String tex = "\\textrm{How do you like a string newline?}"
                + "\\begin{align} \\begin{matrix} 1 & 0 \\\\ 0 & 1 \\end{matrix} \\end{align}"
                + "\n And see if this is on a new line"
                + "\n $$\\Sigma$$";
        TeXFormula teXFormula = new TeXFormula(tex);
        TeXIcon teXIcon = teXFormula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 40);
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

        teXIcon.paintIcon(new JLabel(), bufferedImage.getGraphics(), 0, 0);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.gray);

        JLabel texLabel = new JLabel();
        texLabel.setIcon(teXIcon);

        app.add(texLabel);
        app.setVisible(true);

    }
}

