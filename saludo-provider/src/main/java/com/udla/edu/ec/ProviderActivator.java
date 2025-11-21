package com.udla.edu.ec;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProviderActivator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Bundle Proveedor INICIADO");
        SaludoService service = new SaludoServiceImpl();
        // Registramos el servicio para que otros lo vean
        registration = context.registerService(SaludoService.class.getName(), service, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Bundle Proveedor DETENIDO");
        registration.unregister();
    }
}