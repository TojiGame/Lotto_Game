import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Center extends JPanel {
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public JTextArea getTextArea() {
        return textArea;
    }

    public void losujNLiczb(int n){
        var rand = new Random();
        var stringBuilder = new StringBuilder(256);
        for(int i = 1; i <= n; i++){
            stringBuilder
                    .append(i)
                    .append(") ");
            var nums = new ArrayList<Integer>();
            for(int j = 0; j < 6; j++){
                nums.add(rand.nextInt(50));
            }
            nums.sort(Integer::compareTo);
            for(int j = 0; j < 6; j++){
                stringBuilder
                        .append(nums.get(j))
                        .append(' ');
            }
            stringBuilder.append('\n');
        }
        textArea.setText(stringBuilder.toString());
    }
    public void sprawdzWZakresie(ArrayList<Integer> nums, int n){
        var rand = new Random();
        var string = new StringBuilder(4096);
        for(int i = 0; i < n; i++){
            ArrayList<Integer> nums2 = new ArrayList<>();
            for(int j = 0; j < 6; j++){
                nums2.add(rand.nextInt(50));
            }
            long result = nums
                    .stream()
                    .filter(nums2::contains)
                    .count();
            if(result >= 3){
                string
                        .append(i)
                        .append(") ");
                nums2.sort(Integer::compareTo);
                for(int j = 0; j < 6; j++){
                    string
                            .append(nums2.get(j))
                            .append(' ');
                }
                string
                        .append("T=")
                        .append(result)
                        .append('\n');
            }
        }
        textArea.setText(string.toString());
    }
    public Center(){
        this.setLayout(new BorderLayout());
        textArea.setEditable(false);
        this.add(scroll);
    }
}
