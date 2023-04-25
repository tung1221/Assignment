/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package cartController;

import DAO.ProductDAO;
import Entity.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HLC
 */
public class addToCart extends HttpServlet {
   
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
         String pid= request.getParameter("pid"); 
         String mode=request.getParameter("mode");
         
         if(mode==null){
             mode="increase";
         }
         int quantity=1;    
         HttpSession session = request.getSession();
         HashMap<Product,Integer> list =(HashMap<Product,Integer>) session.getAttribute("cart");
         if(list == null){
             list = new HashMap<>();
         }
         ProductDAO dao= new ProductDAO();
         Product prod= dao.getProductById(pid);
         if(mode=="remove"){
             list.remove(prod);
         }else if(mode=="increase"){
             if(list.containsKey(prod)){
                 int quantity1= list.get(prod);
                 list.put(prod, quantity1+1);
             }else{
                 list.put(prod, quantity);
             }
         }else if(mode=="decrease"){
             if(list.containsKey(prod)){
                 int quantity1= list.get(prod);
                 if(quantity1 > 1){
                     list.put(prod, quantity1-1);
                 }else
                     list.remove(prod);
             }
         }
         session.setAttribute("cart",list);
         response.sendRedirect("CartDetail");
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
