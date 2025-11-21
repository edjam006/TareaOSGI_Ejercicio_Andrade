package com.udla.edu.ec;

public class SaludoServiceImpl implements SaludoService {
    public void saludar(String nombre) {
        System.out.println(">> SERVIDOR DICE: Hola " + nombre + ", bienvenido al mundo OSGi.");
    }
}