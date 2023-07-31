package sk.stuba.fei.uim.oop.shapes;

import sk.stuba.fei.uim.oop.gui.Axis;

import java.awt.*;

public class Line extends Shape {
    private Axis axisEnd;

    public Line(Axis axis, Axis axisEnd, int radius) {
        super(axis, radius, Color.BLACK);
        this.axisEnd = axisEnd;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawLine(this.axis.getX(), this.axis.getY(), this.axisEnd.getX(), this.axisEnd.getY());
    }
}
