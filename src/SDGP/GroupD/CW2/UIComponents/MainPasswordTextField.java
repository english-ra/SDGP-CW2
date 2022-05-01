package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;

public class MainPasswordTextField extends JPasswordField {

    public MainPasswordTextField() {
        super();
        this.setBackground(Colours.offWhite);
        this.setPreferredSize(new Dimension(0, 50));
    }
}
