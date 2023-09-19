/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import murach.business.User;


/**
 *
 * @author DELL
 */
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/index.html";
        
        String action = request.getParameter("action");
        if(action == null){
            action ="join";
        }
        
        if(action.equals("join")){
            url ="/index.html";
        }
        else if (action.equals("add")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            
            User user = new User(firstName, lastName, email);
            //UserDB.insert(user);
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
