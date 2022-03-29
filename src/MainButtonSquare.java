import javax.swing.*;
import java.awt.*;

public class MainButtonSquare extends MainButton {

    public MainButtonSquare(String text) {
        super(text);

        this.setPreferredSize(new Dimension(125, 125));
    }
}
