<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 02 — ClienteController --%>
<label class="campo">
  <span>ID del cliente</span>
  <input type="number" name="id" min="1" required placeholder="Ej: 7" value="${fn:escapeXml(param.id)}">
  <small>Simula el <code>args[0]</code> que recibiría el programa de consola.</small>
</label>
