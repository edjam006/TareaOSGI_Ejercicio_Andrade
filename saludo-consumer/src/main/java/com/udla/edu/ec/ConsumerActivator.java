package com.udla.edu.ec;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ConsumerActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println(">>> Bundle CONSUMIDOR Iniciado");

        // 1. Buscamos una REFERENCIA al servicio (no al objeto directo)
        // Esto pregunta a OSGi: "¿Hay alguien ofreciendo SaludoService?"
        ServiceReference<?> reference = context.getServiceReference(SaludoService.class.getName());

        if (reference != null) {
            // 2. Si existe, obtenemos el servicio
            SaludoService service = (SaludoService) context.getService(reference);

            // 3. Lo usamos
            if (service != null) {
                service.saludar("Profe (desde el Consumidor)");
            }
        } else {
            System.out.println(">>> ¡Alerta! No se encontró ningún proveedor de saludos.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println(">>> Bundle CONSUMIDOR Detenido");
        // Nota: OSGi limpia las referencias automáticamente al detenerse,
        // pero en sistemas grandes aquí liberarías recursos manualmente.
    }
}