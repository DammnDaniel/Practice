# Ruta de simulacros

Este archivo marca variedad y prioridades. No contiene soluciones ni firmas. La IA debe entregar cada enunciado por separado y no anticipar los cambios de requisitos.

## 1. Horarios comerciales — base

Estado: completado.

- Modelar negocios e intervalos.
- Consultar negocios abiertos en un día y una hora.
- Varios intervalos por negocio.
- Límites `[apertura, cierre)`.
- Ejecución desde `main` y tests JUnit breves.

## 2. Horarios comerciales — cambios

Entregar los cambios uno a uno después de que Daniel explique cómo afectan al modelo:

- obtener y mostrar los horarios de un negocio concreto;
- comprobar si un negocio permanece abierto durante un rango completo, no solo en un instante;
- encontrar negocios abiertos 24 horas durante un día;
- distinguir entre «abierto durante todo el rango solicitado» y «abierto 24/7 todos los días»;
- intervalos que cruzan medianoche;
- intervalos solapados o inválidos;
- consulta de próximos horarios o siguiente apertura;
- volumen grande de consultas y posibles índices en memoria.

No es necesario implementar todas las variantes. Priorizar razonamiento, límites y adaptación del código existente.

La frase anotada en la llamada —«buscar horarios donde siempre esté abierto»— es ambigua. Durante la práctica deben cubrirse por separado estas dos interpretaciones:

1. El negocio está abierto sin interrupciones durante un intervalo solicitado, por ejemplo de 12:30 a 15:30.
2. El negocio está abierto permanentemente, ya sea 24 horas en un día o 24/7 durante toda la semana.

No asumir cuál aparecerá en la entrevista; aclarar el significado antes de programar sería una buena pregunta al entrevistador.

## 3. Clases e interfaces

Ejercicio corto desde cero que requiera:

- una interfaz de repositorio o proveedor;
- una implementación en memoria;
- un servicio que dependa de la abstracción;
- al menos dos tests unitarios con una dependencia controlada.

El objetivo es recordar sintaxis y explicar desacoplamiento, no construir Spring ni una arquitectura enorme.

## 4. Problema diferente de datos

Simulacro sin relación con horarios. Puede tratar pedidos, reservas, stock, eventos o métricas e incluir:

- agrupación con `Map`;
- duplicados con `Set`;
- ordenación con `Comparator`;
- una regla de validación;
- casos límite y complejidad.

## 5. Conversación backend

Sin programar un sistema completo, conectar la solución con:

- endpoint REST y códigos HTTP;
- DTOs y validación;
- persistencia SQL y posibles índices;
- tests unitarios e integración;
- monolito frente a microservicios;
- logs, métricas y tratamiento de errores;
- despliegue y CI/CD a nivel general.

## 6. Simulacro final cronometrado

- Enunciado nuevo y únicamente requisitos.
- Sin chuleta ni IA durante la implementación.
- Daniel decide archivos, clases, firma y tests.
- Debe ejecutar pronto, cubrir límites y explicar complejidad.
- Al terminar, revisión crítica y una pequeña modificación del requisito.
