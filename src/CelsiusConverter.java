import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusConverter extends JFrame {
    private JTextField celsiusTextField;
    private JLabel fahrenheitLabel;

    public CelsiusConverter() {
        createUI();
    }

    private void createUI() {
        setTitle("Convert Celsius to Fahrenheit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(null); // Not recommended, but used here for simplicity

        celsiusTextField = new JTextField("37.0");
        celsiusTextField.setBounds(50, 20, 100, 30);
        add(celsiusTextField);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(50, 60, 100, 30);
        add(convertButton);

        fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitLabel.setBounds(50, 100, 150, 30);
        add(fahrenheitLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusTextField.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            fahrenheitLabel.setText("Fahrenheit: " + fahrenheit);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CelsiusConverter().setVisible(true);
            }
        });
    }
}
