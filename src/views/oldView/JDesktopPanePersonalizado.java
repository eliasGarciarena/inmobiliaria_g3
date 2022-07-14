package views.oldView;

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
