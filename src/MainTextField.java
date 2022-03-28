import javax.swing.*;
import java.awt.*;

public class MainTextField extends JTextField {

    public MainTextField(String text) {
        super(text);
        this.setBackground(Colours.lightFG);
        this.setPreferredSize(new Dimension(0, 50));
    }
}
