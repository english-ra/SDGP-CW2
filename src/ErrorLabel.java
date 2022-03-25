import javax.swing.*;
import java.awt.*;

public class ErrorLabel extends JLabel {

    public ErrorLabel(String text) {
        super();

        this.setText(text);
        this.setForeground(Color.RED);
        this.setFont(new Font("", Font.PLAIN, 12));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
