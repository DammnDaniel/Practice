# Hoja de ejercicios de sintaxis Java

Esta hoja se irá rellenando durante el repaso previo a las simulaciones. Los enunciados no incluyen soluciones.

## Cómo trabajar cada ejercicio

Antes de programar, completa:

- **Qué he entendido:**
- **Dudas del enunciado:**
- **Entrada y salida:**
- **Estructura o tipo que usaré:**
- **Casos que probaré:**

Después de ejecutarlo:

- **Resultado:**
- **Error o dificultad encontrada:**
- **Complejidad temporal y espacial:**
- **Qué he aprendido o debo repetir:**
- **Estado:** `[ ] con chuleta` `[ ] sin chuleta` `[ ] explicado`

---

## 1. Variables y operadores

Recibe un precio, una cantidad y un descuento porcentual. Devuelve el total final. Decide qué tipo utilizarías y explica por qué `int` no es apropiado para todos los cálculos monetarios.

### Mis notas


---

## 2. Condicionales

Clasifica una temperatura como `BAJA`, `NORMAL` o `ALTA` utilizando dos límites recibidos como parámetros. Aclara qué sucede cuando la temperatura coincide exactamente con un límite.

### Mis notas


---

## 3. Bucles

Devuelve la suma de los números pares de una lista, incluyendo los números negativos. Prueba una lista vacía y otra que no contenga pares.

### Mis notas


---

## 4. Arrays

Dado un `int[]`, devuelve la diferencia entre su valor máximo y mínimo sin ordenar ni modificar el array recibido.

### Mis notas


---

## 5. Strings

Normaliza un nombre: elimina espacios exteriores, sustituye secuencias de espacios interiores por uno solo y aplica una capitalización acordada.

### Mis notas


---

## 6. StringBuilder

Construye una cadena con las palabras recibidas en orden inverso y separadas por un único espacio. Evita concatenar repetidamente strings dentro del bucle.

### Mis notas


---

## 7. List

Devuelve una nueva lista sin números negativos, conservando el orden original. La lista de entrada no puede modificarse.

### Mis notas


---

## 8. Set

Devuelve el primer elemento duplicado de una lista. Antes de programar, decide qué debe ocurrir si no existe ningún duplicado.

### Mis notas


---

## 9. Map - conteos

Cuenta cuántas veces aparece cada palabra, ignorando mayúsculas y espacios exteriores.

### Mis notas


---

## 10. Map - agrupaciones

Agrupa pedidos por `userId`. Conserva el orden de aparición de los usuarios y el orden original de los pedidos dentro de cada grupo.

### Mis notas


---

## 11. Ordenación

Devuelve los productos ordenados por precio descendente y, en caso de empate, por nombre ascendente. No modifiques la lista recibida.

### Mis notas


---

## 12. Clases y records

Modela un intervalo de apertura con día, hora inicial y hora final. Decide si utilizarías un `record` o una clase y justifica la elección.

### Mis notas


---

## 13. Enums

Modela los estados de un pedido y crea una función que indique si una transición desde un estado de origen a otro de destino es válida.

### Mis notas


---

## 14. Interfaces

Existen descuentos para clientes normales, VIP y empleados. Decide si una interfaz aporta valor en este caso. Justifica la decisión antes de implementarla.

### Mis notas


---

## 15. Excepciones

Convierte un `String` a un entero positivo. Diferencia un formato inválido de un número correctamente escrito pero no positivo.

### Mis notas


---

## 16. Optional

Busca un usuario por identificador dentro de una lista y devuelve `Optional<User>`. Consume después el resultado sin llamar a `get()` sin comprobarlo.

### Mis notas


---

## 17. Lambdas y Comparator

Ordena strings primero por longitud y después alfabéticamente. Utiliza `Comparator` y referencias a métodos cuando mejoren la claridad.

### Mis notas


---

## 18. Streams

Obtén nombres únicos, no vacíos, normalizados y ordenados. Resuélvelo primero con un bucle y después con streams. Compara ambas soluciones.

### Mis notas


---

## 19. Fechas y horas

Comprueba si un `LocalTime` pertenece al intervalo `[apertura, cierre)`. Después explica qué cambia cuando el horario cruza medianoche.

### Mis notas


---

## 20. equals y hashCode

Modela un identificador de negocio que pueda utilizarse correctamente dentro de un `HashSet`. Decide qué campos forman parte de su identidad.

### Mis notas


---

## 21. Queue y Deque

Comprueba si una cadena compuesta por `()`, `[]` y `{}` está correctamente balanceada utilizando una pila.

### Mis notas


---

## 22. PriorityQueue

Devuelve los `k` valores mayores de una colección sin ordenar completamente toda la entrada. Compara esta solución con ordenar la lista.

### Mis notas


---

## 23. Testing

Escoge uno de los ejercicios anteriores y prepara casos para: flujo normal, entrada vacía, valor límite, duplicados y entrada inválida cuando forme parte del contrato.

### Mis notas


---

## 24. Integración - horarios comerciales

Dado un conjunto de tiendas con sus intervalos de apertura en memoria, devuelve las tiendas abiertas en un día y una hora determinados.

Primera versión: un intervalo por día. Después añadiremos varios intervalos, horarios nocturnos y cambios de requisitos.

### Mis notas


---

## Control de progreso

| # | Tema | Con chuleta | Sin chuleta | Explicado |
|---:|---|:---:|:---:|:---:|
| 1 | Variables y operadores | [ ] | [ ] | [ ] |
| 2 | Condicionales | [ ] | [ ] | [ ] |
| 3 | Bucles | [ ] | [ ] | [ ] |
| 4 | Arrays | [ ] | [ ] | [ ] |
| 5 | Strings | [ ] | [ ] | [ ] |
| 6 | StringBuilder | [ ] | [ ] | [ ] |
| 7 | List | [ ] | [ ] | [ ] |
| 8 | Set | [ ] | [ ] | [ ] |
| 9 | Map - conteos | [ ] | [ ] | [ ] |
| 10 | Map - agrupaciones | [ ] | [ ] | [ ] |
| 11 | Ordenación | [ ] | [ ] | [ ] |
| 12 | Clases y records | [ ] | [ ] | [ ] |
| 13 | Enums | [ ] | [ ] | [ ] |
| 14 | Interfaces | [ ] | [ ] | [ ] |
| 15 | Excepciones | [ ] | [ ] | [ ] |
| 16 | Optional | [ ] | [ ] | [ ] |
| 17 | Lambdas | [ ] | [ ] | [ ] |
| 18 | Streams | [ ] | [ ] | [ ] |
| 19 | Fechas y horas | [ ] | [ ] | [ ] |
| 20 | equals/hashCode | [ ] | [ ] | [ ] |
| 21 | Queue/Deque | [ ] | [ ] | [ ] |
| 22 | PriorityQueue | [ ] | [ ] | [ ] |
| 23 | Testing | [ ] | [ ] | [ ] |
| 24 | Integración final | [ ] | [ ] | [ ] |
