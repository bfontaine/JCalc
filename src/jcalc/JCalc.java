package jcalc;

import java.awt.*;
import javax.swing.*;

/**
 * The main class of the calculator
 **/
public class JCalc implements Runnable {

    /**
     * The calculator's name. We might want to move this to a l10n file in the
     * future.
     **/
    private static final String name = "JCalc";

    public void run() {
        JFrame jf = new JFrame(name);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final ResultView result = new ResultView();
        final JCalcModel model = new JCalcModel();
        final JCalcController controller = new JCalcController(model);
        final CommandsPanel cmds = new CommandsPanel(controller);

        model.addObserver(result);
        model.reset();

        Container pane = jf.getContentPane();

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(result);
        pane.add(cmds);

        jf.pack();
        result.setVisible(true);
        jf.setVisible(true);
    }


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new JCalc());
    }
}
