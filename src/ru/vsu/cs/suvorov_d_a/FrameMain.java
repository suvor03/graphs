package ru.vsu.cs.suvorov_d_a;

import javax.swing.*;
import java.awt.*;

public class FrameMain extends JFrame {
    private JPanel mainPanel;
    private JCheckBox vertexModeCheckBox;
    private JCheckBox edgeModeCheckBox;
    private JCheckBox addModeCheckBox;
    private JTextField weightField;
    private JButton getAnswerButton;
    private JCheckBox delModeCheckBox;
    private JLabel weightLabel;
    private JPanel graphPanel;
    private JLabel answerLabel;
    private JTextField answerField;

    private Canvas canvas = new Canvas();

    public FrameMain() {
        super();

        configureFrame();
        graphPanel.add(canvas, BorderLayout.CENTER);
        createButtonListeners();

        pack();
        setVisible(true);
    }

    private void configureFrame() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Resistance calculator");
        setMinimumSize(new Dimension(1500, 800));
        setResizable(false);
    }

    private void createButtonListeners() {
        edgeModeCheckBox.addActionListener(o -> {
            vertexModeCheckBox.setSelected(false);
            canvas.changeObjectMode(Objects.EDGE);
        });

        vertexModeCheckBox.addActionListener(o -> {
            edgeModeCheckBox.setSelected(false);
            canvas.changeObjectMode(Objects.VERTEX);
        });

        weightField.addActionListener(o -> {
            try {
                int weight = Integer.parseInt(o.getActionCommand());
                canvas.setWeight(weight);
            } catch (Exception ignore) {}
        });

        addModeCheckBox.addActionListener(o ->{
            delModeCheckBox.setSelected(false);
            canvas.changeManipulateMode(ObjectActions.ADD);
        });

        delModeCheckBox.addActionListener(o ->{
            addModeCheckBox.setSelected(false);
            canvas.changeManipulateMode(ObjectActions.DELETE);
        });
    }
}