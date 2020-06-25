/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author isaac
 */
public class Gradiente extends JPanel{
    protected void paintComponent (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        
        Color color1 = new Color(255,51,51);
        Color color2 = new Color(255,255,255);
        
        GradientPaint gp = new GradientPaint(0,0, color1, 1000, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
    
}