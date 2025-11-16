# pryTallerGraficoSwing 📊

Aplicación de escritorio básica desarrollada en **Java Swing** para demostrar la implementación del patrón **Modelo-Vista-Controlador (MVC)**, utilizando **Maven** para la gestión del proyecto.

---

## 💻 Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 21)
* **Interfaz Gráfica:** Java Swing
* **Gestor de Dependencias:** Apache Maven

---

## 🏗️ Estructura del Proyecto (MVC)

El proyecto está organizado siguiendo el patrón MVC, separando la lógica de negocio, la presentación y el flujo de la aplicación.

* **`vista`**: Contiene las clases de la interfaz gráfica (`JFrame`) para la interacción con el usuario.
    * `frmPrincipal.java`: La ventana principal de la aplicación, que contiene un menú.
    * `frmUsuario.java`: Formulario para la gestión de datos de usuarios.
    * `frmCliente.java`: Formulario para la gestión de datos de clientes.
* **`controlador`**: Contiene la lógica para manejar las interacciones del usuario y actualizar la vista o el modelo.
    * `CtrPrincipal.java`: Controlador principal que inicializa la vista principal.
* **`modelo`**: Destinado a contener la lógica de negocio, acceso a datos (DAO/DTO) y el estado de la aplicación.
    * `ModPrincipal.java`: Clase inicial para el modelo.
* **`Main.java`**: Punto de entrada de la aplicación, inicializa la vista principal y su controlador asociado.

---

## ✨ Características Principales

1.  **Ventana Principal (`frmPrincipal`)**:
    * Título: "Aplicación MVC - Principal".
    * Menú con opciones para **Usuario**, **Cliente** y **Salir**.

2.  **Formulario Usuario (`frmUsuario`)**:
    * Campos: ID Usuario, Nombre, Apellido, Clave (JPasswordField).
    * Acciones CRUD: Botones **Guardar**, **Modificar**, **Eliminar** y **Limpiar**.

3.  **Formulario Cliente (`frmCliente`)**:
    * Campos: ID Cliente, Nombre, Apellido, Email, y Género (JComboBox).
    * Acciones CRUD: Botones **Guardar**, **Modificar**, **Eliminar** y **Limpiar**.

---

## 🚀 Ejecución del Proyecto

### Requisitos

* Java Development Kit (JDK) 21 o superior.
* Apache Maven.

### Compilación y Ejecución (Usando Maven)

1.  **Clonar el repositorio** (Si aplica) o descargar los archivos.
2.  **Compilar el proyecto**: Navega al directorio raíz del proyecto (`pryTallerGraficoSwing`) y ejecuta:
    ```bash
    mvn clean compile
    ```
3.  **Ejecutar la aplicación**:
    ```bash
    mvn exec:java -Dexec.mainClass="Main"
    ```
