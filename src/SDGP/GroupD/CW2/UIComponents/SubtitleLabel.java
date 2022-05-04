// Authored by Reece English

package SDGP.GroupD.CW2.UIComponents;

import javax.swing.*;
import java.awt.*;

public class SubtitleLabel extends JLabel {

    public SubtitleLabel(String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Helvetica Neue", Font.ITALIC, 16));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
