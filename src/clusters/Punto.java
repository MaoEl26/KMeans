package clusters;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcv26
 */

import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;

public class Punto extends JComponent {
    private int escalar = 20;
    private Graphics2D graph2;
    private Color color = Color.red;
    private int coorX = 2,coorY = 2;
    
    @Override
    public void paint(Graphics g){
        graph2 = (Graphics2D)g;
        graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graph2.setPaint(color);
        graph2.fillOval(coorX,coorY,escalar,escalar);
}
    public void setColor(Color color){
        this.color = color;
    }
    public void setEscala(int escalar){
        this.escalar = escalar;
    }
    public void setCoords(Float x, Float y){
        this.coorX = (x.intValue()*10)+100;
        this.coorY = (y.intValue()*10)+100;
    }
}
