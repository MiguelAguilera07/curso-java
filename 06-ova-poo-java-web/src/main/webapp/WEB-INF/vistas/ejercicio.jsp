<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- VISTA: plantilla de un ejercicio.
     Datos que llegan desde el servlet: "ejercicio" (siempre), "resultado" o "error" (después de Ejecutar). --%>
<c:set var="tituloPagina" value="Ejercicio ${ejercicio.codigo} — ${ejercicio.titulo}"/>
<%@ include file="/WEB-INF/vistas/comun/cabecera.jspf" %>

<header class="cabecera-ej tema-${ejercicio.numero}">
  <div class="contenedor">
    <nav class="migas" aria-label="Ruta">
      <a href="${ctx}/">Inicio</a>
      <span aria-hidden="true">/</span>
      <span>Ejercicio ${ejercicio.codigo}</span>
    </nav>
    <div class="cabecera-ej__fila">
      <span class="cabecera-ej__numero">${ejercicio.codigo}</span>
      <div>
        <p class="cabecera-ej__etiquetas">
          <span class="etiqueta etiqueta--clara">${ejercicio.concepto}</span>
          <span class="prioridad prioridad--${ejercicio.prioridadCss}">Prioridad ${ejercicio.prioridad}</span>
        </p>
        <h1><c:out value="${ejercicio.titulo}"/></h1>
      </div>
    </div>
  </div>
</header>

<main class="contenedor contenido-ej tema-${ejercicio.numero}">

  <section class="panel">
    <h2 class="panel__titulo">Enunciado</h2>
    <p class="enunciado"><c:out value="${ejercicio.enunciado}"/></p>
    <h3 class="panel__subtitulo">Clases que intervienen</h3>
    <ul class="archivos">
      <c:forEach var="clase" items="${ejercicio.clases}">
        <li><code>src/main/java/<c:out value="${clase}"/></code></li>
      </c:forEach>
    </ul>
  </section>

  <div class="rejilla">
    <section class="panel">
      <h2 class="panel__titulo">Probar el ejercicio</h2>
      <p class="pista"><c:out value="${ejercicio.pista}"/></p>
      <form method="post" action="${ctx}/ejercicio/${ejercicio.numero}" class="formulario">
        <%-- Cada ejercicio tiene su propio formulario en /WEB-INF/vistas/ejercicios/ --%>
        <jsp:include page="/WEB-INF/vistas/ejercicios/${ejercicio.vista}"/>
        <button type="submit" class="boton">Ejecutar <span aria-hidden="true">▸</span></button>
      </form>
    </section>

    <section class="panel">
      <h2 class="panel__titulo">Resultado</h2>
      <c:choose>
        <c:when test="${not empty error}">
          <div class="alerta" role="alert">
            <strong>Revisa los datos</strong>
            <span><c:out value="${error}"/></span>
          </div>
        </c:when>
        <c:when test="${not empty resultado}">
          <div class="consola">
            <div class="consola__barra"><span></span><span></span><span></span><em>Salida del programa</em></div>
            <pre><c:out value="${resultado}"/></pre>
          </div>
        </c:when>
        <c:otherwise>
          <div class="vacio">
            <span class="vacio__icono" aria-hidden="true">▸_</span>
            <p>Llena el formulario y presiona <strong>Ejecutar</strong> para ver la respuesta de las clases.</p>
          </div>
        </c:otherwise>
      </c:choose>
    </section>
  </div>

  <section class="panel">
    <h2 class="panel__titulo">Diagrama UML</h2>
    <a class="uml" href="${ctx}/img/uml/${ejercicio.uml}" target="_blank" rel="noopener">
      <img src="${ctx}/img/uml/${ejercicio.uml}" alt="Diagrama UML del ejercicio ${ejercicio.codigo}" loading="lazy">
    </a>
    <p class="nota">Haz clic en el diagrama para verlo en tamaño completo.</p>
  </section>

  <nav class="paginacion" aria-label="Otros ejercicios">
    <c:if test="${not empty ejercicio.anterior}">
      <a class="paginacion__enlace" href="${ctx}/ejercicio/${ejercicio.anterior.numero}">
        <small>← Anterior</small>
        <span>${ejercicio.anterior.codigo} · <c:out value="${ejercicio.anterior.titulo}"/></span>
      </a>
    </c:if>
    <c:if test="${not empty ejercicio.siguiente}">
      <a class="paginacion__enlace paginacion__enlace--siguiente" href="${ctx}/ejercicio/${ejercicio.siguiente.numero}">
        <small>Siguiente →</small>
        <span>${ejercicio.siguiente.codigo} · <c:out value="${ejercicio.siguiente.titulo}"/></span>
      </a>
    </c:if>
  </nav>
</main>

<%@ include file="/WEB-INF/vistas/comun/pie.jspf" %>
