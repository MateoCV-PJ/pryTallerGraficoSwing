# pryTallerGraficoSwing

Aplicación de escritorio desarrollada en **Java** utilizando la biblioteca gráfica **Swing**. Este proyecto implementa el patrón de arquitectura **MVC (Modelo-Vista-Controlador)** para gestionar un sistema básico de administración de usuarios y clientes, con persistencia de datos en archivos **JSON**.

## 📋 Características

* **Arquitectura MVC:** Separación clara entre la lógica de negocio (Controladores), la interfaz de usuario (Vistas) y los datos (Modelos).
* **Gestión de Usuarios:**
    * Crear, Modificar y Eliminar usuarios.
    * Campos: ID, Nombre, Apellido y Clave.
* **Gestión de Clientes:**
    * Crear, Modificar y Eliminar clientes.
    * Campos: ID, Nombre, Apellido, Email y Género.
* **Persistencia de Datos:** Los datos se guardan localmente en archivos JSON (`usuarios.json` y `clientes.json`), lo que permite conservar la información entre ejecuciones.
* **Interfaz Gráfica:** Ventanas amigables construidas con Java Swing, incluyendo menús de navegación y formularios.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 21)
* **Gestor de Dependencias:** Maven
* **Biblioteca GUI:** Java Swing
* **Serialización JSON:** Google Gson (v2.10.1)

## 📂 Estructura del Proyecto

El proyecto está organizado en paquetes según el patrón MVC:

```text
src/main/java/
├── controlador/       # Lógica de la aplicación y manejo de eventos
│   ├── CtrCliente.java
│   ├── CtrPrincipal.java
│   └── CtrUsuario.java
├── modelo/            # Clases POJO (Plain Old Java Objects)
│   ├── ModCliente.java
│   ├── ModPrincipal.java
│   └── ModUsuario.java
├── vista/             # Interfaz gráfica (JFrames)
│   ├── frmCliente.java
│   ├── frmPrincipal.java
│   └── frmUsuario.java
└── Main.java          # Punto de entrada de la aplicación
