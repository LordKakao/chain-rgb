package sk.stuba.fei.uim.oop.shapes;

import sk.stuba.fei.uim.oop.gui.Axis;

import java.awt.*;

public class Square extends Shape {
    public Square(Axis axis, int radius, Color color) {
        super(axis, radius, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.axis.getX(), this.axis.getY(), this.radius*2, this.radius*2);
    }
}
