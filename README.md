## Proyecto de Prueba

**Proyecto: To-Do List Application**

**Descripción**: Crear una aplicación todo-list que permita con asignación a usuarios y mostrar las tareas con sus asignados.

**Requisitos**:
- CRUD para las tareas.
- Endpoint para crear una tarea.
- Endpoint para crear un usuario.
- Endpoint para actualizar una tarea y asignarla a un usuario.
- Endpoint para listar tareas mostrando los usuarios asignados.
- Las URLs para los servicios REST deben tener el verbo HTTP apropiado para cada operación.
- Los servicios deben aceptar y responder en formato JSON.
- Persistencia de datos en una base de datos relacional (PostgreSQL).
- Utiliza Maven como gestor de dependencias
- Interfaz de usuario básica con React (Se puede utilizar Ant-design, MaterialUI, o cualquiera de la preferencia del candidato).
- Documentación con Swagger (opcional).
- Dockerización del proyecto (opcional).
- Colecciones en Postman con los endpoints (opcional).

**Criterios de Evaluación**:
- Correctitud y funcionalidad.
- Calidad del código y organización.
- Uso adecuado de patrones de diseño.
- Documentación y claridad en el código.
- Eficiencia y manejo de errores.

Pasos iniciales
---------------

## Empezando a trabajar

Para empezar crear un fork de este repositorio para implementar los ejercicios.

Adjuntar cualquier documentación al proyecto en forma de archivos con extensión `.md`.

Se recomienda ir haciendo commits a medida que se avanza con la solución. Agrupando estos commits si corresponde hacerlo.


### Contruyendo el proyecto

El proyecto incluye un pom.xml que permite construir un paquete jar utilizando [Maven](http://maven.apache.org). Simplemente corriendo `mvn package` descargará todas las dependencias necesarias y construirá un paquete jar estándar.


## Refactorización de Código

En este ejercicio, el código existente carece de patrones de diseño adecuados. El objetivo es aplicar un patrón adecuado para mejorar la modularidad y flexibilidad del código.

**Código Original**:
```java
class Vehiculo {
    private String type;

    public Vehiculo(String type) {
        this.type = type;
    }

    public void acelerar() {
        if (type.equals("auto")) {
            System.out.println("El auto esta acelerando...");
        } else if (type.equals("motocicleta")) {
            System.out.println("La motocicleta esta acelerando...");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vehiculo auto = new Vehiculo("auto");
        Vehiculo motocicleta = new Vehiculo("motocicleta");

        car.acelerar();
        motorcycle.acelerar();
    }
}
```

**Tarea de Refactorización**:
- Implementar el patrón de diseño Strategy para separar los comportamientos de aceleración.
- Crear clases concretas y una interfaz que abstraiga el comportamiento común.


## Programación de algoritmo

**Problema:** Ruta Más Corta en un Grafo Ponderado no Dirigido

Dado un grafo ponderado no dirigido, representado como una lista de aristas donde cada arista tiene un peso, encuentra la ruta más corta desde un nodo inicial hasta un nodo objetivo utilizando el algoritmo de Dijkstra.

**Entrada:**
- `n`: Número de nodos en el grafo.
- `edges`: Lista de aristas, donde cada arista está representada como un arreglo `[u, v, w]` que indica que hay una arista de peso `w` entre los nodos `u` y `v` (1 ≤ `u, v` ≤ `n`, `u ≠ v`).

**Salida:**
- Un arreglo de longitud `n` donde el valor en la posición `i` es la distancia más corta desde el nodo inicial hasta el nodo `i`.

**Ejemplo:**

Entrada:
```java
int n = 5;
int[][] edges = {
    {1, 2, 1},
    {1, 3, 4},
    {2, 3, 2},
    {2, 4, 5},
    {3, 4, 1},
    {4, 5, 3}
};
```

**Salida esperada:**

```java
[0, 1, 3, 6, 9]
```

**Explicación:**

En el grafo dado:

- Desde el nodo 1, la ruta más corta a:
  - Nodo 2 es 1 (1 → 2).
  - Nodo 3 es 3 (1 → 2 → 3).
  - Nodo 4 es 6 (1 → 2 → 3 → 4).
  - Nodo 5 es 9 (1 → 2 → 3 → 4 → 5).

Utiliza el algoritmo de Dijkstra para resolver este problema. Asegúrate de manejar adecuadamente casos donde no haya ruta entre el nodo inicial y otros nodos.


## Formato de Entrega y Revisión

- **Repositorio GitHub**: Al finalizar enviar un email a [ti@lincoln.com.py](mailto:ti@lincoln.com.py) con el link al fork.

- **Colecciones en Postman**: Se deben exportar las colecciones de Postman con los endpoints de la API y proporcionar el archivo JSON o el enlace de importación.

Por favor, asegúrate de compartir los enlaces y archivos necesarios para la revisión con el siguiente correo electrónico: [ti@lincoln.com.py](mailto:ti@lincoln.com.py).
