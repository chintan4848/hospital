/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminservlet;


import entity.user;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chintan
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try{
            String email=req.getParameter("email");
            String password=req.getParameter("pwd");
            
            HttpSession session=req.getSession();
            
            
            if("admin@gmail.com".equals(email) && "admin".equals(password))
            {
                session.setAttribute("adminobj",new user());
                resp.sendRedirect("admin/index.jsp");
            }
            else{
                session.setAttribute("errorMsg","invalid email or password!");
                resp.sendRedirect("admin_login.jsp");
            }
            
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
    
    
    
}
