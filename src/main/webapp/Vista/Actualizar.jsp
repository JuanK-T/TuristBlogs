<%@include file="headerMenuPrincipal.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<th:url value="/Estilos/editar.css"/>" media="screen" />
<main>
    <fieldset>
        <legend>Actualizar Perfil</legend>
        <form action="UsuarioController" method="post" enctype="multipart/form-data" class="formEditar" name="actualizar" id="actualizar">
            <input type="hidden" name="idUsuario" id="idUsuario" value="${datos.getIdUsuario()}">
            <div class="contenidoImagen">
                <img src="ControllerIMG?id=${datos.getIdUsuario()}" alt="Perfil" title="foto de Perfil">
                <div>
                    <span>${datos.getUser()}</span><br>
                    <input type="file" id="file-input" accept=".png, .gif, .jpeg, .jpg" name="fotoUsuario">
                    <label for="file-input" title="Subir Imagen">Cambiar foto de Perfil</label>
                </div>
            </div>
            <input type="hidden" name="usuario" id="usuario" value="${datos.getUser()}">
            <input type="hidden" name="fechaCreation" id="fechaCreacion" value="${datos.getFechaCreacion()}">
            <label for="nombre">Nombre:</label><br>
            <input type="text" name="nombre" id="nombre" required value="${datos.getNombre()}">
            <br><br>

            <label for="telefono">Telefono:</label><br>
            <input type="number" id="telefono" name="telefono" value="${datos.getTelefono()}">
            <br><br>
            <label for="correo">Correo:</label><br>
            <input type="email" id="correo" name="correo" required value="${datos.getCorreo()}">
            <br><br>

            <label for="contrasena">Clave:</label><br>
            <input type="password" id="contrasena" name="contrasena" required value="${datos.getContrasena()}">
            <br><br>

            <button type="submit" name="accion" class="button" value="registrar" id="Guardar">Actualizar</button>
        </form>
    </fieldset>
</main>
<script src="../JS/MenuPrincipal.js"></script>
<%@include file="Footer.jsp" %>