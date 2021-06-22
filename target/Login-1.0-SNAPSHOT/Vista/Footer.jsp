<%@ taglib prefix="js" uri="http://java.sun.com/jsp/jstl/core" %>
<button class="footeBoton">
    <a href="UsuarioController?accion=Salir">
        Cerrar Sesion
    </a>
</button>
<button class="footeBoton">
    <a role="button" id="Eliminar"
           href="UsuarioController?accion=Eliminar&idUsuario=${nombreUsuario.getIdUsuario()}">
        Eliminar Cuenta
    </a>
</button>
<style type="text/css">
    .footeBoton{
        background-color: #4d8cf2;
        padding: 12px;
        color: #fff;
        border: 2px solid white;
        border-radius: 40px;
        margin: 10px;
    }

    .footeBoton a{
        color: white;
        text-decoration: none;
    }

    .footeBoton:hover{
        background-color: #3b73ce;
        border-color: #729fe7;
        cursor: pointer;
    }
</style>
<!----------------------           Pie de Pagina          --------------------------->
<footer>
    <div class="nav-footer">
        <a href="" target="_blank" rel="noopener">Ayuda</a>
        <a href="">Idioma</a>
        <a href="" target="_blank" rel="noopener">Empleo</a>
        <a href="" target="_blank" rel="noopener">Desarroladores</a>
        <a href="" target="_blank" rel="noopener">Contrato Social</a>
        <a href="" target="_blank" rel="noopener">Privacidad</a>
        <a href="" target="_blank" rel="noopener">Comunidad</a>
        <a href="" target="_blank" rel="noopener">Login.com &copy; 2021</a>
    </div>
</footer>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="<js:url value="/JS/MenuPrincipal.js"/>"></script>
</body>
</html>
