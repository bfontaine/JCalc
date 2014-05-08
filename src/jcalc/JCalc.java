package jcalc;

import java.awt.FlowLayout;
import javax.swing.*;

public class JCalc implements Runnable {
    private static final String name = "JCalc";

    public void run() {
        JFrame jf = new JFrame(name);

        final ResultView result = new ResultView();
        final JCalcModel model = new JCalcModel();
        final JCalcController controller = new JCalcController(model);
        final CommandsPanel cmds = new CommandsPanel(controller);

        model.addObserver(result);

        jf.getContentPane().setLayout(new FlowLayout());
        jf.getContentPane().add(result);
        jf.getContentPane().add(cmds);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        result.setVisible(true);
        jf.setVisible(true);
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new JCalc());
    }
}
