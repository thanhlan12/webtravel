package controller;

import dao.ContactDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * LoginController Servlet xử lý đăng nhập và điều hướng
 *
 * @author ngockhuong.com
 *
 */
@WebServlet(name = "insertController", urlPatterns = {"/insertController"})
public class insertController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;

    @Override
    public void init() {
        contactDAO = new ContactDAO();
    }

    public insertController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        Contact newContact = new Contact(name, email, phone, message);
        contactDAO.insertContact(newContact);
        RequestDispatcher dispatcher = request.getRequestDispatcher("thank.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(insertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(insertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
