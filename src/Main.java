import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {

    North north = new North();
    East east = new East();
    West west = new West();
    Center center = new Center();

    public void initUI() {

        this.setLayout(new BorderLayout());
        this.add(north, BorderLayout.NORTH);
        this.add(east, BorderLayout.EAST);
        this.add(west, BorderLayout.WEST);

        east.getButton1().addActionListener(this);

        east.getButton2().addActionListener(e -> north.getTextFields().forEach(k -> k.setText("")));
        east.getButton3().addActionListener(e -> center.getTextArea().setText(""));

        this.add(center, BorderLayout.CENTER);
        this.add(new JLabel("Lotto"), BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.initUI();
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public Integer checkNInput() {
        if (west.getResult().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Wprowadź N");
            return null;
        }
        int result = tryParse(west.getResult().getText());
        if (result == -1) {
            JOptionPane.showMessageDialog(null,
                    "Wprowadź liczbę całkowitą");
            return null;
        }
        return result;
    }
    public ArrayList<Integer> checkInputs(){
        if(!north.getTextFields().get(0).getText().isEmpty()){
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < 6; i++){
                nums.add(Integer.parseInt(north.getTextFields().get(i).getText()));
            }
            return nums;
        }
        JOptionPane.showMessageDialog(null,
                "Najpierw wylosuj 6 liczb");
        return null;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(west.getRadio1().isSelected()){
            north.losuj6liczb();
            return;
        }
        Integer result = checkNInput();
        if(west.getRadio2().isSelected()){
            if(result != null) {
                center.losujNLiczb(result);
            }
        }
        if(west.getRadio3().isSelected()
                && checkInputs() != null
                && result != null){
            ArrayList<Integer> nums = checkInputs();
            center.sprawdzWZakresie(nums, result);
        }
    }
}