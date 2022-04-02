import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MainButton extends JButton {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;


    public MainButton(String text, Color backgroundColour) {
        this.setText(text);
        this.setColor(backgroundColour);
        this.setBorderColor(backgroundColour);
        this.setColorOver(Colours.lighterButton);
        this.setColorClick(Colours.lighterButton.darker());
        this.setRadius(50);

        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);

        this.setPreferredSize(new Dimension(0, 50));

        configureListeners();
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    private void configureListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) { setBackground(colorOver); }
                else { setBackground(color); }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphic = (Graphics2D) graphics;
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //  Paint Border
        graphic.setColor(borderColor);
        graphic.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        graphic.setColor(getBackground());

        //  Border set 2 Pix
        graphic.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        super.paintComponent(graphics);
    }
}
