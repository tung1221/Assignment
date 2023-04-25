/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package ProductController;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Entity.Category;
import Entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author HLC
 */
public class listProduct extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ProductDAO dao= new ProductDAO();
        String search= request.getParameter("search");
        String sql;
        if (request.getParameter("search")!=null) {
            
            sql = "select p.pid,p.pname,p.quantity,p.price,p.image,p.description,p.status,\n"
                    + "p.cateId,c.cateName\n"
                    + "from Product p join Category c\n"
                    + "on p.cateId=c.cateId \n"
                    + "where p.pid like '%"+search+"%' or p.pname like '%"+search+"%' or p.quantity like '%"+search+"%' or p.price like '%"+search+"%' or p.description like '%"+search+"%' or c.cateName like '%"+search+"%'";
        } else
            sql ="select p.pid,p.pname,p.quantity,p.price,p.image,p.description,p.status,\n"
                + "p.cateId,c.cateName\n"
                + "from Product p join Category c\n"
                + "on p.cateId=c.cateId";
        Vector<Product> vec = dao.getAllProduct(sql);
        request.setAttribute("vec", vec);
        CategoryDAO cateDAO= new CategoryDAO();
        Vector<Category> listCate=cateDAO.getAllCategory("select * from Category");
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
