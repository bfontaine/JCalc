package jcalc;

import javax.swing.*;

public class JCalc implements Runnable {
    private static final String name = "JCalc";

    public void run() {
        JFrame jf = new JFrame(name);
        JTextField result = new JTextField(20);

        result.setText("0");
        result.setEnabled(false);
        result.setHorizontalAlignment(JTextField.RIGHT);

        jf.add(result);
        jf.pack();

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new JCalc());
    }
}
