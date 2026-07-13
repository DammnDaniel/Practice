# Progresión de ejercicios

Este archivo define el recorrido, no las soluciones. No intentes hacerlos todos seguidos. El entrevistador entrega un enunciado cada vez y puede introducir cambios.

## Nivel 1 — Recorridos básicos

Objetivo: comprender el contrato, escribir un bucle limpio y ejecutar casos.

- Filtrar o acumular números de una lista.
- Encontrar mínimo/máximo bajo ciertas reglas.
- Contar elementos que cumplen una condición.
- Transformar una lista sin modificar la entrada.

Preguntas habituales: lista vacía, negativos, repetidos, `null`, overflow y complejidad.

## Nivel 2 — Strings

Objetivo: índices, normalización y casos límite.

- Contar o comparar caracteres.
- Normalizar texto antes de validarlo.
- Detectar patrones sencillos.
- Comprimir o transformar una cadena.

Preguntas habituales: mayúsculas, espacios, puntuación, Unicode, cadena vacía y `null`.

## Nivel 3 — Map y Set

Objetivo: elegir la estructura por una razón.

- Detectar duplicados.
- Contar frecuencias.
- Encontrar el primer elemento que cumple una condición de frecuencia.
- Comparar colecciones ignorando orden.

Preguntas habituales: orden de salida, memoria adicional, repetidos y diferencia entre `HashMap`, `LinkedHashMap` y `TreeMap`.

## Nivel 4 — Agrupaciones

Objetivo: construir resultados compuestos y mantener contratos claros.

- Agrupar objetos por una propiedad.
- Calcular agregados por grupo.
- Elegir el mejor elemento de cada grupo.
- Combinar información de dos listas.

Preguntas habituales: claves inexistentes, empates, orden, objetos incompletos y listas grandes.

## Nivel 5 — Ordenación y comparadores

Objetivo: ordenar sin destruir información ni mutar accidentalmente la entrada.

- Ordenar por varios criterios.
- Resolver empates de forma determinista.
- Obtener los primeros `k` elementos.
- Fusionar secuencias ya ordenadas.

Preguntas habituales: estabilidad, copia frente a mutación y complejidad `O(n log n)`.

## Nivel 6 — Validaciones

Objetivo: traducir reglas de negocio a decisiones explícitas.

- Validar reservas o pedidos.
- Devolver errores diferenciados.
- Detectar intervalos inválidos o solapados.
- Aplicar varias reglas con prioridades.

Preguntas habituales: qué regla falla primero, si se devuelven uno o todos los errores y cómo representar el resultado.

## Nivel 7 — Lógica backend sencilla

Objetivo: código de dominio sin Spring ni base de datos.

- Reservar stock sobre datos en memoria.
- Calcular totales, descuentos e impuestos.
- Cambiar estados únicamente mediante transiciones válidas.
- Procesar eventos evitando duplicados.

Preguntas habituales: idempotencia, consistencia, dinero (`BigDecimal`), estados inválidos y efectos secundarios.

## Nivel 8 — Combinación y optimización

Objetivo: comparar una solución directa con otra más eficiente.

- Ventanas o rangos dentro de arrays.
- Búsqueda eficiente usando índices auxiliares.
- Colas/pilas para procesar secuencias.
- Problemas donde una solución `O(n²)` puede mejorarse a `O(n)` u `O(n log n)`.

Preguntas habituales: trade-offs de memoria, entradas grandes y prueba informal de corrección.

## Criterio de avance

Sube de nivel cuando puedas:

- reformular el enunciado sin añadir requisitos;
- mencionar al menos tres casos antes de programar;
- conseguir primero una solución correcta y legible;
- ejecutar y corregir sin ayuda;
- explicar complejidad;
- adaptar la solución a un cambio pequeño del requisito.
