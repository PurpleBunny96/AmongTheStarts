package mygame;



import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class SpacethingMainMenu extends javax.swing.JFrame {
 public static   JFrame frame;
    public static void main(String args[]) {
        int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenLength = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    frame = new JFrame("Rocket");
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);

        JPanel rocketOptions = new JPanel();
        rocketOptions.setBounds(0, (int) (screenLength * 0.82), screenWidth, (int) (screenLength * 0.18));
        rocketOptions.setBackground(new java.awt.Color(255, 255, 255));
  TextArea textarea = new TextArea();  
  textarea.setBounds(screenWidth / 6 * 5, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
  textarea.setText("USE WASD and the mouse to move around");
   textarea.setBackground(new java.awt.Color(255, 255, 255));
   rocketOptions.add(textarea);
        JButton falcon = new JButton();
        falcon.setText("Falcon 9");
        falcon.setBounds(0, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
        rocketOptions.add(falcon);
        falcon.setBackground(new java.awt.Color(255, 255, 255));
        falcon.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                Falcon9.main(null);
                frame.dispose();
            }
        });

        JButton warpDrive = new JButton();
        warpDrive.setText("Warp Drive");
        warpDrive.setBounds(screenWidth / 6, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
        rocketOptions.add(warpDrive);
        warpDrive.setBackground(new java.awt.Color(255, 255, 255));
    warpDrive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WarpDrive.main(null);
                frame.dispose();
            }
        });
        JButton ion = new JButton();
        ion.setText("Electrothermal & Ion Drive");
        ion.setBounds(screenWidth / 6 * 2, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
        rocketOptions.add(ion);
        ion.setBackground(new java.awt.Color(255, 255, 255));
ion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ionE.main(null);
                frame.dispose();
            }
        });
        JButton solarSail = new JButton();
        solarSail.setText("Solar Sail");
        solarSail.setBounds(screenWidth / 6 * 3, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
        rocketOptions.add(solarSail);
        solarSail.setBackground(new java.awt.Color(255, 255, 255));
solarSail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              SolairSail.main(null);
                frame.dispose();
            }
        });
        

        JButton continuous = new JButton();
        continuous.setText("Saturn V");
        continuous.setBounds(screenWidth / 6 * 4, (int) (screenLength * 0.02), screenWidth / 6, (int) (screenLength * 0.14));
        rocketOptions.add(continuous);
        continuous.setBackground(new java.awt.Color(255, 255, 255));
continuous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              SaturnV.main(null);
                frame.dispose();
            }
        });
        frame.add(rocketOptions);

        JButton exit = new JButton();
        exit.setBounds((int) (screenWidth * 0.97), 0, (int) (screenWidth * 0.03), (int) (screenWidth * 0.03));
        exit.setText("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(exit);
       
    }
}
