<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="headerMenuPrincipal.jsp" %>
<body>
<!----------------------          Menu Principal          --------------------------->
<main>
    <!--Input de Busqueda-->
    <form action="UsuarioController" method="get" id="formBusqueda">
        <input type="search" class="inputcito" name="criterio">
        <input type="submit" id="botoncito" name="accion" value="Buscar">
    </form>

    <!--Tabla de Usuario-->
    <table>
        <thead>
            <tr>
                <th>Foto</th>
                <th>Nombre</th>
                <th>P1ublicaciones</th>
                <th>Seguidos</th>
                <th>Seguidores</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="usu" items="${usuarios}">
            <tr>
                <td><img src="ControllerIMG?id=${usu.getIdUsuario()}" style="border-radius: 50%" width="50px" height="50px" alt="Foto de Perfil" title="Foto de perfil"></td>
                <td>${usu.getNombre()}</td>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%@include file="Footer.jsp" %>