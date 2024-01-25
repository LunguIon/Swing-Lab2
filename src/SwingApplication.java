import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingApplication implements ActionListener {
    private static final String LABEL_PREFIX = "Number of button clicks : ";
    private int numClicks = 0;
    final JLabel label = new JLabel(LABEL_PREFIX + "0   ");
    final static String LOOKANDFELL = "Motif";
    

    public Component createComponent(){
        JButton button = new JButton("I am Swing button");
        button.setMnemonic(KeyEvent.VK_I);
        button.addActionListener(this);
        label.setLabelFor(button);

        JButton button1 = new JButton("I'm 2nd Swing button!");
        button1.setMnemonic(KeyEvent.VK_L);
        button1.addActionListener(this);
        label.setLabelFor(button1);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(button);
        panel.add(button1);
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("I am Swing button")){
            numClicks++;
        }else{
            numClicks += 1000;
        }
        label.setText(LABEL_PREFIX + numClicks);
    }
    
    private static void initLookAndFeel(){
        String lookAndFeel = null;
        if(LOOKANDFELL != null){
            lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        }else if(LOOKANDFELL.equals("System")){
            lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        } else if (LOOKANDFELL.equals("Motif")) {
            lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else if (LOOKANDFELL.equals("GTK+")) {
            lookAndFeel = "com.sun.java.swing.plaf.GTKLookAndFeel";
        }else{
            System.err.println("Unexpected value of LOOKANDFELL specified : " + LOOKANDFELL);
        }

        try{
            UIManager.setLookAndFeel(lookAndFeel);
        }catch(ClassNotFoundException e){
            System.err.println("Couldn't find class for specified look and fell :" + lookAndFeel);
            System.err.println("Did you include the L&F library in the class path?");
            System.err.println("Using the default look and fell.");
        }catch (UnsupportedLookAndFeelException e){
            System.err.println("Can't use the specified look and feel(" + lookAndFeel + ") on this platform");
            System.err.println("Using the default look and fell");
        }catch (Exception e){
            System.err.println("Couldn't get specified look and feel(" + lookAndFeel + "), for some reason");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }

    }

    private static void createAndShowGUI(){
        initLookAndFeel();

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("SwingApplication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingApplication app = new SwingApplication();
        Component contents = app.createComponent();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(SwingApplication::createAndShowGUI);
    }
   
}
