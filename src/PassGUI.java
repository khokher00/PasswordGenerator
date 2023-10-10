import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PassGUI extends JFrame {
    private JPanel root;
    private JLabel tvPass;
    private JSlider slider;
    private JLabel tvLength;
    private JPanel btHolder;

    Button bt ;
    private final Button.OnClick cli= new Button.OnClick() {
        @Override
        public void onClick() {
            tvPass.setText(PasswordGenerator.generatePassword(slider.getValue(), bt.isA, bt.isa
                    , bt.is0, bt.isSp));
        }

        @Override
        public void onClose() {
            dispose();
        }

        @Override
        public void onCopy() {
            StringSelection stringSelection = new StringSelection(tvPass.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    };

    public PassGUI() {

        this.add(root);
        this.slider.addChangeListener(e -> tvLength.setText("Length : "+slider.getValue()));

        this.btHolder.setLayout(new GridLayout(1,1));
       bt = new Button(cli);
        btHolder.add(bt);
    }
}
