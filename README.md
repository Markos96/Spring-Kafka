# Proyecto de Integración de APIs con Kafka, Debezium y PostgreSQL

## Descripción

Este proyecto contiene dos APIs desarrolladas en **Spring Boot** que implementan un flujo de eventos con **Kafka** y **Debezium** para la captura de cambios en una base de datos PostgreSQL. La arquitectura está diseñada para simular un sistema de pedidos, donde los cambios en la base de datos se capturan en tiempo real y se comunican a través de un **topic de Kafka**.

### Componentes principales:
- **API de Pedidos**: Implementada en **Spring Boot** con **PostgreSQL**. Esta API maneja las operaciones CRUD sobre los pedidos.
- **API de Notificaciones**: Implementada en **Spring Boot** con **Kafka**. Esta API escucha eventos de Kafka relacionados con cambios en la base de datos de pedidos y envía notificaciones correspondientes.

### Flujo de trabajo:
1. **API de Pedidos** permite crear, leer, actualizar y eliminar pedidos en la base de datos PostgreSQL.
2. **Debezium** captura los cambios en la base de datos PostgreSQL y los transmite a Kafka.
3. **API de Notificaciones** consume los eventos de Kafka relacionados con los cambios en los pedidos y genera notificaciones o acciones correspondientes.

## Arquitectura

El flujo se divide en tres componentes principales:
1. **API de Pedidos**:
    - **Tecnologías**: Spring Boot, PostgreSQL.
    - **Funcionalidad**: CRUD de pedidos, donde cada cambio se refleja en la base de datos.
2. **Kafka**:
    - **Tecnología**: Apache Kafka.
    - **Funcionalidad**: Canal de eventos que transmite los cambios realizados en la base de datos a través de un topic.
3. **API de Notificaciones**:
    - **Tecnologías**: Spring Boot, Kafka.
    - **Funcionalidad**: Escucha los eventos de Kafka y ejecuta acciones (como enviar notificaciones).

## Requisitos

- **PostgreSQL**: Configurado para aceptar cambios y transmitirlos a Kafka mediante **Debezium**.
- **Kafka**: Usado para la transmisión de eventos entre las APIs.
- **Debezium**: Herramienta para capturar cambios en la base de datos PostgreSQL en tiempo real.

## Configuración y Ejecución

### 1. Configuración de PostgreSQL y Debezium

- **Docker**: Asegúrate de tener **Docker** instalado para ejecutar los contenedores de PostgreSQL, Debezium y Kafka.
  
#### Pasos para ejecutar los contenedores:
```bash
docker-compose -f docker-compose.yml up -d
