<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 01 — Clase Cliente --%>
<div class="campos campos--2">
  <label class="campo">
    <span>ID</span>
    <input type="number" name="id" min="1" required placeholder="Ej: 1" value="${fn:escapeXml(param.id)}">
  </label>
  <label class="campo">
    <span>Nombre</span>
    <input type="text" name="nombre" required placeholder="Ej: Ana" value="${fn:escapeXml(param.nombre)}">
  </label>
</div>
<label class="campo">
  <span>Email</span>
  <input type="email" name="email" required placeholder="ana@mail.com" value="${fn:escapeXml(param.email)}">
</label>
<label class="campo">
  <span>Fecha de registro</span>
  <input type="date" name="fecha" required value="${fn:escapeXml(param.fecha)}">
</label>
