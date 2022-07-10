/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

/**
 *
 * @author agusv
 */
public class JDesktopPanePersonalizado extends JDesktopPane {
    private BufferedImage img;
    
    public JDesktopPanePersonalizado(){
        try {
            img=ImageIO.read(getClass().getResourceAsStream("../resources/imgs/inmobiliaria.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        int centradoHorizontal = 50;
        int centradoVertical = 50;
        super.paintComponent(g); 
        // mustra la imagen en el jdesktopPane
        g.drawImage(img, centradoHorizontal, centradoVertical, this);
    }
    
    
}
