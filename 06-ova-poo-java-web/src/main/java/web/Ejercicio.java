package web;

import java.util.List;

/**
 * Catálogo de los 7 ejercicios del OVA (enunciado, diagrama, clases, etc.).
 * Las vistas JSP lo usan para pintar el menú de inicio y la cabecera de cada ejercicio.
 */
public enum Ejercicio {

    CLIENTE(1, "Clase Cliente", "Clases y Objetos", "Básica",
            "Atributos privados, constructor y el método esNuevo().",
            "Crea una clase Cliente en el paquete modelos. Debe tener atributos: id, email, nombre y fechaRegistro. "
                    + "Incluye un constructor y un método esNuevo() que retorne true si se registró hace menos de 30 días.",
            "Prueba con una fecha de hace 10 días y luego con una de hace 2 meses.",
            "01_Cliente.png",
            "modelos/Cliente.java"),

    CLIENTE_CONTROLLER(2, "Controlador de Clientes", "Instanciamiento", "Media",
            "Un controlador que crea un Cliente con new.",
            "Crea un ClienteController. En su método verPerfil(int id), instancia un objeto Cliente (del ejercicio anterior) "
                    + "con datos hardcodeados e imprime sus datos por consola usando System.out.println.",
            "Escribe cualquier ID: el controlador crea el objeto Cliente con ese ID.",
            "02_ClienteController.png",
            "controladores/ClienteController.java", "modelos/Cliente.java"),

    EMPLEADO(3, "Empleado Seguro", "Encapsulamiento", "Media",
            "Salario privado que solo cambia con ajustarSalario().",
            "Crea la clase Empleado. El atributo salario debe ser private. Nadie puede modificarlo directamente, "
                    + "solo mediante el método ajustarSalario(float nuevoSalario) que valide que el salario no sea negativo ni mayor a 10 000.",
            "Prueba con 5000 (válido) y con 20000 o -1 para ver la validación.",
            "03_Empleado.png",
            "modelos/Empleado.java"),

    REPORTES(4, "Reportes Polimórficos", "Polimorfismo", "Alta",
            "Una lista de GeneradorReporte donde cada hijo responde distinto.",
            "Crea una clase base GeneradorReporte con un método generar(). Crea dos hijos: ReportePDF y ReporteExcel. "
                    + "El método generar() debe retornar un String diferente según el tipo. "
                    + "Usa una List<GeneradorReporte> para generar ambos reportes en un bucle for-each.",
            "Marca uno o los dos reportes: el mismo for-each produce resultados distintos.",
            "04_Reportes.png",
            "servicios/reportes/GeneradorReporte.java", "servicios/reportes/ReportePDF.java",
            "servicios/reportes/ReporteExcel.java", "controladores/ReporteController.java"),

    CALCULADORA(5, "Calculadora Flexible", "Sobrecarga", "Media",
            "Dos versiones del método operar() con distinta firma.",
            "Crea una clase Calculadora con sobrecarga real del método operar: una versión que reciba 2 números (suma) "
                    + "y otra que reciba 3 números (donde el tercero multiplica el resultado de la suma). "
                    + "No uses parámetros por defecto: deben ser dos firmas de método distintas.",
            "Deja C vacío para usar operar(a, b); escríbelo para usar operar(a, b, c).",
            "05_Calculadora.png",
            "servicios/Calculadora.java"),

    NOTIFICACIONES(6, "Notificaciones Abstractas", "Abstracción", "Alta",
            "Clase abstracta con una API Key común para Email y SMS.",
            "Crea NotificadorAbstracto con método abstracto enviar(String msg). Implementa NotificadorEmail y NotificadorSMS. "
                    + "Asegúrate de que el constructor de la clase base reciba una configuración común (por ejemplo, una API Key).",
            "Cambia entre Email y SMS con el mismo mensaje y compara la salida.",
            "06_Notificador.png",
            "servicios/notificaciones/NotificadorAbstracto.java", "servicios/notificaciones/NotificadorEmail.java",
            "servicios/notificaciones/NotificadorSMS.java"),

    ALMACENAMIENTO(7, "Almacenamiento de Archivos", "Interfaces", "Alta",
            "Un controlador que recibe la interfaz StorageInterface.",
            "Define la interfaz StorageInterface con métodos save(String archivo) y delete(String archivo). "
                    + "Crea dos implementaciones: LocalStorage (guarda en una carpeta local con java.nio.file) y S3Storage "
                    + "(simula guardar en AWS con un System.out.println). Inyecta la interfaz en un controlador de subida de archivos.",
            "Elige LocalStorage o S3Storage: SubidaController funciona igual con los dos.",
            "07_Storage.png",
            "servicios/almacenamiento/StorageInterface.java", "servicios/almacenamiento/LocalStorage.java",
            "servicios/almacenamiento/S3Storage.java", "controladores/SubidaController.java");

    private final int numero;
    private final String titulo;
    private final String concepto;
    private final String prioridad;
    private final String resumen;
    private final String enunciado;
    private final String pista;
    private final String uml;
    private final List<String> clases;

    Ejercicio(int numero, String titulo, String concepto, String prioridad, String resumen,
              String enunciado, String pista, String uml, String... clases) {
        this.numero = numero;
        this.titulo = titulo;
        this.concepto = concepto;
        this.prioridad = prioridad;
        this.resumen = resumen;
        this.enunciado = enunciado;
        this.pista = pista;
        this.uml = uml;
        this.clases = List.of(clases);
    }

    public int getNumero() { return numero; }
    public String getTitulo() { return titulo; }
    public String getConcepto() { return concepto; }
    public String getPrioridad() { return prioridad; }
    public String getResumen() { return resumen; }
    public String getEnunciado() { return enunciado; }
    public String getPista() { return pista; }
    public String getUml() { return uml; }
    public List<String> getClases() { return clases; }

    /** "01", "02"... para mostrar en pantalla. */
    public String getCodigo() { return String.format("%02d", numero); }

    /** Archivo JSP con el formulario de este ejercicio (en /WEB-INF/vistas/ejercicios/). */
    public String getVista() { return "ejercicio" + getCodigo() + ".jsp"; }

    /** Clase CSS de la prioridad, sin tildes: "basica", "media", "alta". */
    public String getPrioridadCss() { return prioridad.equals("Básica") ? "basica" : prioridad.toLowerCase(); }

    public Ejercicio getAnterior() { return numero > 1 ? values()[numero - 2] : null; }
    public Ejercicio getSiguiente() { return numero < values().length ? values()[numero] : null; }
}
