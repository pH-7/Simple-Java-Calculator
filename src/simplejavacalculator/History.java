package simplejavacalculator;

import javax.swing.*;
import java.awt.*;

public class History extends JFrame{

    private JTextArea textArea1;

    public History(Calculator calc){
        String[] items = new String[20];
        int i=0;
        for(String s : calc.queue) {
            items[i] = s;
            i++;
        }

        this.setSize(500,700);
        this.setVisible(true);
        this.setTitle("History");

        JList<String> l = new JList<>(items);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(l));
        panel.getPreferredSize();
        add(panel);
        revalidate();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
