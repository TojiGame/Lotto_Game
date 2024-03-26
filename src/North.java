import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class North extends JPanel {

    ArrayList<JTextField> textFields = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();

    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }

    public void losuj6liczb(){
        var rand = new Random();
        ArrayList<Integer> nums= new ArrayList<>();
        for(int i = 0; i < 6; i++){
            nums.add(rand.nextInt(50));
        }
        nums.sort(Integer::compareTo);
        for (int i = 0; i < 6; i++) {
            textFields.get(i).setText(String.valueOf(nums.get(i)));
        }

    }
    public North(){
        this.setLayout(new GridLayout(2, 6));
        for(int i = 1; i <= 6; i++){
            textFields.add(new JTextField());
            textFields.get(i-1).setEditable(false);
            labels.add(new JLabel("Liczba " + i));
            labels.get(i-1).setHorizontalAlignment(JLabel.CENTER);
            this.add(labels.get(i-1));
        }
        for(int i = 0; i < 6; i++){
            this.add(textFields.get(i));
        }
    }

}
