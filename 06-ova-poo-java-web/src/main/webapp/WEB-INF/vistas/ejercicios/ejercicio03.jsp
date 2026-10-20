<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 03 — Empleado Seguro.
     A propósito NO se limita el valor con min/max: la validación la hace la clase Empleado. --%>
<label class="campo">
  <span>Nuevo salario</span>
  <input type="number" name="salario" step="any" required placeholder="Entre 0 y 10000" value="${fn:escapeXml(param.salario)}">
  <small>Se envía a <code>empleado.ajustarSalario(nuevoSalario)</code>.</small>
</label>
