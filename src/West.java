import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class West extends JPanel implements ActionListener {
    JRadioButton radio1 = new JRadioButton("Losuj 6 liczb");
    JRadioButton radio2 = new JRadioButton("Losuj n zakładów");
    JRadioButton radio3 = new JRadioButton("Sprawdź w zakresie");
    public JRadioButton getRadio1() {
        return radio1;
    }

    public JRadioButton getRadio2() {
        return radio2;
    }

    public JRadioButton getRadio3() {
        return radio3;
    }
    public JTextField getResult() {
        return result;
    }
    JLabel label = new JLabel("Wartość n");
    JTextField result = new JTextField();
    ButtonGroup radioGroup = new ButtonGroup();
    public West(){
        this.setLayout(new GridLayout(5, 1));
        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);

        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);

        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
        this.add(label);
        this.add(result);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result.setEditable(!radio1.isSelected());
    }
}
