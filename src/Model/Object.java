package Model;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

abstract public class Object {
    public AffineTransform t;
    abstract public void drawMe(Graphics g);
    abstract public void rotate();
}