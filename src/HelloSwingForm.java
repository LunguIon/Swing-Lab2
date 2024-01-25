import javax.swing.*;
import java.awt.*;

public class HelloSwingForm{
    private static void showGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloSwingForm");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello world");
        frame.getContentPane().add(label);
        frame.setSize(300, 300);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                showGUI();
            }
        });
    }
}
