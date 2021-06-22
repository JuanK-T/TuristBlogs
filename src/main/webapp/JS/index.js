
//VALIDACION DE FORMULARIO
const formRegistro = document.getElementById('formRegistro');
const formLogin = document.getElementById('formLogin');
const inputs = document.querySelectorAll('#formRegistro input');

const expresiones = {
    usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{4,12}$/, // 4 a 12 digitos.
    correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	telefono: /^\d{7,14}$/ // 7 a 14 numeros.
}

const campos = {
	usuario: false,
	Nombre: false,
	Contrasena: false,
	Correo: false,
	Telefono: false
}


const validarFormulario = (e) =>{
    switch (e.target.name){
        case "usuario":
            validarCampo(expresiones.usuario, e.target, 'usuario');
        break;
        case "nombre":
            validarCampo(expresiones.nombre, e.target, 'Nombre');
        break;
        case "correo":
            validarCampo(expresiones.correo, e.target, 'Correo');
        break;
        case "telefono":
            validarCampo(expresiones.telefono, e.target, 'Telefono');
        break;
        case "contrasena":
            validarCampo(expresiones.password, e.target, 'Contrasena');
            validarPassword2();
        break;
        case "contrasenaR":
            validarPassword2();
        break;
    }
}


const validarCampo = (expresion, input, campo) => {

    if(expresion.test(input.value)){
        document.getElementById(`grupo-${campo}`).classList.remove('form-grupo_Incorrecto');
        document.getElementById(`grupo-${campo}`).classList.add('form-grupo');
        document.querySelector(`#grupo-${campo} .error`).classList.remove('error-activo');
        campos[campo] = true;
    }else {
        document.getElementById(`grupo-${campo}`).classList.add('form-grupo_Incorrecto');
        document.getElementById(`grupo-${campo}`).classList.remove('form-grupo');
        document.querySelector(`#grupo-${campo} .error`).classList.add('error-activo');
        campos[campo] = false;
    }
}


const validarPassword2 = () =>{
    const inputPassword1 = document.getElementById('contrasena');
    const inputPassword2 = document.getElementById('contrasenaR');

    if(inputPassword1.value !== inputPassword2.value){
        document.getElementById(`grupo-Contrasena2`).classList.add('form-grupo_Incorrecto');
        document.getElementById(`grupo-Contrasena2`).classList.remove('form-grupo');
        document.querySelector(`#grupo-Contrasena2 .error`).classList.add('error-activo');
        campos['Contrasena'] = false;
    }else{
        document.getElementById(`grupo-Contrasena2`).classList.remove('form-grupo_Incorrecto');
        document.getElementById(`grupo-Contrasena2`).classList.add('form-grupo');
        document.querySelector(`#grupo-Contrasena2 .error`).classList.remove('error-activo');
        campos['Contrasena'] = true;
    }
}

inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});

document.getElementById('registrar').addEventListener('click', (e) =>{
    if(campos.usuario && campos.Contrasena && campos.Correo && campos.Nombre && campos.Telefono ){
        formRegistro.reset();

        document.getElementById('mensaje-Exitoso').classList.add('mensaje-Exitoso_Activo');
        document.getElementById('mensaje-Error').classList.remove('mensaje-Error_Activo');
        setTimeout(() => {
            document.getElementById('mensaje-Exitoso').classList.remove('mensaje-Exitoso_Activo');
        }, 4000);
    } else {
        e.preventDefault();
        document.getElementById('mensaje-Error').classList.add('mensaje-Error_Activo');
    }

});

function validarInicioSesion(){
    var usuario = document.getElementById('nombreUsuario');
        var	clave = document.getElementById('clave');

        if(usuario.value === null || usuario.value === ''){
    		Swal.fire('Por favor ingrese el Usuario');
    	}else{

    		if(clave.value === null || clave.value === ''){
    			Swal.fire('Por favor ingrese la clave');
    		}else {
    			return true;
    		}
    	}
    	formLogin.reset();
    	return false;
}


//CAMBIO DE FORMUALARIO

function cambiarLogin(){

    document.getElementById('IniciarSesion').classList.add("active");
    document.getElementById('IniciarSesion').classList.remove("underlineHover");
    document.getElementById('IniciarSesion').classList.remove("inactivo");

    document.getElementById('Register').classList.remove("active");
    document.getElementById('Register').classList.add("underlineHover");
    document.getElementById('Register').classList.add("inactive");

    document.getElementById('formRegistro').classList.add("inactivo");
    document.getElementById('formLogin').classList.remove("inactivo");
}

function cambiarRegistrar(){

    document.getElementById('IniciarSesion').classList.remove("active");
    document.getElementById('IniciarSesion').classList.add("underlineHover");
    document.getElementById('IniciarSesion').classList.add("inactive");

    document.getElementById('Register').classList.add("active");
    document.getElementById('Register').classList.remove("underlineHover");
    document.getElementById('Register').classList.remove("inactive");

    document.getElementById('formRegistro').classList.remove("inactivo");
    document.getElementById('formLogin').classList.add("inactivo");

}


