
import java.awt.*;

public class PlainButton extends MainButton {

    public PlainButton(String text) {
          super(text);

        this.setColor(Colours.mainBG);
        this.setBorderColor(Colours.mainBG);
        this.setColorOver(Colours.mainBG);
        this.setForeground(Color.WHITE);
        this.setColorClick(Colours.fiftyPercent);
    }
}

