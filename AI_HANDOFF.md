# Continuidad de la preparación

Este archivo permite continuar la práctica con otra IA, en otro ordenador o en una conversación nueva sin perder el enfoque ni el progreso. Debe actualizarse cuando cambie el ejercicio activo o se complete un bloque importante.

## Objetivo

Daniel está preparando una entrevista técnica para un puesto backend en Dribba. La prueba será el **miércoles 15 de julio de 2026 a las 12:00**.

Información confirmada por selección:

- será live coding sin IA;
- el lenguaje es libre y Daniel usará Java;
- debe tener un entorno preparado para programar una función y ejecutarla;
- recibirá el enunciado en un PDF;
- la empresa no ha confirmado si proporcionará datos, clases o una base de datos.

Una llamada dio como orientación no garantizada un posible problema con un conjunto de datos y horarios de apertura de negocios, además de conversación sobre microservicios, web services, arquitectura, API REST y bases de datos. No debe intentarse reproducir ni buscar una prueba confidencial exacta: se preparan problemas equivalentes.

## Perfil de Daniel

Daniel es ingeniero informático y tiene experiencia real con Java/Spring Boot, PostgreSQL, SQL, WebSockets, Vue, .NET Core y Angular. Su principal necesidad no es aprender programación desde cero, sino:

- recuperar rapidez con la sintaxis de Java;
- leer el enunciado con precisión antes de programar;
- no inventar requisitos;
- elegir con seguridad entre `List`, `Set`, `Map`, bucles, streams y ordenación;
- explicar decisiones, casos límite y complejidad;
- ganar autonomía programando y ejecutando sin ayuda de IA.

## Cómo debe acompañarle una IA

1. Trabajar **un ejercicio cada vez**.
2. No escribir la solución completa por adelantado.
3. Pedir primero que Daniel explique qué ha entendido, entradas, salida, casos límite y estructura de datos.
4. Si se atasca, dar una pista gradual antes de mostrar código.
5. Revisar el código que él haya escrito y ejecutar sus pruebas.
6. Ser objetivo y crítico: distinguir entre una solución correcta, una mejorable y una incorrecta.
7. Hacer cambios pequeños en su código solo cuando Daniel lo pida expresamente.
8. Preservar su solución y su forma de razonar; no sustituirla por una versión sofisticada sin necesidad.
9. Después de cada ejercicio, pedir una explicación breve de complejidad temporal y espacial.
10. En simulaciones finales, entregar únicamente requisitos, como en un PDF real: Daniel debe decidir clases, firmas, estructuras y pruebas.

Durante los primeros ejercicios puede consultar `docs/Chuleta_compacta_Java.pdf`. En los simulacros debe trabajar sin chuleta y sin IA.

## Estado actual — 13 de julio de 2026

- Ejercicio activo en `Main.java`: **17**.
- Ejercicios **1–16 implementados y verificados** (todos pasan sus casos).
- Ejercicio **17 en progreso**: compila y pasa el caso `orden`, pero **falla `entrada intacta`** porque `values.sort(...)` **muta la lista de entrada**. Solución pendiente: ordenar una **copia** (`new ArrayList<>(values)` + `sort`) o usar `stream().sorted().toList()`. El comparador `comparing(String::length).thenComparing(naturalOrder())` ya es correcto.
- Ejercicios **18–24 pendientes**.
- Siguiente paso recomendado: **terminar el 17** (ordenar copia, no mutar) y seguir con **18 — streams** (nombres únicos normalizados, primero con bucle y luego con stream).

No debe darse por completado un ejercicio únicamente porque compile. Para marcarlo como consolidado, Daniel debería poder:

- pasar sus casos;
- explicar por qué eligió esa estructura;
- indicar complejidad;
- resolver una pequeña variación.

## Aprendizajes y errores ya detectados

- Una asignación posterior puede sobrescribir el resultado de un `if`; conviene usar ramas claras o retornos tempranos.
- `List.sort(Comparator.reverseOrder())` ordena por valor descendente; no invierte simplemente las posiciones.
- Un stream es perezoso: `stream().filter(...)` sin operación terminal no produce una nueva lista ni modifica la original.
- Para conservar el cero al eliminar negativos, la condición es `number >= 0`, no `number > 0`.
- Antes de usar `substring(0, 1)` hay que manejar la cadena vacía.
- `sort()` modifica la lista; `stream().sorted().toList()` crea un resultado nuevo. (Volvió a caer en esto en el 17: hay que ordenar una copia si no se puede mutar la entrada.)
- La solución más clara es preferible a usar streams únicamente para demostrar que se conocen.

Aprendizajes de la sesión del 13 de julio (ejercicios 8–17):

- `computeIfAbsent(k, x -> new ArrayList<>())` crea el valor, **lo guarda en el mapa** y lo devuelve; `getOrDefault` NO inserta el valor por defecto (le costó entenderlo en el 10, al agrupar).
- Para contar, `map.merge(k, 1, Integer::sum)` es la forma corta de "si no existe pon 1, si existe suma".
- `switch` de flecha `->`: no lleva `break`, no hay fallthrough y no admite un `if` suelto (necesita bloque `{}`); no mezclar `->` con `:` ni con `default:`. Alternativa clásica `case X:` con `return` en cada rama.
- Interfaz funcional + lambda: un `price -> price * 0.80` **es** una `DiscountPolicy` porque adopta el tipo esperado (target typing). Con functional interface no hace falta una clase por tipo; sirven lambdas y una factory (`policyFor`).
- Diferencia lambda vs referencia a método: `String::length` es la forma corta de `s -> s.length()`.
- `filter` es intermedia (devuelve `Stream`); para obtener un `Optional` hace falta una operación terminal como `findFirst()`.
- No castear `String` a `int` con `(int)`; usar `Integer.parseInt(...)` (que además lanza `NumberFormatException`).
- El `finally` no es el sitio para validar lógica de negocio: se ejecuta siempre y su excepción puede tapar la del `catch`. La validación va en el flujo normal tras convertir. (El 15 pasa los tests igualmente, pero conviene reordenarlo.)

Mejoras menores pendientes en el ejercicio 7, sin bloquear el avance:

- renombrar `test` a algo como `nonNegativeNumbers`;
- eliminar el bloque muerto que crea `copy` y llama a un stream cuyo resultado no se consume.

## Ruta inmediata

### Lunes 13

- Corregir o volver a ejecutar rápidamente los ejercicios 2 y 6 si Daniel quiere confirmar su estado.
- Completar 8 y 9 (`Set` y conteos con `Map`).
- Objetivo razonable: llegar a 13.
- Objetivo ideal, solo si entiende bien lo anterior: llegar a 16.
- En paralelo, repasar teoría de `Set`, `Map`, agrupación, `Comparator`, records, enums, interfaces, excepciones y `Optional`.

### Martes 14

- Streams, fechas y horas e intervalos.
- Ejercicio integrado de horarios comerciales.
- Al menos un simulacro sin firmas ni clases preparadas.
- Repaso oral de experiencia, REST, bases de datos, testing, microservicios y arquitectura.

### Miércoles 15

- Calentamiento de 60–90 minutos como máximo.
- Comprobar IntelliJ, JDK y ejecución.
- No estudiar contenido nuevo justo antes de la entrevista.

## Flujo técnico del proyecto

Para seleccionar un ejercicio, cambiar `ACTIVE_EXERCISE` en:

`src/main/java/practice/Main.java`

La implementación se conserva acumulativamente en:

`src/main/java/practice/CurrentChallenge.java`

Ejecución desde PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src/main/java/practice/*.java
java -cp out practice.Main
```

Al finalizar una sesión:

1. actualizar este archivo con el ejercicio activo y los resultados;
2. ejecutar el ejercicio activo;
3. hacer commit y push para poder continuar desde otro ordenador.

Comandos habituales:

```powershell
git status
git add src AI_HANDOFF.md
git commit -m "Update Java practice progress"
git push
```

## Fases posteriores

La lista de 24 ejercicios es solo el calentamiento de sintaxis. Después deben realizarse:

1. problemas combinados con menos pistas;
2. ejercicios de horarios con `LocalTime`, intervalos, agrupación y filtrado;
3. pruebas en las que quizá sea necesario crear records, clases o interfaces;
4. simulacros completos con enunciado únicamente, cronómetro, ejecución y explicación final.

Que selección haya dicho «programar una función» no garantiza que toda la prueba sea una única función trivial. Puede ser razonable crear pequeñas clases, records, enums o interfaces si el modelo lo necesita, pero no se debe sobrearquitecturar.
