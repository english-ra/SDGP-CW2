package SDGP.GroupD.CW2.UIComponents;

import javax.swing.*;
import java.awt.*;

public class TernarytitleLabel extends JLabel {

    public TernarytitleLabel (String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial Black", Font.ITALIC, 16));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
