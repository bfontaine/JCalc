package jcalc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A controller for a calculator
 **/
class JCalcController implements ActionListener {
    private JCalcModel m;

    /**
     * Create a new controller associated with a model
     * @param m the model
     **/
    public JCalcController(JCalcModel m) {
        this.m = m;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "number") {
            DigitButton b = (DigitButton)e.getSource();
            this.m.pushValue(b.getValue());
            return;
        }

        if (e.getActionCommand() == "operation") {
            OperationButton b = (OperationButton)e.getSource();
            this.m.executeOperation(b.getOp());
            return;
        }
    }
}
