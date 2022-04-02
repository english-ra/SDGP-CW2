package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import java.awt.*;

public class MainButtonSquare extends MainButton {

    public MainButtonSquare(String text) {
        super(text, Colours.lightFG);

        this.setPreferredSize(new Dimension(125, 125));
    }
}
