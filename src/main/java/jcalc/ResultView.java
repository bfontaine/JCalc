package jcalc;

import java.util.Observer;
import java.util.Observable;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A view for a calculator's current result
 **/
class ResultView extends JPanel implements Observer {

    private JTextField result;

    /**
     * Create a new view with an empty field
     **/
    public ResultView() {
        super();

        result = new JTextField(20);

        result.setEnabled(false);
        result.setHorizontalAlignment(JTextField.RIGHT);
        add(result);
    }

    public void update(Observable source, Object data) {
        result.setText(data.toString());
    }
}
