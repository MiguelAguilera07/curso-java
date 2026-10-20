<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- VISTA: página de inicio. Los datos llegan desde web.InicioServlet ("ejercicios"). --%>
<c:set var="tituloPagina" value="Inicio"/>
<%@ include file="/WEB-INF/vistas/comun/cabecera.jspf" %>

<header class="hero">
  <div class="contenedor hero__rejilla">
    <div>
      <p class="hero__etiqueta">Objeto Virtual de Aprendizaje · Java 17+</p>
      <h1 class="hero__titulo">Programación Orientada a Objetos <span>en Java</span></h1>
      <p class="hero__texto">
        Los 7 ejercicios del OVA funcionando en la web con Servlets, JSP y Apache Tomcat.
        Elige uno, llena el formulario y mira cómo responden las clases.
      </p>
      <div class="hero__acciones">
        <a class="boton" href="#ejercicios">Ver ejercicios</a>
        <a class="boton boton--fantasma" href="#arquitectura">Arquitectura</a>
      </div>
      <dl class="cifras">
        <div><dt>7</dt><dd>Ejercicios</dd></div>
        <div><dt>4</dt><dd>Pilares de la POO</dd></div>
        <div><dt>MVC</dt><dd>Arquitectura</dd></div>
      </dl>
    </div>

    <div class="codigo-deco" aria-hidden="true">
      <div class="codigo-deco__barra"><span></span><span></span><span></span><em>Aprendiz.java</em></div>
<pre><span class="kw">public class</span> <span class="ty">Aprendiz</span> {
    <span class="kw">private</span> <span class="ty">String</span> nombre =
        <span class="st">"<c:out value="${initParam.aprendiz}"/>"</span>;

    <span class="an">@Override</span>
    <span class="kw">public</span> <span class="ty">String</span> <span class="fn">toString</span>() {
        <span class="kw">return</span> <span class="st">"Aprendiendo POO"</span>;
    }

    <span class="kw">public boolean</span> <span class="fn">dominaPOO</span>() {
        <span class="kw">return true</span>; <span class="cm">// ✔</span>
    }
}</pre>
    </div>
  </div>
</header>

<main class="contenedor">

  <section class="seccion" id="ejercicios">
    <div class="seccion__encabezado">
      <p class="seccion__antetitulo">Módulos del OVA</p>
      <h2>Ejercicios</h2>
      <p>Cada tarjeta corresponde a un módulo del OVA. Todas usan las mismas clases que el programa de consola (<code>Main.java</code>).</p>
    </div>

    <ol class="tarjetas">
      <c:forEach var="ej" items="${ejercicios}">
        <li>
          <a class="tarjeta tema-${ej.numero}" href="${ctx}/ejercicio/${ej.numero}">
            <span class="tarjeta__numero">${ej.codigo}</span>
            <span class="etiqueta">${ej.concepto}</span>
            <h3 class="tarjeta__titulo"><c:out value="${ej.titulo}"/></h3>
            <p class="tarjeta__texto"><c:out value="${ej.resumen}"/></p>
            <span class="tarjeta__pie">
              <span class="prioridad prioridad--${ej.prioridadCss}">Prioridad ${ej.prioridad}</span>
              <span class="tarjeta__ir">Probar <span aria-hidden="true">→</span></span>
            </span>
          </a>
        </li>
      </c:forEach>
    </ol>
  </section>

  <section class="seccion" id="arquitectura">
    <div class="seccion__encabezado">
      <p class="seccion__antetitulo">Cómo está organizado</p>
      <h2>Arquitectura del proyecto (MVC)</h2>
      <p>Cada capa vive en su propia carpeta y tiene una sola responsabilidad.</p>
    </div>

    <ol class="flujo">
      <li class="flujo__paso">
        <span class="flujo__num">1</span>
        <strong>Navegador</strong>
        <span>Formulario HTML que envía los datos</span>
      </li>
      <li class="flujo__paso">
        <span class="flujo__num">2</span>
        <strong>Servlet</strong>
        <code>web.ejercicios</code>
        <span>Recibe la petición y valida los datos</span>
      </li>
      <li class="flujo__paso">
        <span class="flujo__num">3</span>
        <strong>Controlador</strong>
        <code>controladores</code>
        <span>Crea los objetos y coordina</span>
      </li>
      <li class="flujo__paso">
        <span class="flujo__num">4</span>
        <strong>Modelo y servicios</strong>
        <code>modelos · servicios</code>
        <span>Las clases POO del OVA</span>
      </li>
      <li class="flujo__paso">
        <span class="flujo__num">5</span>
        <strong>Vista JSP</strong>
        <code>WEB-INF/vistas</code>
        <span>Arma el HTML de la respuesta</span>
      </li>
    </ol>

    <div class="panel panel--arbol">
      <h3>Estructura de carpetas</h3>
<pre class="arbol">src/main/
├── java/
│   ├── <b>Main.java</b>                  <i>← versión de consola (los 7 ejercicios)</i>
│   ├── <b>modelos/</b>                   <i>← M: Cliente, Empleado</i>
│   ├── <b>servicios/</b>                 <i>← M: lógica reutilizable</i>
│   │   ├── Calculadora.java
│   │   ├── reportes/             <i>  (herencia y polimorfismo)</i>
│   │   ├── notificaciones/       <i>  (clase abstracta)</i>
│   │   └── almacenamiento/       <i>  (interfaz)</i>
│   ├── <b>controladores/</b>             <i>← C: ClienteController, ReporteController, SubidaController</i>
│   └── <b>web/</b>                       <i>← capa web</i>
│       ├── Ejercicio.java        <i>  (catálogo de los 7 ejercicios)</i>
│       ├── EjercicioServlet.java <i>  (servlet base abstracto)</i>
│       ├── InicioServlet.java
│       └── ejercicios/           <i>  Ejercicio01Servlet … Ejercicio07Servlet</i>
└── webapp/
    ├── css/estilos.css
    ├── img/uml/                  <i>← diagramas UML</i>
    └── WEB-INF/vistas/           <i>← V: páginas JSP</i>
        ├── comun/                <i>  cabecera y pie compartidos</i>
        └── ejercicios/           <i>  un formulario por ejercicio</i></pre>
    </div>
  </section>
</main>

<%@ include file="/WEB-INF/vistas/comun/pie.jspf" %>
