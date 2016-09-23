/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.UsuarioDao;
import Dao.UsuarioDaoIm;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Maria Magdalena Cabrera Coronilla magdacc05@gmail.com
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String LISTA_usuarios = 
            "/listarUsuarios.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "/usuarios.jsp";
    private UsuarioDao dao;
    
    public UsuarioController(){
        dao = new UsuarioDaoIm();
    }
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("eliminar")){
            forward = LISTA_usuarios;
            int idUsuario = Integer.parseInt(
                    request.getParameter("idUsuario"));
            dao.eliminarUsuario(idUsuario);
            request.setAttribute("usuarios", dao.desplegarUsuario());
        }else if(action.equalsIgnoreCase("modificar")){
            forward= AGREGAR_O_CAMBIAR;
            int idUsuario = Integer.parseInt(
                    request.getParameter("idUsuario"));
            Usuario usuario=  dao.elegirUsuario(idUsuario);
            request.setAttribute("usuario", usuario);
            
            
            
        }else if(action.equalsIgnoreCase("insertar")){
            forward= AGREGAR_O_CAMBIAR;
        }else{
            forward=LISTA_usuarios;
            request.setAttribute("usuarios", dao.desplegarUsuario());
        }
        RequestDispatcher view =
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
      String idUsuario = (request.getParameter("idUsuario"));
      usuario.setLogin(request.getParameter("login"));
      usuario.setPassword(request.getParameter("password"));
      usuario.setEmail(request.getParameter("email"));
      usuario.setFechaAlta(request.getParameter("fechaAlta"));
      usuario.setUltimoAcceso(request.getParameter("ultimoAcceso"));
      
      
      if(idUsuario==null || idUsuario.isEmpty()){
          dao.insertarUsuario(usuario);
          
      }else{
          usuario.setIdUsuario(Integer.parseInt(idUsuario));
          dao.modificarUsuario(usuario);
      }
      RequestDispatcher view = request.getRequestDispatcher(LISTA_usuarios);
      request.setAttribute("usuarios", dao.desplegarUsuario());
      view.forward(request, response);
    }


   
    }

