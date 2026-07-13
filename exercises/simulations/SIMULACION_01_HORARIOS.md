# Simulación 01 — Negocios abiertos

## Contexto

Una plataforma mantiene en memoria un conjunto de negocios y sus horarios semanales. Se necesita consultar qué negocios están abiertos en un día y una hora determinados.

## Requisitos

Diseña e implementa una solución en Java que:

1. Represente un negocio mediante un identificador, un nombre y sus intervalos de apertura.
2. Permita que un negocio tenga varios intervalos durante un mismo día.
3. Reciba un conjunto de negocios, un día de la semana y una hora.
4. Devuelva los negocios abiertos en ese instante, conservando su orden de entrada.
5. No modifique los datos recibidos.

Un intervalo sigue la regla **[apertura, cierre)**:

- la hora exacta de apertura está incluida;
- la hora exacta de cierre está excluida.

Para esta primera versión:

- todos los argumentos serán válidos y no serán `null`;
- cada intervalo tendrá una apertura anterior al cierre;
- ningún intervalo cruzará la medianoche;
- un negocio sin intervalos para el día consultado está cerrado.

## Datos con los que debes ejecutar la solución

| ID | Negocio | Día | Apertura | Cierre |
|---:|---|---|---|---|
| 1 | Bakery | MONDAY | 08:00 | 14:00 |
| 2 | Restaurant | MONDAY | 12:00 | 16:00 |
| 2 | Restaurant | MONDAY | 19:00 | 23:00 |
| 3 | Weekend shop | SATURDAY | 09:00 | 20:00 |

## Resultados mínimos que debes comprobar

| Consulta | Resultado esperado |
|---|---|
| MONDAY 08:00 | Bakery |
| MONDAY 13:00 | Bakery, Restaurant |
| MONDAY 14:00 | Restaurant |
| MONDAY 18:00 | ninguno |
| MONDAY 19:00 | Restaurant |
| MONDAY 23:00 | ninguno |
| SATURDAY 10:00 | Weekend shop |

## Entrega esperada

- Código ejecutable desde `InterviewSimulation.main`.
- Modelo y funciones que consideres necesarios.
- Casos ejecutados que muestren resultado esperado y obtenido.
- Explicación breve de tus decisiones y de la complejidad temporal y espacial.

No se proporcionan firmas, clases ni estructuras predefinidas. Decide tú cómo modelarlo. No implementes todavía horarios nocturnos, persistencia, Spring ni una API REST.
