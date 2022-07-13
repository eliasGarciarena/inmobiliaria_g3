/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author agusv
 */
public class JPanelInicioPersonalizado  extends JPanel  {
    
     private BufferedImage img;
     
    
    public JPanelInicioPersonalizado(){
        try {
            img=ImageIO.read(getClass().getResourceAsStream("/imgs/inmobiliaria.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }    
}
