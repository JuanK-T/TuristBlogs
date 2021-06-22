<%@include file="headerMenuPrincipal.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<th:url value="/Estilos/Perfil.css"/>" media="screen" />
<main>
    <div class="contentPerfil">
        <div class="contentImagen">
            <img src="ControllerIMG?id=${nombreUsuario.getIdUsuario()}" alt="Foto Perfil" title="foto de Perfil">
                <input type="file" id="file-input" name="fotoUsuario" value="${nombreUsuario.getFotoUsuario()}">
            <label for="file-input" title="Subir Imagen"><i class="fas fa-camera"></i></label>
        </div>
        <div class="datosPerfil">
            <span id="nombre">${nombreUsuario.getNombre()}</span>
            <span id="usuario">${nombreUsuario.getUser()}</span>
            <span id="publicaciones">publicaciones 1</span>
            <div>
                <span id="seguido">Seguiendo a 3 / </span>
                <span id="seguidores">Seguidores 1</span>
            </div>
        </div>
        <div class="editarPerfil">
            <button style="color: white">
                <i class="fas fa-pen"></i>
                <a href="UsuarioController?accion=Cargar&idUsuario=${nombreUsuario.getIdUsuario()}">
                    Editar Perfil
                </a>
            </button>
        </div>
    </div>
</main>
<%@include file="Footer.jsp" %>