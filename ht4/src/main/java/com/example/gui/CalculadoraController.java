package com.example.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;

/**
 * Handles user interactions (button clicks, file selection).
 */
public class CalculadoraController {
    private final CalculadoraView view;
    private final CalculadoraModel model;

    public CalculadoraController(CalculadoraView view) {
        this.view = view;
        this.model = new CalculadoraModel();
        this.view.getBtnSelectFile().addActionListener(new FileSelectionHandler());
    }

    private class FileSelectionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                processFile(selectedFile.getAbsolutePath());
            }
        }
    }

    /**
     * Process a file containing expressions, one per line, and display the results
     * in the text area.
     *
     * @param filePath the path to the file to process
     */
    private void processFile(String filePath) {
        // Retrieve the mode and conversor options from the view.
        String mode = view.getSelectedMode();
        boolean isInfix = mode.equals("Infix");
        String conversorOption = view.getSelectedConversor();
        
        List<String> results = model.processFile(filePath, isInfix, conversorOption);
        if (results != null) {
            StringBuilder output = new StringBuilder();
            for (String line : results) {
                output.append(line).append("\n");
            }
            view.getResultArea().setText(output.toString());
        } else {
            GUIUtils.showErrorMessage("Error processing file.");
        }
    }
}
