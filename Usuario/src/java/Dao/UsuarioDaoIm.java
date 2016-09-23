/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;




import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Util;

/**
 *
 * @author Maria Magdalena Cabrera Coronilla magdacc05@gmail.com
 */
public class UsuarioDaoIm implements UsuarioDao {
    private Connection connection;
    
    public UsuarioDaoIm(){
        connection = Util.getConnection();
    
}

    @Override
    public void insertarUsuario(Usuario usuario) {
try{
            String query = "INSERT INTO usuarios(login,password, email, fecha_alta, ultimo_acceso)"
                    +" VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,usuario.getLogin());
            ps.setString(2,usuario.getPassword());
            ps.setString(3,usuario.getEmail());
            ps.setString(4, usuario.getFechaAlta());
            ps.setString(5,usuario.getUltimoAcceso());
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        } 
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
try{
            String query = "DELETE FROM usuarios WHERE id_usuario=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
try{
            String query = "UPDATE usuarios SET login =? "
                    + ", password =?"
                    + ", email =?"
                    +", fecha_alta =?"
                    +", ultimo_acceso"
                    +" WHERE   id_usuario=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,usuario.getLogin());
            ps.setString(2,usuario.getPassword());
            ps.setString(3,usuario.getEmail());
            ps.setString(4, usuario.getFechaAlta());
            ps.setString(5,usuario.getUltimoAcceso());
            ps.setInt(6, usuario.getIdUsuario());
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> desplegarUsuario() {
     List<Usuario> usuarios = new ArrayList<Usuario>();
        try{
        Statement statement = connection.createStatement();
         ResultSet rs= statement.executeQuery("SELECT * FROM usuarios");
         while(rs.next()){
             Usuario usuario = new Usuario(
                     rs.getInt("id_usuario"),
                     rs.getString("login"),
                     rs.getString("password"),
                     rs.getString("email"),
                     rs.getString("fecha_alta"),
                     rs.getString("ultimo_acceso"));
             
             usuarios.add(usuario);
             
         
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return usuarios;
    }
    

    @Override
    public Usuario elegirUsuario(int idUsuario) {
   Usuario usuario = null;
        
        try{
            String query = "SELECT * FROM usuarios WHERE id_usuario= ?";
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setInt(1, idUsuario);
             ResultSet rs= statement.executeQuery();
         if(rs.next()){
             
               usuario = new Usuario(
                rs.getInt("id_usuario"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fecha_alta"),
                        rs.getString("ultimo_acceso"));
         }
         rs.close();
         statement.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
return usuario;
    }
    
    }
    
   
