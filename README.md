# Java Live Coding Practice

Entorno mínimo para preparar una prueba técnica de live coding en Java, sin IA.

## Material de estudio

- `docs/Guia_compacta_sintaxis_Java.pdf`: repaso completo con ejemplos, métodos y resultados.
- `docs/Chuleta_compacta_Java.pdf`: consulta rápida durante los primeros ejercicios.
- `exercises/EJERCICIOS_SINTAXIS.md`: hoja editable con los ejercicios por apartado y el control de progreso.

Empieza leyendo la guía. Después abre `EJERCICIOS_SINTAXIS.md` y trabaja un apartado cada vez en `CurrentChallenge.java` y `Main.java`.

## Abrir y ejecutar en IntelliJ

1. Abre IntelliJ IDEA.
2. Selecciona **Open** y abre esta carpeta.
3. Configura el Project SDK con el JDK instalado (Java 25 funciona; el código usa características compatibles con Java 17).
4. Abre `src/main/java/practice/Main.java`.
5. Ejecuta el método `main` con el botón verde.

No necesitas Spring, Docker, una base de datos ni Maven para practicar.

## Ejecutar desde terminal

Desde la raíz del proyecto, en PowerShell:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src/main/java/practice/*.java
java -cp out practice.Main
```

## Dinámica de práctica

Trabajaremos un ejercicio cada vez:

1. Yo te doy el enunciado sin decirte la estructura de datos ni la solución.
2. Tú lo repites con tus palabras y aclaras dudas antes de programar.
3. Escribes la función en `CurrentChallenge.java`.
4. Añades casos representativos en `Main.java`.
5. Ejecutas y corriges.
6. Explicas la solución y su complejidad temporal y espacial.
7. Yo cambio un requisito o añado un caso límite.

Durante un simulacro real:

- comparte el razonamiento, pero no narres cada carácter que escribes;
- confirma entradas, salida, nulos, duplicados y orden antes de empezar;
- comienza por una solución correcta y clara;
- ejecuta pronto con un caso sencillo;
- añade después casos límite;
- no uses ChatGPT, Copilot, JetBrains AI ni autocompletado generativo.

## Estructura

```text
src/main/java/practice/
├── Main.java               casos ejecutables y mini comprobador
└── CurrentChallenge.java   única función que debes implementar

exercises/
├── PROGRESSION.md          mapa de dificultad, sin soluciones
└── INTERVIEW_CHECKLIST.md  chuleta del proceso de live coding
```

## JUnit opcional

El `pom.xml` incluye JUnit 5. No es necesario para empezar. Si IntelliJ detecta Maven, puede cargar el proyecto usando su Maven integrado y ejecutar los tests de `src/test`. En la prueba real, `Main.java` es suficiente si te piden solamente programar una función y ejecutarla.

## Reiniciar para otro ejercicio

Sustituye el enunciado, la firma y el cuerpo de `CurrentChallenge.java`, y cambia los casos de `Main.java`. Mantén solo un ejercicio activo para que el entorno siga siendo sencillo.
