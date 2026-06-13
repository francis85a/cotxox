## Resumen rápido para un agente AI

Este repositorio es una pequeña aplicación Java empaquetada con Maven (JDK 21). Usa JUnit 5 + AssertJ para tests y JaCoCo para cobertura.

- Build & test: usa Maven. Ejemplos (PowerShell):
  - `mvn -B test` — ejecutar tests
  - `mvn -B package` — compilar y crear JAR
  - `mvn -B -DskipTests package` — compilar sin tests

## Estructura clave y puntos de entrada

- `pom.xml` — configuración principal: JDK 21 (<maven.compiler.release>21</maven.compiler.release>), JUnit 5, JaCoCo y plugins de compilación
- Código fuente principal: `src/main/java/edu/teamrocket/cotxox/`
  - `Cotxox.java` — ejemplo con `public static void main` que crea una `Carrera` y una flota de conductores; útil para entender el flujo de creación/uso de objetos
  - `carrera/Carrera.java` — clase del dominio (actualmente vacía en el árbol fuente). Buscar referencias en el proyecto para entender su API (métodos usados en `Cotxox.java`: `setOrigen`, `setDestino`, `setDistancia`, `setTiempoEsperado`, `getCosteEsperado`, `asignarConductor`, `realizarPago`, `recibirPropina`, `liberarConductor`, `getConductor`, etc.)

## Dependencias e integración

- Tests: JUnit Jupiter + AssertJ (ver `pom.xml`) — las pruebas se ejecutan con `mvn test`.
- Cobertura: JaCoCo configurado en el pom; genera informe en `target/site/jacoco`.

## Conventions y observaciones específicas del proyecto

- Java release target: 21 (asegúrate de usar un JDK >= 21 para build localmente).
- Jar manifest: `maven-jar-plugin` configura `Main-Class` en `edu.teamrocket.cotxox.App` pero en la fuente visible hay `Cotxox.java` con `main`. Verificar/ajustar `pom.xml` o agregar `App` si planeas ejecutar el JAR.
- Pares de métodos esperados por el código de ejemplo (`Cotxox.java`) describen la API del dominio `Carrera` y la interacción con una flota (`PoolConductores`) y `Conductor`. Si implementas o modificas estas clases, mantén los nombres/métodos usados por el ejemplo para compatibilidad.

## Flujo esencial a entender para cambios

1. Crear una `Carrera` con tarjeta y parámetros (origen, destino, distancia, tiempo esperado).
2. Crear/inyectar una colección de `Conductor` en un `PoolConductores`.
3. Llamar `carrera.asignarConductor(...)` para seleccionar un conductor; luego `realizarPago`, `recibirPropina` y `liberarConductor` según flujo.

## Debugging y pruebas

- Ejecuta `mvn -DtrimStackTrace=false test` para ver trazas completas.
- Los artefactos compilados y reportes de cobertura están en `target/`.

## Ejemplos concretos (referencias de código)

- Ver `src/main/java/edu/teamrocket/cotxox/Cotxox.java` para un flujo completo de ejemplo que crea objetos, asigna conductor y simula pago/propina.
- Usa los nombres de métodos que aparecen allí al implementar `Carrera` y clases relacionadas.

## Qué no está presente / Inconsistencias detectadas

- `carrera/Carrera.java` en `src/main` aparece vacío; sin embargo `Cotxox.java` lo usa intensamente. El código compilado en `target/classes` sugiere que fuentes completas pueden existir fuera del árbol visible o fueron compiladas previamente. Antes de reescribir, buscar en control de versiones o en ramas remotas para recuperar la implementación completa.
- `pom.xml` referencia `Main-Class: edu.teamrocket.cotxox.App` pero no hay `App.java` en el árbol fuente; esto puede romper la ejecución del JAR.

## Qué pedir al desarrollador si algo está poco claro

- ¿Cuál es la implementación canónica de `Carrera` y las clases del dominio (`Conductor`, `PoolConductores`)?
- ¿Debería el `Main-Class` del POM apuntar a `Cotxox` o existe una `App` oculta/en otra rama?

Si quieres, actualizo el `pom.xml` para apuntar al main correcto o creo una `App` delegando a `Cotxox.main` para armonizar la configuración.
