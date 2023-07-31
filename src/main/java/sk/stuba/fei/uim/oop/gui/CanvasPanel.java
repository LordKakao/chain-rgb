package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.shapes.Line;
import sk.stuba.fei.uim.oop.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CanvasPanel extends JPanel {
    @Getter
    @Setter
    private List<Shape> shapes;

    @Getter
    private List<Shape> lines;
    public CanvasPanel() {
        this.setSize(700, 800);
        this.setFocusable(false);
        this.setBackground(Color.YELLOW);

        this.shapes = new ArrayList<>();
        this.lines = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.lines.forEach(line -> line.draw(g));
        this.shapes.forEach(shape -> shape.draw(g));
    }

    public void draw() {
        this.lines = new ArrayList<>();
        for(int i = 1; i < shapes.size(); i++) {
            Shape previous = shapes.get(i-1);
            Shape next = shapes.get(i);
            this.lines.add(new Line(new Axis(previous.getAxis().getX()+previous.getRadius(),
                    previous.getAxis().getY()+previous.getRadius()),
                    new Axis(next.getAxis().getX()+next.getRadius(),
                            next.getAxis().getY()+next.getRadius()), 0));
        }
        this.repaint();
    }
}
