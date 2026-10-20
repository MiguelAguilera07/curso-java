# OVA — Programación Orientada a Objetos en Java (versión web)

Solución de los **7 ejercicios** del OVA *POO en Java*, organizada con arquitectura **MVC**,
que se puede usar de dos formas:

- **En la web:** con Servlets + JSP sobre **Apache Tomcat 10.1**. Cada ejercicio tiene una página con un formulario, el resultado y su diagrama UML.
- **En consola:** con `Main.java`, que ejecuta los 7 ejercicios seguidos.

**Aprendiz:** Miguel Ángel Aguilera Satina · SENA

## Ejercicios

| # | Ejercicio | Concepto | Clases | Página |
|---|-----------|----------|--------|--------|
| 01 | Clase Cliente | Clases y Objetos | `modelos/Cliente` | `/ejercicio/1` |
| 02 | Controlador de Clientes | Instanciamiento | `controladores/ClienteController` | `/ejercicio/2` |
| 03 | Empleado Seguro | Encapsulamiento | `modelos/Empleado` | `/ejercicio/3` |
| 04 | Reportes Polimórficos | Polimorfismo | `servicios/reportes/*`, `controladores/ReporteController` | `/ejercicio/4` |
| 05 | Calculadora Flexible | Sobrecarga | `servicios/Calculadora` | `/ejercicio/5` |
| 06 | Notificaciones Abstractas | Abstracción | `servicios/notificaciones/*` | `/ejercicio/6` |
| 07 | Almacenamiento de Archivos | Interfaces | `servicios/almacenamiento/*`, `controladores/SubidaController` | `/ejercicio/7` |

## Arquitectura (MVC)

```
Navegador ──► Servlet ──► Controlador ──► Modelo / Servicio
 (form)      (web)      (controladores)   (modelos, servicios)
    ▲                                            │
    └──────────── Vista JSP (WEB-INF/vistas) ◄───┘
```

```
src/main/
├── java/
│   ├── Main.java                  ← versión de consola (los 7 ejercicios)
│   ├── modelos/                   ← MODELO: Cliente, Empleado
│   ├── servicios/                 ← MODELO: lógica reutilizable
│   │   ├── Calculadora.java
│   │   ├── reportes/              (herencia y polimorfismo)
│   │   ├── notificaciones/        (clase abstracta)
│   │   └── almacenamiento/        (interfaz)
│   ├── controladores/             ← CONTROLADOR: ClienteController, ReporteController, SubidaController
│   └── web/                       ← capa web
│       ├── Ejercicio.java         (catálogo con los datos de los 7 ejercicios)
│       ├── EjercicioServlet.java  (servlet base abstracto: GET muestra, POST procesa)
│       ├── InicioServlet.java     (página de inicio)
│       └── ejercicios/            Ejercicio01Servlet … Ejercicio07Servlet
└── webapp/
    ├── css/estilos.css
    ├── img/uml/                   ← diagramas UML (PNG)
    └── WEB-INF/
        ├── web.xml
        └── vistas/                ← VISTA: páginas JSP
            ├── inicio.jsp
            ├── ejercicio.jsp      (plantilla común de un ejercicio)
            ├── comun/             (cabecera y pie compartidos)
            └── ejercicios/        (un formulario por ejercicio)
```

## Requisitos

- JDK 17 o superior
- Apache Tomcat **10.1** (usa `jakarta.servlet`)
- Maven 3.9 (o la extensión *Extension Pack for Java* de VS Code)

## Cómo ejecutarlo en Tomcat

1. Empaquetar el proyecto (en la carpeta donde está `pom.xml`):
   ```
   mvn clean package
   ```
   Se genera `target/ova-poo-java-web.war`.
2. Copiar `ova-poo-java-web.war` a la carpeta `webapps` de Tomcat.
3. Iniciar Tomcat con `bin/startup.bat` (Windows) o `bin/startup.sh` (Linux/Mac).
4. Abrir en el navegador:
   - http://localhost:8080/ova-poo-java-web/
   - http://localhost:8080/ova-poo-java-web/ejercicio/1 (del 1 al 7)

## Cómo ejecutar la versión de consola

```
mvn compile
java -cp target/classes Main
```

O abrir `src/main/java/Main.java` en VS Code y presionar **Run**.
