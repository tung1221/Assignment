/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package HomeController;

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
public class HomeControl extends HttpServlet {
   
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
        String cateid=request.getParameter("cateid");
        String search=request.getParameter("txt");
        String sql;
        if( cateid != null && search==null){
            sql = "select * from Product where cateId ="+cateid;
        }else if (cateid != null && search!=null ) {
             sql = "select * from Product where cateId ="+cateid+"and pid like '%"+search+"%' or pname like '%"+search+"%' or quantity like '%"+search+"%' or price like '%"+search+"%' or description like '%"+search+"%'";
        }else if(cateid ==null&& search!=null){
            sql="select * from Product where  pid like '%"+search+"%' or pname like '%"+search+"%' or quantity like '%"+search+"%' or price like '%"+search+"%' or description like '%"+search+"%'";
        }
        else{
            sql="select * from Product";
        }
        ProductDAO prodDao = new ProductDAO();
        Vector<Product> listP =prodDao.getAllProduct1(sql);
        Product prod=prodDao.getBestSeller();
        CategoryDAO cateDao= new CategoryDAO();
        Vector<Category> listCC =cateDao.getAllCategory("select * from Category");
        
        request.setAttribute("listP", listP);
        request.setAttribute("listCC", listCC);
        request.setAttribute("p", prod);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
