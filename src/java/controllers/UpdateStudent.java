/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entities.Student;
import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StudentService;

/**
 *
 * @author George.Pasparakis
 */
public class UpdateStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudent at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
     RequestDispatcher rd = request.getRequestDispatcher("updatestudent.jsp");
        request.setAttribute("Update", "UpdateStudent");
       
        Integer sid=Integer.parseInt(request.getParameter("update"));
        StudentDAO stuDao=new StudentDAO();
        Student st= stuDao.getStudentById(sid);
        request.setAttribute("name",st.getName());
        request.setAttribute("surname",st.getSurname());
        request.setAttribute("grade",st.getGrade());
        request.setAttribute("birthdate",st.getBirthDate());
        request.setAttribute("id",st.getId());
                
         rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
     Student st;
        StudentService ss = new StudentService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudent at " + request.getContextPath() + "</h1>");
            st = new Student(Integer.parseInt(request.getParameter("id")),request.getParameter("surname"),
                    request.getParameter("name"),
                    Float.parseFloat(request.getParameter("grade")),
                            request.getParameter("birthdate"));
               out.print(request.getParameter("birthdate"));
            if (ss.UpdateStudent(st)) 
                out.print("<h2> All inserted!</h2>");
            else 
                out.print("<h2> Nothing inserted!</h2>");
                // out.println(request.getParameter("name") + "" + request.getParameter("surname"));
                out.println("</body>");
                out.println("</html>");
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
