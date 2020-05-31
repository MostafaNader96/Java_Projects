/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.*;
import java.awt.*;

public class image extends Applet {
Image picture;
    
    public void init() {
    picture = getImage(getDocumentBase(),"pic.jpg"); 
  
    }
    public void paint(Graphics g) {
    g.drawImage(picture, 0,0,getWidth(),getHeight(), this);
    //g.drawImage(picture, WIDTH, WIDTH, WIDTH, HEIGHT, this)
    }
    // TODO overwrite start(), stop() and destroy() methods
}
