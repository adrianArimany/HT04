package com.example.gui;

import java.util.ArrayList;
import java.util.List;

import com.example.conversor.Conversor;
import com.example.conversor.ConversorFactory;
import com.example.data_manager.FileHandler;
import com.example.object_calculadora.RPNCalculator;
import com.example.utils.FileReaderUtil;

/**
 * Calls RPNCalculator<T> and processes results.
 */
public class CalculadoraModel {
    ConversorFactory factory = new ConversorFactory();

    /**
     * Processes a file containing expressions, evaluates each expression,
     * and returns a list of results.
     * 
     * @param filePath the path to the file containing expressions
     * @param isInfix  true if the expressions are in infix notation; false if already postfix
     * @param conversorOption the conversor option (e.g., "Standard" or "Alternative") to use if infix
     * @return a list of strings representing the evaluated results of each expression
     */
    public List<String> processFile(String filePath, boolean isInfix, String conversorOption) {
        String fileContent = FileHandler.readFile(filePath);
        List<String> expressions = FileReaderUtil.readFile(fileContent);

        RPNCalculator calculator = new RPNCalculator();
        List<String> results = new ArrayList<>();

        for (String expression : expressions) {
            try {
                int result;
                if (isInfix) {
                    // Convert the infix expression to postfix using ConversorFactory.
                    int conversorOptionInt;
                    conversorOptionInt = switch (conversorOption) {
                        case "Standard" -> 1;
                        case "Alternative" -> 2;
                        default -> 1;
                    }; // default to Standard

                    Conversor conv = factory.getConversor(String.valueOf(conversorOptionInt));
                    String postfixExpression = conv.convert(expression);
                    result = calculator.evaluate(postfixExpression);
                    results.add(expression + " (converted to " + postfixExpression + ") = " + result);
                } else {
                    result = calculator.evaluate(expression);
                    results.add(expression + " = " + result);
                }
            } catch (Exception e) {
                results.add(expression + " = ERROR");
            }
        

        }
        return results;
    }
    }        

