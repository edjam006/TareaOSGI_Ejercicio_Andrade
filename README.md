# Implementación de Arquitectura Modular con OSGi (Apache Karaf)

## 📋 Información
**Universidad:** Universidad de las Américas (UDLA)  
**Facultad:** Ingeniería y Ciencias Aplicadas  
**Materia:** Diseño y Arquitectura de Software  
**Tema:** OSGi y Patrón Microkernel  

---

## 🚀 Descripción del Proyecto
Este proyecto es una implementación práctica del estándar **OSGi (Open Services Gateway initiative)** utilizando Java y Apache Maven. El objetivo es demostrar cómo construir aplicaciones modulares, dinámicas y con bajo acoplamiento.

El sistema consta de dos módulos principales (Bundles):
1.  **Saludo Provider:** Un módulo que exporta una interfaz y registra un servicio de implementación en el registro de OSGi.
2.  **Saludo Consumer:** Un módulo que "escucha" y consume dicho servicio dinámicamente cuando está disponible.

### 🏛️ Fundamentación Teórica
Esta implementación responde al **Patrón de Arquitectura Microkernel (o Plug-in)**.
* **Core:** Apache Karaf actúa como el núcleo (Kernel) que gestiona el ciclo de vida.
* **Plugins:** Los bundles `provider` y `consumer` son componentes que se enchufan al núcleo para añadir funcionalidad.

**¿Qué logramos con esto?**
* **Hot-Swapping:** Capacidad de actualizar, instalar o desinstalar módulos sin detener el servidor.
* **Bajo Acoplamiento:** El consumidor no conoce la implementación del proveedor, solo su interfaz.

---

## 🛠️ Requisitos Previos
* **Java JDK:** Versión 11 o 17.
* **Apache Maven:** Para la gestión de dependencias y construcción.
* **Apache Karaf:** Versión 4.x (Contenedor OSGi).
* **IDE:** IntelliJ IDEA (Recomendado).

---


## ⚙️ Estructura del Proyecto

ejercicio_osgi/             # Proyecto Padre (POM)
├── pom.xml                 # Configuración global
├── saludo-provider/        # Bundle Proveedor
│   ├── src/main/java/.../ProviderActivator.java
│   └── pom.xml             # Exporta el paquete del servicio
└── saludo-consumer/        # Bundle Consumidor
    ├── src/main/java/.../ConsumerActivator.java
    └── pom.xml             # Importa el servicio


💻 Instrucciones de Instalación y Ejecución
Paso 1: Compilación
Desde la raíz del proyecto (ejercicio_osgi), abra una terminal y ejecute el siguiente comando para limpiar y construir los artefactos:

Bash

mvn clean install
Verificación: Asegúrese de obtener el mensaje BUILD SUCCESS al finalizar. Esto generará los archivos .jar dentro de la carpeta target de cada módulo.

Paso 2: Iniciar Apache Karaf
Descomprima su distribución de Apache Karaf.

Navegue a la carpeta bin.

Ejecute el script de inicio:

Windows: karaf.bat

Linux/Mac: ./karaf

Paso 3: Despliegue de Bundles
Dentro de la consola de Karaf (el prompt karaf@root()>), instale los bundles utilizando la ruta absoluta donde se encuentra su proyecto.

⚠️ Nota Importante: Si usa Windows, recuerde usar barras inclinadas / (forward slashes) o escapar las barras invertidas \\ en la ruta del archivo.

1. Instalar y Arrancar el Proveedor: Reemplace <RUTA> con la ubicación de su proyecto:

Bash

bundle:install -s file:///<RUTA>/ejercicio_osgi/saludo-provider/target/saludo-provider-1.0-SNAPSHOT.jar
Salida esperada: Bundle ID: [ID_A]

2. Instalar y Arrancar el Consumidor:

Bash

bundle:install -s file:///<RUTA>/ejercicio_osgi/saludo-consumer/target/saludo-consumer-1.0-SNAPSHOT.jar
Salida esperada:

Plaintext

Bundle ID: [ID_B]
>>> Bundle CONSUMIDOR Iniciado
>>> SERVIDOR DICE: Hola Profe (desde el Consumidor)...
🧪 Pruebas de Funcionamiento (Live Test)
Para cumplir con el requerimiento de "Arrancar y parar un bundle a demanda, sin afectar la ejecución del sistema", siga estos pasos en la consola de Karaf:

Listar los módulos activos:

Bash

list
Identifique los IDs de saludo-provider y saludo-consumer (generalmente al final de la lista).

Detener el Consumidor (Simulación de parada): Supongamos que el ID del consumidor es 51:

Bash

stop 51
Resultado: El mensaje "Bundle CONSUMIDOR Detenido" aparece. El servidor Karaf y el Proveedor siguen funcionando normalmente.

Reiniciar el Consumidor (Hot-Start):

Bash

start 51
Resultado: El bundle se reactiva y vuelve a consumir el servicio de saludo inmediatamente.
