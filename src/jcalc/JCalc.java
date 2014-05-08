package jcalc;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JCalc implements Runnable {
    private static final String name = "JCalc";

    public void run() {
        JFrame jf = new JFrame(name);

        final JCalcView view = new JCalcView();
        final JCalcModel model = new JCalcModel();
        final JCalcController controller = new JCalcController(model);

        model.addObserver(view);
        jf.add(view);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        view.setVisible(true);
        jf.setVisible(true);
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new JCalc());
    }
}
