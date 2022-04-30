package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {

    public TextArea(String text) {
        super(text);

        this.setLineWrap(true);
        this.setBackground(Colours.transparent);
        this.setForeground(Color.WHITE);
        this.setEditable(false);
        this.setHighlighter(null);
        this.setFont(new Font("", Font.PLAIN, 16));
    }
}
