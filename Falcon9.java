package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.ModelKey;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import com.jme3.scene.shape.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Falcon9 extends SimpleApplication {

    @Override
    public void simpleInitApp() {
    setDisplayFps(false);
      setDisplayStatView(false);
        flyCam.setDragToRotate(true);
         viewPort.setBackgroundColor(ColorRGBA.White);    
        Spatial teapot = assetManager.loadModel("Models/Falcon9.j3o");
      DirectionalLight sun = new DirectionalLight();
sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f).normalizeLocal());
rootNode.addLight(sun);
        teapot.center();
        rootNode.attachChild(teapot);

    }
 public static JFrame window;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppSettings settings = new AppSettings(true);
                int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                int screenLength = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                settings.setWidth(640);
                settings.setHeight(480);
                Falcon9 canvasApplication = new Falcon9();
                canvasApplication.setSettings(settings);
                canvasApplication.createCanvas();
                JmeCanvasContext ctx = (JmeCanvasContext) canvasApplication.getContext();
                ctx.setSystemListener(canvasApplication);
                Dimension dim = new Dimension(screenWidth * 2 / 3, screenLength);
                ctx.getCanvas().setPreferredSize(dim);
              window = new JFrame("");
                window.getContentPane().setLayout(null);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.setUndecorated(true);
                window.setVisible(true); 
                JLabel title = new JLabel("Falcon 9");
                window.add(title);
                JPanel panel = new JPanel();
                panel.add(ctx.getCanvas());
                panel.setBounds(screenWidth * 1 / 3, 0, screenWidth * 2 / 3, screenLength);
                panel.setBackground(new java.awt.Color(50, 50, 50));
                window.add(panel);
                JPanel text = new JPanel();
                text.setLayout(null);

                text.setBounds(0, 0, screenWidth / 3, screenLength);
                text.setBackground(new java.awt.Color(50, 50, 50));

                JButton exit = new JButton("Exit");
                exit.setBounds(0, 0, (int) (screenWidth * 0.03), (int) (screenWidth * 0.02));
                exit.setText("Exit");
                text.add(exit);
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                JButton return2 = new JButton("Return to Menu");
                return2.setBounds(0, (int) (screenLength * 0.97), (int) (screenLength * 0.12), (int) (screenLength * 0.03));
                return2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SpacethingMainMenu.main(null);
                        window.dispose();
                    }
                });
                text.add(return2);
                
                ScrollPane scroll = new ScrollPane();
                text.add(scroll);
                scroll.setSize(screenWidth/3,screenLength);
                window.add(text);
                canvasApplication.startCanvas();
                TextArea textarea = new TextArea();               
                scroll.add(textarea);
                textarea.setBackground(new java.awt.Color(50, 50, 50));
               // textarea.setEnabled(false);
                textarea.setForeground(new java.awt.Color(255,255,255));
                textarea.setText("\n \n \nThe Falcon 9 is a rocket that was first launched in 2010. The craft used 2 SpaceX Merlin engines, which use cryogenic liquid oxygen and rocket-grade kerosene as its propellants. It has since gone through 2 upgrades. The versions are 1.0, 1.1, and 1.2. What makes the Falcon 9 special is that it is partially reusable. Its first stage is capable of reentering the atmosphere and being recovered for later use.");
                textarea.setFocusable(false);
            }
        });
    }
}
