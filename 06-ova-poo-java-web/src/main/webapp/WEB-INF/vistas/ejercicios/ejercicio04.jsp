<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 04 — Reportes Polimórficos.
     La primera vez (GET) los dos vienen marcados; después se respeta lo que elegiste. --%>
<c:set var="primeraVez" value="${pageContext.request.method == 'GET'}"/>
<c:set var="elegidos" value="${fn:join(paramValues.tipo, ',')}"/>
<fieldset class="opciones">
  <legend>Reportes que se agregan a la List&lt;GeneradorReporte&gt;</legend>
  <label class="opcion">
    <input type="checkbox" name="tipo" value="pdf" ${primeraVez or fn:contains(elegidos, 'pdf') ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>ReportePDF</strong><small>extends GeneradorReporte</small></span>
  </label>
  <label class="opcion">
    <input type="checkbox" name="tipo" value="excel" ${primeraVez or fn:contains(elegidos, 'excel') ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>ReporteExcel</strong><small>extends GeneradorReporte</small></span>
  </label>
</fieldset>
