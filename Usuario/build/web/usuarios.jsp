<%-- 
    Document   : Usuario
    Created on : 22/09/2016, 02:24:34 PM
    Author     : Maria Magdalena Cabrera Coronilla magdacc05@gmail.com 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <form action="UsuarioController" method="post">
            <fieldset>
                <legend>Formulario de Usuarios</legend>
                <div>
                 <label>Id de usuario:</label>
                <input type="text" name="idUsuario"
                       value="${usuario.idUsuario}"
                       readonly="readonly"
                       placeholder="idUsuario"
                       />
                </div>
                       
                       <div>
                <label>Login:</label>
                <input type="text" name="login"
                       value="${usuario.login}"
                       
                       placeholder="Login"
                       />
                
                       </div>
                       
                       <div>
                 <label>Password:</label>
                <input type="password" name="password"
                       value="${usuario.password}"
                       
                       placeholder="Password"
                       />
                
                       </div>
                       <div>
                 <label>Email:</label>
                <input type="text" name="email"
                       value="${usuario.email}"
                       
                       placeholder="email"
                       />
                
                       </div>
                       
                       <div>
                
                <label>Fecha Alta:</label>
                <input type="text" name="fechaAlta"
                       value="${usuario.fechaAlta}"
                       
                       placeholder="Fecha de usuario"
                       />
                       </div>
                       
                       <div>
                             <div>
                
                <label>Ultimo Acceso:</label>
                <input type="Text" name="ultimoAcceso"
                       value="${usuario.ultimoAcceso}"
                       
                       placeholder="ultimoAcceso"
                       />
                       </div>
                       
                       <div>
                           <input type="submit" value="Guardar" />
                           
                       </div>
            </fieldset>
            
        </form>
    </body>
</html>
