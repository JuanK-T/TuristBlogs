<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="Estilos/index.css">
    <meta name="description" content="Este sera el formulario de login y de registro de la pagina">
</head>
<body>

<!-------------------------------    Cabecera de la Pagina    --------------------------------->
<header>
    <div class="navegacion">
        <h1>Logo</h1>
        <nav role="navigation">
            <ul class="menuItems">
                <li><a href="#"> Info </a></li>
                <li><a href="#">Empresa</a></li>
                <li><a href="#">Blog</a></li>
            </ul>
        </nav>
    </div>
</header>

<!-------------------------------       Cuerpo la Pagina       --------------------------------->
<main>

    <div class="contenedor">
        <h3>¡Bienvenido!</h3>
        <div class="fieldset">
            <!--Titulo del tipo de Formulario-->
            <div class="tituloFormulario">
                <legend class="active" id="IniciarSesion" onclick="cambiarLogin();">Inicia Sesión</legend>
                <legend class="inactive underlineHover" id="Register" onclick="cambiarRegistrar();">Crea tu Cuenta</legend>
            </div>

            <!--FORMULARIO DE REGISTRO-->
            <form action="UsuarioController" method="post" enctype="multipart/form-data" class="Registro inactivo" name="formRegistro" id="formRegistro" role="form">
                <input type="hidden" name="idUsuario" id="idUsuario">
                <input type="hidden" name="fechaCreation" id="fechaCreacion">
                <input type="file" id="file-input" accept=".png, .gif, .jpeg, .jpg" name="fotoUsuario" style="display: none">
                <!--Grupo de Nombre-->
                <div class="form-grupo" id="grupo-Nombre">
                    <label for="nombre">Nombre</label><br>
                    <input type="text" name="nombre" id="nombre" placeholder="Jose Armando Gonzales">
                    <p class="error">El nombre debe tener al menos 5 dígitos de tipo texto</p>
                </div>

                <!--Grupo de Correo-->
                <div class="form-grupo" id="grupo-Correo">
                    <label for="correo">Correo Electrónico</label><br>
                    <input type="email" name="correo" id="correo" placeholder="ejemplo@mail.com">
                    <p class="error">El correo electrónico debe tener un @ y una longitud de 12 a 30 dígitos</p>
                </div>

                <!--Grupo de Telefono-->
                <div class="form-grupo" id="grupo-Telefono">
                    <label for="telefono">Telefono</label><br>
                    <input type="number" name="telefono" id="telefono" placeholder="310 2517904">
                    <p class="error">El teléfono solo contiene números y tener un valor máximo de 14 dígitos</p>
                </div>

                <!--Grupo de Usuario-->
                <div class="form-grupo" id="grupo-usuario">
                    <label for="usuario">Usuario</label><br>
                    <input type="text" name="usuario" id="usuario" placeholder="JArmando123">
                    <p class="error">El nombre de usuario debe tener letras, numero, guion bajo y una longitud mínima de 5 dígitos</p>
                </div>

                <!--Grupo de Contraseña-->
                <div class="form-grupo" id="grupo-Contrasena">
                    <label for="contrasena">Contraseña</label><br>
                    <input type="password" name="contrasena" id="contrasena" placeholder="********">
                    <p class="error">El contraseña debe tener una longitud mínima de 5 dígitos</p>
                </div>

                <!--Repetir Contraseña-->
                <div class="form-grupo" id="grupo-Contrasena2">
                    <label for="contrasenaR">Repetir Contraseña</label><br>
                    <input type="password" name="contrasenaR" id="contrasenaR" placeholder="********">
                    <p class="error">Debe ser igual a la contraseña ingresada anterior mente</p>
                </div>


                <!--Grupo de Términos-->
                <div class="form-grupo" id="grupo-Terminos">
                    <p>
                        Al registrarse automáticamente aceptaras todos los<a href="#">Términos y Condiciones</a>
                        , la <a href="">Política de datos </a> y la <a href="">Política de Cookies</a> de este Sitio web
                    </p>
                </div>

                <!--Mensaje de Error-->
                <div class="mensaje-Error" id="mensaje-Error">
                    <p><b>Error:</b> los datos no están completos por favor rellenar correctamente</p>
                </div>

                <div class="form-grupo btn-registrar">
                    <button type="submit" name="accion" class="formulario-btn" value="registrar" id="registrar">Registrar</button>
                    <p class="mensaje-Exitoso" id="mensaje-Exitoso">Genial Ahora puedes iniciar Sesion</p>
                </div>
            </form>

            <!-------------FORMUALRIO DE INICIO DE SESION---------------------->
            <form action="UsuarioController" method="post" class="Login" name="formLogin" id="formLogin" role="form">
                <input type="text" tabindex="1" name="nombreUsuario" id="nombreUsuario" class="fadeIn second" placeholder="Nombre de Usuario" required>
                <input type="password" tabindex="2" name="contrasenaUsuario" id="clave" class="fadeIn third" placeholder="Contraseña" required>
                <button type="submit" name="accion" value="Ingresar" id="login" onclick="return validarInicioSesion()">ingresar</button>
            </form>
        </div>
        <div id="footerForm" class="footerForm">
            <span>¿Ya tienes Cuenta? <a href="#"> Inicia Sesion</a></span>
        </div>
    </div>
</main>
<!-------------------------------      Footer de la Pagina      --------------------------------->
<footer>
    <div class="nav-footer">
        <a href="#" target="_blank" rel="noopener">Ayuda</a>
        <a href="#" target="_blank" rel="noopener">Idioma</a>
        <a href="#" target="_blank" rel="noopener">Empleo</a>
        <a href="#" target="_blank" rel="noopener">Desarrolladores</a>
        <a href="#" target="_blank" rel="noopener">Contrato de Usuario</a>
        <a href="#" target="_blank" rel="noopener">Privacidad</a>
        <a href="#" target="_blank" rel="noopener">Comunidad</a>
        <a href="#" target="_blank" rel="noopener">web.com &copy; 2021</a>
    </div>
</footer>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script type="text/javascript" src="JS/index.js" ></script>
</body>
</html>