<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 05 — Calculadora (sobrecarga) --%>
<div class="campos campos--3">
  <label class="campo">
    <span>Número A</span>
    <input type="number" name="a" step="any" required placeholder="Ej: 2" value="${fn:escapeXml(param.a)}">
  </label>
  <label class="campo">
    <span>Número B</span>
    <input type="number" name="b" step="any" required placeholder="Ej: 3" value="${fn:escapeXml(param.b)}">
  </label>
  <label class="campo">
    <span>Número C <em>(opcional)</em></span>
    <input type="number" name="c" step="any" placeholder="Ej: 4" value="${fn:escapeXml(param.c)}">
  </label>
</div>
