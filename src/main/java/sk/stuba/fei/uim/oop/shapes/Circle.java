package sk.stuba.fei.uim.oop.shapes;

import sk.stuba.fei.uim.oop.gui.Axis;

import java.awt.*;

public class Circle extends Shape {
    public Circle(Axis axis, int radius, Color color) {
        super(axis, radius, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.axis.getX(), this.axis.getY(), this.radius*2, this.radius*2);
    }
}
