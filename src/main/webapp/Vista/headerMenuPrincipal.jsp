<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session='true'%>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Menu Principal</title>
  <!--Agregar FONT AWESOME-->
  <script src="https://kit.fontawesome.com/1c80553f6c.js" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>

  <link rel="stylesheet" type="text/css" href="./Estilos/MenuPrincipal.css" media="screen" />
</head>
<body>
  <%
    if(session.getAttribute("nombreUsuario")!=null){
  %>
<script type="text/javascript">
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Datos Correctos',
      showConfirmButton: false,
      timer: 1500
    })
</script>

<!----------------------      Cabezera de la pagina     --------------------------->
<header>
  <div class="Menu">
    <h1>Menu Principal</h1>
    <nav class="menuNavegacion">
      <ul class="drown-Menu">
        <li>
          <i class="fas fa-user-circle"></i>
          <a href="UsuarioController?accion=Perfil" accesskey="n">${nombreUsuario.getNombre()}</a>
        </li>
        <li id="listica"><i class="fas fa-ellipsis-h"></i>
        </li>
      </ul>
    </nav>
  </div>
</header>
<%
  }
  else{
      request.getRequestDispatcher("UsuarioController?accion=Login&error=ta mal").forward(request, response);
  }
%>

