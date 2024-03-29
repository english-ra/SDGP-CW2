// Authored by Reece English

package SDGP.GroupD.CW2.UIComponents;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {

    public TitleLabel(String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Helvetica Neue", Font.BOLD, 38));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
