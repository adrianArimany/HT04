package com.example.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalculadoraView extends JFrame {
    private final JButton btnSelectFile;
    private final JTextArea resultArea;
    
    // New UI components for mode and conversor selection
    private final JComboBox<String> modeComboBox;
    private final JComboBox<String> conversorComboBox;
    
    public CalculadoraView() {
        setTitle("Calculadora");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        btnSelectFile = new JButton("Select .txt File");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        
        // Create a top panel that contains file selection and new options
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnSelectFile, BorderLayout.NORTH);
        
        // Options panel for mode and conversor
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        optionsPanel.add(new JLabel("Mode:"));
        modeComboBox = new JComboBox<>(new String[]{"Postfix", "Infix"});
        optionsPanel.add(modeComboBox);
        optionsPanel.add(new JLabel("Conversor:"));
        // Updated options: "stack", "arraylist", "vector", "listasimple", "listadouble"
        conversorComboBox = new JComboBox<>(new String[]{"stack", "arraylist", "vector", "listasimple", "listadouble"});
        optionsPanel.add(conversorComboBox);
        // Disable conversor selection when in Postfix mode
        conversorComboBox.setEnabled(false);
        
        // Enable conversor options only when Infix mode is selected
        modeComboBox.addActionListener(e -> {
            String mode = (String) modeComboBox.getSelectedItem();
            conversorComboBox.setEnabled(mode.equals("Infix"));
        });
        
        topPanel.add(optionsPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
    
    public JButton getBtnSelectFile() {
        return btnSelectFile;
    }
    
    public JTextArea getResultArea() {
        return resultArea;
    }
    
    // Getter methods for the new controls
    public String getSelectedMode() {
        return (String) modeComboBox.getSelectedItem();
    }
    
    public String getSelectedConversor() {
        return (String) conversorComboBox.getSelectedItem();
    }
}
