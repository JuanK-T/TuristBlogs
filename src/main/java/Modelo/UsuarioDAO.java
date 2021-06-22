package Modelo;

import Config.Conexion;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection connection;

    //Sentencia preparada
    PreparedStatement ps;
    //Guardar resultados
    ResultSet rs;

    //Creamos un nuevo objeto de la clase conexion la cual llamamos conector
    Conexion conector = new Conexion();

    //Objeto de la clase usuario
    Usuario usuario = new Usuario();

    //Variable de tipo numerico
    int r;

    //REGISTRAR USUARIO
    public int Registrar(Usuario usuario){

        String insertar = "INSERT INTO usuario VALUES(NULL, ?, ?, ?, ?, ?, CURRENT_DATE, ?);";

        try{
            connection = conector.getConexion();//Abrir la Conexion
            ps = connection.prepareStatement(insertar);
            ps.setString(1, usuario.getNombre());
            ps.setLong(2, usuario.getTelefono());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getUser());
            ps.setString(5, usuario.getContrasena());
            ps.setBlob(6, usuario.getFotoUsuario());

            ps.executeUpdate();//Ejecutamos la sentencia

            ps.close();//Cerrar Sentencia
            connection.close();//Cerrar la conexion

        }catch (SQLException e) {
            System.out.println("Error en el Registro " + e.getMessage());
        }

        return r;
    }

    //Creamos un metodo de tipo Usuario que nos servira para validar los datos
    //que nos llegen de la vista
    public Usuario validarUsuario(String nombreUsuario, String contrasenaUsuario){

        //Crear un variable de tipo String llamada consulta
        String consulta = "SELECT * FROM usuario WHERE correo = ? and contrasena = ? ";

        try{

            connection = conector.getConexion();//Abrir la conexion
            ps = connection.prepareStatement(consulta);//Prepara la sentencia
            ps.setString(1, nombreUsuario);//establecemos el primer valor de la consulta
            ps.setString(2, contrasenaUsuario);//
            rs = ps.executeQuery();//ejecutar la sentencia

            while (rs.next()){

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTelefono(rs.getLong("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setUser(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setFechaCreacion(rs.getString("fechaCreacion"));
                usuario.setFotoUsuario(rs.getBinaryStream("fotoUsuario"));
            }
            ps.close();
            connection.close();
        }catch(Exception e) {
            System.out.println("Usuario no encontrado" + e.getMessage());
        }

        return usuario;
    }

    public List Listar(){
        String consulta = "SELECT * FROM usuario";
        connection = conector.getConexion();
        List<Usuario> usuarios = new ArrayList();

        try{
            ps = connection.prepareStatement(consulta);
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTelefono(rs.getLong("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setUser(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setFechaCreacion(rs.getString("fechaCreacion"));
                usuario.setFotoUsuario(rs.getBinaryStream("fotoUsuario"));

                usuarios.add(usuario);
            }
            ps.close(); //cerrar sentencia
            connection.close(); //devolver conexión al pool

        }catch(Exception e){
            System.out.println("No arrojó datos la consulta " + e.getMessage());
        }
        return usuarios;
    }

    public Usuario ConsultarId(int idUsuario){
        String consulta = "SELECT * FROM usuario WHERE idUsuario =" + idUsuario;
        connection = conector.getConexion();//Abrir la conexion
        Usuario usuario = new Usuario();

        try{
            ps = connection.prepareStatement(consulta);//preparar la sentencia
            rs = ps.executeQuery();

            while(rs.next()){
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setTelefono(rs.getLong(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setUser(rs.getString(5));
                usuario.setContrasena(rs.getString(6));
                usuario.setFechaCreacion(rs.getString(7));
                usuario.setFotoUsuario(rs.getBinaryStream(8));
            }
            ps.close();//Cerrar el stament
            connection.close();//devolver conexion

        }catch (Exception e){
            System.out.println("Error en la Busqueda " + e.getMessage());
        }

        return usuario;
    }

    public int Actualizar(Usuario usu){
        String actualizar = "UPDATE usuario SET nombre=?, telefono=?, correo=?, usuario=?, contrasena=?, fotoUsuario=? WHERE idUsuario=?";
        connection = conector.getConexion();

        try{
            ps = connection.prepareStatement(actualizar);
            ps.setString(1, usu.getNombre());
            ps.setLong(2, usu.getTelefono());
            ps.setString(3, usu.getCorreo());
            ps.setString(4, usu.getUser());
            ps.setString(5, usu.getContrasena());
            ps.setBlob(6, usu.getFotoUsuario());
            ps.setInt(7, usu.getIdUsuario());

            ps.executeUpdate();
            ps.close();
            connection.close();
        }catch(Exception e) {
            System.out.println("Error en la actualización"+e.getMessage());
        }
        return r;
    }

    public void listarImg(int id, HttpServletResponse response){
        String sql = "SELECT * FROM usuario WHERE idUsuario=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");

        try {
            outputStream = response.getOutputStream();
            connection = conector.getConexion();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                inputStream = rs.getBinaryStream("fotoUsuario");
            }

            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int i = 0;

            while((i=bufferedInputStream.read()) !=-1){
                bufferedOutputStream.write(i);
            }

        }catch (Exception e){
            System.out.println("Error imagen " + e.getMessage());
        }
    }

    public List Buscar(String criterio){
        String consulta = "SELECT * FROM usuario WHERE nombre LIKE '%" + criterio + "%'";
        System.out.println(consulta);

        connection = conector.getConexion();
        List<Usuario> usuarios = new ArrayList();

        try{
            ps = connection.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTelefono(rs.getLong("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setFechaCreacion(rs.getString("fechaCreacion"));
                usuario.setFotoUsuario(rs.getBinaryStream("fotoUsuario"));
                usuarios.add(usuario);
            }
        }catch(Exception e) {
            System.out.println("Error en la búsqueda " + e.getMessage());
        }
        return usuarios;
    }

    public void Eliminar(int id){
        String sql = "DELETE FROM usuario WHERE idUsuario=" + id;
        connection = conector.getConexion();

        try{
            ps = connection.prepareStatement(sql);
            ps.executeUpdate(sql);
            ps.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error al eliminar la cuenta " + e.getMessage());
        }
    }
}


