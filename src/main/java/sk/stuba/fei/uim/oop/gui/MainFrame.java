package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    @Getter
    private ManuPanel menu;
    @Getter @Setter
    private CanvasPanel canvasPanel;
    public MainFrame() throws HeadlessException {
        this.setTitle("Chain RGB");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setSize(800, 800);
        this.setLayout(new BorderLayout());

        this.menu = new ManuPanel();
        this.canvasPanel = new CanvasPanel();
        Logic logic = new Logic(this);

        this.menu.getSpacingSL().addChangeListener(logic);
        this.menu.getRadiusSL().addChangeListener(logic);
        this.menu.getLenghtSL().addChangeListener(logic);
        this.menu.getShapeCB().addItemListener(logic);

        this.canvasPanel.addMouseMotionListener(logic);

        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(menu, BorderLayout.EAST);

        this.setVisible(true);
    }
}
