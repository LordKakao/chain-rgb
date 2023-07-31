package sk.stuba.fei.uim.oop.shapes;

import sk.stuba.fei.uim.oop.gui.Axis;

import java.awt.*;

public class Hourglass extends Shape {
    public Hourglass(Axis axis, int radius, Color color) {
        super(axis, radius, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillPolygon(new int[]{this.axis.getX(), this.axis.getX()+(2*this.radius), this.axis.getX()+this.radius,
                        this.axis.getX()+this.radius, this.axis.getX(), this.axis.getX()+(2*this.radius)},
                new int[]{this.axis.getY(), this.axis.getY(), this.axis.getY()+radius,
                        this.axis.getY()+radius, this.axis.getY()+(2*radius), this.axis.getY()+(2*radius)},
                6);
    }
}
