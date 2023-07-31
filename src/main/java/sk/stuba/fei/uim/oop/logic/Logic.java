package sk.stuba.fei.uim.oop.logic;

import sk.stuba.fei.uim.oop.enums.Shapes;
import sk.stuba.fei.uim.oop.gui.Axis;
import sk.stuba.fei.uim.oop.gui.MainFrame;
import sk.stuba.fei.uim.oop.gui.ManuPanel;
import sk.stuba.fei.uim.oop.shapes.Circle;
import sk.stuba.fei.uim.oop.shapes.Hourglass;
import sk.stuba.fei.uim.oop.shapes.Square;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Logic extends UniversalAdapter {
    private MainFrame mainFrame;
    private List<Axis> dots;
    private int currentSpacing;
    private int currentLength;
    private int currentRadius;
    private Shapes currentShape;

    public Logic(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.dots = new ArrayList<>();
        this.currentRadius = ManuPanel.RADIUS_INITIAL_VALUE;
        this.currentLength = ManuPanel.LENGTH_INITIAL_VALUE;
        this.currentSpacing = ManuPanel.SPACING_INITIAL_VALUE;
        this.currentShape = Shapes.CIRCLE;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSlider && !((JSlider)e.getSource()).getValueIsAdjusting()) {
            if(e.getSource().equals(this.mainFrame.getMenu().getLenghtSL())) {
                this.currentLength = ((JSlider)e.getSource()).getValue();
            } else if(e.getSource().equals(this.mainFrame.getMenu().getSpacingSL())) {
                this.currentSpacing = ((JSlider)e.getSource()).getValue();
            } else if(e.getSource().equals(this.mainFrame.getMenu().getRadiusSL())) {
                this.currentRadius = ((JSlider)e.getSource()).getValue();
            }

            this.createShapes();
            this.mainFrame.getCanvasPanel().draw();

            this.mainFrame.setFocusable(true);
            this.mainFrame.requestFocus();
            this.mainFrame.repaint();
            this.mainFrame.revalidate();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() instanceof JComboBox) {
            this.currentShape = (Shapes) ((JComboBox) e.getSource()).getSelectedItem();

            this.createShapes();
            this.mainFrame.getCanvasPanel().draw();

            this.mainFrame.setFocusable(true);
            this.mainFrame.requestFocus();
            this.mainFrame.repaint();
            this.mainFrame.revalidate();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        drawShapes(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawShapes(e);
    }

    private void createShapes() {
        this.mainFrame.getCanvasPanel().setShapes(new ArrayList<>());
        int hue = 0;
        for(int i = 0; i < dots.size(); i++){
            if(i == 0 || i == dots.size()-1 || i%this.currentSpacing == 0) {
                Axis axis = dots.get(i);
                if(Shapes.CIRCLE.equals(this.currentShape)) {
                    this.mainFrame.getCanvasPanel().getShapes().add(new Circle(axis, this.currentRadius, this.computeColor(hue++)));
                } else if (Shapes.SQUARE.equals(this.currentShape)) {
                    this.mainFrame.getCanvasPanel().getShapes().add(new Square(axis, this.currentRadius, this.computeColor(hue++)));
                } else {
                    this.mainFrame.getCanvasPanel().getShapes().add(new Hourglass(axis, this.currentRadius, this.computeColor(hue++)));
                }
            }
        }
    }

    private void drawShapes(MouseEvent e) {
        this.resolveMovement(new Axis(e.getX(), e.getY()));
        this.createShapes();
        this.mainFrame.getCanvasPanel().draw();

        this.mainFrame.setFocusable(true);
        this.mainFrame.requestFocus();
        this.mainFrame.repaint();
        this.mainFrame.revalidate();
    }

    private Color computeColor(float i) {
        float hue = ( i/ this.dots.size() ) + 1.0f;
        return Color.getHSBColor(hue, 1, 1);
    }

    private void resolveMovement(Axis axis) {
        this.dots.add(axis);
        if(this.currentLength < this.dots.size()){
            List<Axis> dotsToRemove = new ArrayList<>();
            for(int i = 0; i < this.dots.size()-this.currentLength; i++) {
                dotsToRemove.add(this.dots.get(i));
            }

            this.dots.removeAll(dotsToRemove);
        }
    }
}
