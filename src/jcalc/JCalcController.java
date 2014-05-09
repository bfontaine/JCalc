package jcalc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * A controller for a calculator
 **/
class JCalcController implements ActionListener {
    private JCalcModel m;

    private static Logger logger = Logger.getLogger("jcalc.JCalcController");

    /**
     * Create a new controller associated with a model
     * @param m the model
     **/
    public JCalcController(JCalcModel m) {
        this.m = m;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action == "number") {
            DigitButton b = (DigitButton)e.getSource();
            this.m.appendDigit(b.getValue());
            return;
        }

        if (action == "operation") {
            OperationButton b = (OperationButton)e.getSource();
            this.m.executeOperation(b.getValue());
            return;
        }

        if (action == "push") {
            this.m.push();
            return;
        }

        if (action == "reset") {
            this.m.reset();
            return;
        }

        logger.warning("Unknown actionCommand: " + action);

    }
}
