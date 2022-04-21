import javax.swing.*;
import java.awt.*;
public class QuaternarytitleLabel extends JLabel {
    public QuaternarytitleLabel (String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial Black", Font.ITALIC, 16));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
