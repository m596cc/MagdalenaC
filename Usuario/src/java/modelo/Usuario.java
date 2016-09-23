/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Maria Magdalena Cabrera Coronilla magdacc05@gmail.com
 */
public class Usuario {
   private int idUsuario;
    private String login;
    private String password;
    private String email;
    private String fechaAlta;
    private String ultimoAcceso;

    public Usuario(int idUsuario, String login, String password, String email, String fechaAlta, String ultimoAcceso) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.ultimoAcceso = ultimoAcceso;
    }
    
    public Usuario(){
        this(0,"", "", "", "", "");
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(String ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
    
    
}
