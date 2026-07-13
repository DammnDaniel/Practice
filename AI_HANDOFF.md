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

- Ejercicio activo en `Main.java`: **7**.
- Ejercicios **1–7 implementados**.
- Ejercicio 7 fue el último verificado: **3 casos correctos y 0 fallidos**.
- Ejercicios **8–24 pendientes**.
- Siguiente ejercicio recomendado: **8 — encontrar el primer duplicado usando un `Set`**.

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
- `sort()` modifica la lista; `stream().sorted().toList()` crea un resultado nuevo.
- La solución más clara es preferible a usar streams únicamente para demostrar que se conocen.

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
