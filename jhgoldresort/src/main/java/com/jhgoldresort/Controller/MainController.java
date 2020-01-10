package com.jhgoldresort.Controller;

import com.jhgoldresort.DAO.MemberDAO;
import com.jhgoldresort.DTO.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("*.JH")
public class MainController extends HttpServlet {
    String view = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            actionDo(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            actionDo(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String uri = request.getRequestURI();
        System.out.println("uri : " + uri);
        String conPath = request.getContextPath();
        System.out.println("conPath : " + conPath);
        String command = uri.substring(conPath.length());
        System.out.println("command : " + command);
        System.out.println(request.getParameter("userId"));
        System.out.println(request.getParameter("userPassword"));

        if(command.equals("/login.JH")){
            MemberDAO mdao = MemberDAO.getInstance();
            MemberDTO mdto = mdao.selectMember(request.getParameter("userId"));
            request.setAttribute("mdto",mdto);
            view ="main.JH";
            request.getRequestDispatcher("/main.JH").forward(request,response);

        }
        if(command.equals("/main.JH")){
            view ="/main.jsp";
        }
        System.out.println(view);
        request.getRequestDispatcher(view).forward(request,response);
    }
}
