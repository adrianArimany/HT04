package com.example;

import com.example.data_manager.DataStorage;
import com.example.gui.CalculadoraGUI;
import com.example.utils.Logger;


/**
 * 
 * @version 1.0
 * 
 * 
 * 
 * 
 * 
 */
public class App 
{
    private static final Logger log = Logger.getInstance();

    public static void main(String[] args)
    {
        try {
            DataStorage.initialize();
            new CalculadoraGUI().runGUI();
        } catch (Exception e) {
            log.logSevere("An error has occurred, please check the logs for more information.");
            log.logInfo("This is the error message: " + e.getMessage());
        }
    }
}
