// Authored by Reece English

package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;

public class MainTextField extends JTextField {

    public MainTextField(String text) {
        super(text);
        this.setBackground(Colours.offWhite);
        this.setPreferredSize(new Dimension(0, 50));
    }
}
