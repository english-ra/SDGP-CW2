import javax.swing.*;
import java.awt.*;

public class SubtitleLabel extends JLabel {

    public SubtitleLabel(String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial Black", Font.ITALIC, 16));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
