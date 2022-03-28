import javax.swing.*;
import java.awt.*;

public class BodyLabel extends JLabel {

    public BodyLabel(String text) {
        super();

        this.setText(text);
        this.setForeground(Colours.lightFG);
        this.setFont(new Font("", Font.PLAIN, 12));
        this.setHorizontalAlignment(SwingConstants.LEADING);
    }
}
