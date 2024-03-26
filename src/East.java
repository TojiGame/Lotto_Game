import javax.swing.*;
import java.awt.*;

public class East extends JPanel {

    JButton button1 = new JButton("START");
    JButton button2 = new JButton("CLEAR N");
    JButton button3 = new JButton("CLEAR C");
    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }
    public East(){
        this.setLayout(new GridLayout(3, 1));
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }
}
