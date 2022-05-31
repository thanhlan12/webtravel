/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.GalleryDAO;
import dao.LocalDAO;
import dao.PplaceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Local;
import model.Pplace;
import model.Local;

/**
 *
 * @author BK COMPUTER
 */
@WebServlet(name = "searchController", urlPatterns = {"/search"})
public class searchController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LocalDAO localDAO;
    private PplaceDAO pplaceDAO;
    private GalleryDAO galleryDAO;

    @Override
    public void init() {
        localDAO = new LocalDAO();
        pplaceDAO = new PplaceDAO();
        galleryDAO = new GalleryDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String txtSearch = request.getParameter("txt");
        List<Local> list = localDAO.selectAllLocalBytxt(txtSearch);
        request.setAttribute("listUser", list);
        if (list.size() == 0) {
            RequestDispatcher dispatche = request.getRequestDispatcher("error.jsp");
            dispatche.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("local-list.jsp");
            dispatcher.forward(request, response);
        }
        request.getRequestDispatcher(txtSearch);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
