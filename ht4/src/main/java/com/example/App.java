package com.example;

import com.example.conversor.Conversor;
import com.example.conversor.ConversorFactory;
import com.example.data_manager.DataStorage;
import com.example.gui.CalculadoraGUI;
import com.example.object_calculadora.RPNCalculator;
import com.example.utils.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


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
        RPNCalculator calculadora = new RPNCalculator();
        ConversorFactory nuevofactory = new ConversorFactory();
        Scanner teclado = new Scanner(System.in);

        StringBuilder contenido = new StringBuilder();
        String nombreArchivo = "datos.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contenidoArchivo = contenido.toString();
        System.out.println("¿Qué tipo de estructura de datos desea utilzar?");
        System.out.println("1. Stack \n 2. ArrayList \n 3. Vector \n 4. Lista simple \n. 5. Lista doble");
        int cond = teclado.nextInt();
        Conversor conversor = nuevofactory.getConversor(cond);
        conversor.InfixToPostFix(contenidoArchivo);
        System.out.println(conversor.getCadenaPostFix());
        System.out.println(calculadora.evaluate(conversor.getCadenaPostFix()));
        teclado.close();
    }
}
