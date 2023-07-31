package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import sk.stuba.fei.uim.oop.enums.Shapes;

import javax.swing.*;
import java.awt.*;

public class ManuPanel extends JPanel {
    public static final int SPACING_INITIAL_VALUE = 5;
    public static final int RADIUS_INITIAL_VALUE = 5;
    public static final int LENGHT_INITIAL_VALUE = 50;

    @Getter
    private JSlider lenghtSL;
    @Getter
    private JSlider radiusSL;
    @Getter
    private JSlider spacingSL;
    @Getter
    private JComboBox shapeCB;

    private JLabel lenghtLB;
    private JLabel radiusLB;
    private JLabel spacingLB;
    public ManuPanel() {
        this.setSize(new Dimension(100, 800));
        this.setFocusable(false);
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());

        this.lenghtLB = new JLabel("Lenght");
        this.radiusLB = new JLabel("Radius");
        this.spacingLB = new JLabel("Spacing");

        this.lenghtSL = new JSlider();
        this.lenghtSL.setMinimum(20);
        this.lenghtSL.setMaximum(200);
        this.lenghtSL.setSnapToTicks(true);
        this.lenghtSL.setValue(LENGHT_INITIAL_VALUE);
        this.lenghtSL.setPaintTicks(true);
        this.lenghtSL.setPaintLabels(true);
        this.lenghtSL.setPaintTrack(true);
        this.lenghtSL.setMajorTickSpacing(10);
        this.lenghtSL.setMinorTickSpacing(0);
        this.lenghtSL.setOrientation(JSlider.VERTICAL);

        this.radiusSL = new JSlider();
        this.radiusSL.setMinimum(1);
        this.radiusSL.setMaximum(20);
        this.radiusSL.setSnapToTicks(true);
        this.radiusSL.setValue(RADIUS_INITIAL_VALUE);
        this.radiusSL.setPaintTicks(true);
        this.radiusSL.setPaintLabels(true);
        this.radiusSL.setPaintTrack(true);
        this.radiusSL.setMajorTickSpacing(1);
        this.radiusSL.setMinorTickSpacing(0);
        this.radiusSL.setOrientation(JSlider.VERTICAL);

        this.spacingSL = new JSlider();
        this.spacingSL.setMinimum(1);
        this.spacingSL.setMaximum(20);
        this.spacingSL.setSnapToTicks(true);
        this.spacingSL.setValue(SPACING_INITIAL_VALUE);
        this.spacingSL.setPaintTicks(true);
        this.spacingSL.setPaintLabels(true);
        this.spacingSL.setPaintTrack(true);
        this.spacingSL.setMajorTickSpacing(1);
        this.spacingSL.setMinorTickSpacing(0);
        this.spacingSL.setOrientation(JSlider.VERTICAL);

        this.shapeCB = new JComboBox();
        this.shapeCB.addItem(Shapes.CIRCLE);
        this.shapeCB.addItem(Shapes.SQUARE);
        this.shapeCB.addItem(Shapes.HOURGLASS);
        this.shapeCB.setSelectedItem(Shapes.CIRCLE);

        JPanel labelPanel = new JPanel();
        labelPanel.add(lenghtLB);
        labelPanel.add(radiusLB);
        labelPanel.add(spacingLB);
        this.add(labelPanel, BorderLayout.NORTH);

        this.add(lenghtSL, BorderLayout.WEST);
        this.add(radiusSL, BorderLayout.CENTER);
        this.add(spacingSL, BorderLayout.EAST);

        this.add(shapeCB, BorderLayout.SOUTH);
    }
}
