import javax.swing.*;

public class ScrollableList extends JScrollPane {

    public JList list;

    public ScrollableList(String[] items) {
        super();
        list = new JList(items);
        this.setViewportView(list);

        list.setFixedCellHeight(50);
    }
}
