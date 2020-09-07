/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

/**
 *
 * @author DarvisTrillosAriza
 */
@WebServlet(name = "modificaGastos", urlPatterns = {"/modificaGastos"})
public class modificaGastos extends HttpServlet {

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
        Integer var_id_mod;
        Integer var_id_bor;
        var_id_mod = Integer.parseInt(request.getParameter("Editar"));
        var_id_bor = Integer.parseInt(request.getParameter("Borrar"));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (var_id_mod != 0) {
                GestorBD gestorBD = new GestorBD();
                Gasto gasto = gestorBD.consultar(var_id_mod);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Modificar Gastos</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Editar Gasto # " + var_id_mod + "</h1>");
                out.println("<form action='actualizaGasto' method='post'  name='frmmodifica'>");
                out.println("<table cellspacing='3' cellpadding='3' border='1' >");
                out.println("<tr><td align='right'> Fecha: </td><td><input type='date' name='fecha' value='" + gasto.getFecha() + "'  required></td></tr>");
                out.println("<tr><td align='right'> Identificacion: </td><td> <input type='text' name='identi' value='" + gasto.getIdenti() + "' required> </td></tr>");
                out.println("<tr><td align='right'> Nombre: </td><td> <input type='text' name='nombre' value='" + gasto.getNombre() + "' required> </td></tr>");
                out.println("<tr><td align='right'> Observacion: </td><td> <input type='text' name='obs' value='" + gasto.getObs() + "' required> </td></tr>");
                out.println("<tr><td align='right'> Valor: </td><td> <input type='text' name='valor' value=" + gasto.getValor() + " required> </td></tr>");
                out.println("</table>");
                out.println("<button type='submit' name='Update' value="+var_id_mod+" >Actualizar</button>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
               
            }
            if (var_id_bor != 0) {
                GestorBD gestorBD = new GestorBD();
                boolean gasto = gestorBD.borrar(var_id_bor);
                if (gasto) {
                    request.getRequestDispatcher("muestraGastos").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noEncontrado.jsp").forward(request, response);
                }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
