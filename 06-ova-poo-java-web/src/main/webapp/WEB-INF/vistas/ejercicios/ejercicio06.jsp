<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%-- Formulario del Ejercicio 06 — Notificaciones Abstractas --%>
<fieldset class="opciones">
  <legend>Canal (clase hija)</legend>
  <label class="opcion">
    <input type="radio" name="canal" value="email" ${param.canal != 'sms' ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>NotificadorEmail</strong><small>extends NotificadorAbstracto</small></span>
  </label>
  <label class="opcion">
    <input type="radio" name="canal" value="sms" ${param.canal == 'sms' ? 'checked' : ''}>
    <span class="opcion__cuerpo"><strong>NotificadorSMS</strong><small>extends NotificadorAbstracto</small></span>
  </label>
</fieldset>
<label class="campo">
  <span>API Key</span>
  <input type="text" name="apikey" required placeholder="Ej: KEY-123" value="${fn:escapeXml(param.apikey)}">
  <small>Se pasa al constructor de la clase base con <code>super(apiKey)</code>.</small>
</label>
<label class="campo">
  <span>Mensaje</span>
  <input type="text" name="msg" required placeholder="Ej: Tu pedido fue enviado" value="${fn:escapeXml(param.msg)}">
</label>
