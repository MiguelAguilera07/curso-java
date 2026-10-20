<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 07 — Almacenamiento con interfaz --%>
<fieldset class="opciones">
  <legend>Implementación que se inyecta</legend>
  <label class="opcion">
    <input type="radio" name="tipo" value="local" ${param.tipo != 's3' ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>LocalStorage</strong><small>guarda con java.nio.file</small></span>
  </label>
  <label class="opcion">
    <input type="radio" name="tipo" value="s3" ${param.tipo == 's3' ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>S3Storage</strong><small>simula AWS S3</small></span>
  </label>
</fieldset>
<label class="campo">
  <span>Nombre del archivo</span>
  <input type="text" name="nombre" required placeholder="Ej: notas.txt" value="${fn:escapeXml(param.nombre)}">
</label>
<label class="campo">
  <span>Contenido</span>
  <textarea name="contenido" rows="3" placeholder="Texto que se guardará en el archivo">${fn:escapeXml(param.contenido)}</textarea>
</label>
