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
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author HLC
 */
public class editProduct extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editProduct</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editProduct at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       //processRequest(request, response);
       String pid=request.getParameter("id").trim();
       ProductDAO prodDao = new ProductDAO();
       Product prod=prodDao.getProductById(pid);
       
        CategoryDAO cateDao = new CategoryDAO();
        Vector<Category> listCate=cateDao.getAllCategory("select* from Category");
       request.setAttribute("p", prod);
       request.setAttribute("listCate", listCate);
       request.getRequestDispatcher("editProduct.jsp").forward(request, response);
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
        //processRequest(request, response);
        String id=request.getParameter("id").trim();
        String name=request.getParameter("name").trim();
        int quantity=Integer.parseInt(request.getParameter("quantity").trim());
        Double price=Double.parseDouble(request.getParameter("price").trim());
        String image=request.getParameter("image").trim();
        String description= request.getParameter("description").trim();
        int status=Integer.parseInt(request.getParameter("status").trim());
        int cateId=Integer.parseInt(request.getParameter("category").trim());
        
        ProductDAO prodDao = new ProductDAO();
        Product prod = new Product(id, name, quantity, price, image, description, status, cateId);
        prodDao.updateProduct(prod);
        response.sendRedirect("lists");
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
