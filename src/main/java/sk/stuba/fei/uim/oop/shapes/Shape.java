package sk.stuba.fei.uim.oop.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.gui.Axis;

import java.awt.*;

@AllArgsConstructor
public abstract class Shape {
    @Getter
    protected Axis axis;
    @Getter
    protected int radius;
    @Setter
    protected Color color;

    public abstract void draw(Graphics g);
}
