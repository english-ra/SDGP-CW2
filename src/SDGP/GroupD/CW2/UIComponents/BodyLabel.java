package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;

public class BodyLabel extends JLabel {

    public BodyLabel(String text) {
        super();

        this.setText(text);
        this.setForeground(Colours.offWhite);
        this.setFont(new Font("", Font.PLAIN, 12));
        this.setHorizontalAlignment(SwingConstants.LEADING);
    }
}
