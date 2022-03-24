import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {

    public TitleLabel(String text) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial Black", Font.BOLD, 38));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
