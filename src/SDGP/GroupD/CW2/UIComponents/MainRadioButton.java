package SDGP.GroupD.CW2.UIComponents;

import javax.swing.*;
import java.awt.*;

public class MainRadioButton extends JRadioButton {

    public MainRadioButton(String text) {
        super(text);

        configureStyling();
    }

    private void configureStyling() {
        this.setForeground(Color.WHITE);
    }
}
