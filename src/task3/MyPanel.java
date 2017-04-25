package task3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

class MyPanel extends JPanel {
    JLabel aDiscription;
    JTextField tf_a;
    JLabel bDiscription;
    JTextField tf_b;
    JLabel hDiscription;
    JTextField tf_h;
    JButton button;

    JLabel erMessange;
    JTextField error;

    MyTableModel model;
    JTable table;
    JScrollPane scrollPane;
    String[] columnNames = {"x","F(x)"};
    double[][] data;

    MyPanel() {
        setLayout(null);
        aDiscription = new JLabel("Enter a:");
        tf_a = new JTextField();
        bDiscription = new JLabel("Enter b:");
        tf_b = new JTextField();
        hDiscription = new JLabel("Enter h:");
        tf_h = new JTextField();
        button = new JButton("Build function");

        error = new JTextField();
        erMessange = new JLabel("Message");

        aDiscription.setBounds(20,0,80,30);
        tf_a.setBounds(110,0,100,30);
        bDiscription.setBounds(20,50,80,30);
        tf_b.setBounds(110,50,100,30);
        hDiscription.setBounds(20,100,80,30);
        tf_h.setBounds(110,100,100,30);
        button.setBounds(250,100,200,50);

        erMessange.setBounds(20, 670, 100, 30);
        error.setBounds(150, 670, 200, 30);

        add(aDiscription);
        add(bDiscription);
        add(hDiscription);
        add(tf_a);
        add(tf_b);
        add(tf_h);
        add(button);

        add(erMessange);
        add(error);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                m:
                {
                    double a = Double.parseDouble(tf_a.getText());
                    double b = Double.parseDouble(tf_b.getText());
                    System.out.println("b = " + b);
                    double h = Double.parseDouble(tf_h.getText());

                    if (b <= a) {
                        error.setText("Error! b should be > a");
                        System.out.println("Error! b should be > a");
                        break m;
                    }
                    if (h == 0) {
                        error.setText("Error! h couldn't = 0");
                        System.out.println("Error! h couldn't = 0");
                        break m;
                    }
                    double x;
                    double f;
                    data = new double[(int) ((b - a) / h + 1)][2];
                    for (int i = 0; i <= (b - a) / h; i++) {
                        x = a + i * h;
                        f = Math.tan(2 * x) - 3;

                        data[i][0] = new BigDecimal(x).setScale(3, RoundingMode.UP).doubleValue();
                        data[i][1] = new BigDecimal(f).setScale(3, RoundingMode.UP).doubleValue();

                    }

                    model = new MyTableModel(data, columnNames);
                    table = new JTable(model);
                    scrollPane = new JScrollPane(table);

                    scrollPane.setBounds(20, 200, 300, 400);
                    add(scrollPane);
                    error.setText("Done!");
                    //model.fireTableDataChanged();
                }

            }
        });

    }
}