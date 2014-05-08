package jcalc;

import java.util.Observer;
import java.util.Observable;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ResultView extends JPanel implements Observer {

    private JTextField result;

    public ResultView() {
        super();

        result = new JTextField(20);

        result.setText("0");
        result.setEnabled(false);
        result.setHorizontalAlignment(JTextField.RIGHT);
        add(result);
    }

    public void update(Observable source, Object data) {
        result.setText(data.toString());
    }
}
