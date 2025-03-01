package com.example.conversor;

public interface IConversor {
    /**
     * Converts an infix expression into a postfix expression.
     *
     * @param infix the infix expression
     * @return the converted postfix expression
     */
    String convert(String infix);
}

