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
            this.m.pushValue(((NumberButton)e.getSource()).getValue());
            return;
        }

        if (e.getActionCommand() == "operation") {
            this.m.executeOperation(((OperationButton)e.getSource()).getOp());
            return;
        }
    }
}
