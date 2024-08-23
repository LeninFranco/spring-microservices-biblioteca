# Sistema de Microservicios de Biblioteca

Bienvenido al **Sistema de Microservicios de Biblioteca**, una solución modular y escalable desarrollada con **Spring Boot** para gestionar las operaciones de una biblioteca. Este sistema está diseñado para demostrar el uso de arquitectura de microservicios en un entorno real, integrando servicios para configuración, descubrimiento de servicios, y enrutamiento, junto con servicios específicos para libros, préstamos y miembros.

## Descripción del Proyecto

Este proyecto es un sistema básico de microservicios que consta de los siguientes componentes:

1. **Servicio de Configuración**: Administra la configuración centralizada de todos los microservicios.
2. **Servicio de Eureka**: Proporciona el registro y descubrimiento de servicios, permitiendo que los microservicios se encuentren entre sí.
3. **Servicio de Gateway**: Actúa como el punto de entrada único para las solicitudes a los microservicios, manejando el enrutamiento y la agregación de respuestas.

Los microservicios principales son:

- **Servicio de Libros**: Gestiona información sobre los libros en la biblioteca. Este servicio cuenta con tres tablas:
  - **Categorías**: Clasifica los libros en diferentes géneros.
  - **Autores**: Almacena información sobre los autores de los libros.
  - **Libros**: Contiene detalles sobre cada libro, incluyendo su título, autor y categoría.

- **Servicio de Préstamos**: Maneja los préstamos de libros entre la biblioteca y los miembros. Este servicio se encarga de:
  - Registrar y gestionar los préstamos de libros.
  - Relacionar los préstamos con los miembros y los libros prestados.

- **Servicio de Miembros**: Gestiona la información de los miembros de la biblioteca. Este servicio se encarga de:
  - Registrar nuevos miembros.
  - Mantener un registro actualizado de todos los miembros actuales.

## Características Destacadas

- **Arquitectura de Microservicios**: Cada componente del sistema se desarrolla como un microservicio independiente, permitiendo un desarrollo modular y escalable.
- **Configuración Centralizada**: Utiliza el servicio de configuración para gestionar de manera centralizada la configuración de todos los microservicios.
- **Descubrimiento de Servicios**: Aprovecha Eureka para facilitar el descubrimiento y la comunicación entre microservicios.
- **Enrutamiento y Agregación**: El gateway gestiona el enrutamiento de solicitudes y agrega respuestas de los servicios.
