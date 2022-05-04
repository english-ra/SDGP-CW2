// Authored by Reece English

package SDGP.GroupD.CW2.UIComponents;

import SDGP.GroupD.CW2.Constants.Colours;

import javax.swing.*;
import java.awt.*;

public class ScrollableList extends JScrollPane {

    public JList list;

    public ScrollableList(String[] items) {
        super();

        // Configure the list
        list = new JList(items);
        this.setViewportView(list);

        // Configure the lists cells
        list.setFixedCellHeight(50);
        list.setSelectionBackground(Colours.mainFG);

        // Configure the text in the list
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
