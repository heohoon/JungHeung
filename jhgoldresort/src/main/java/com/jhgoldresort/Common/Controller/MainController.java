package com.jhgoldresort.Common.Controller;

import com.jhgoldresort.Member.DAO.MemberDAO;
import com.jhgoldresort.Member.DTO.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("*.jh")
public class MainController extends HttpServlet {
    String view = null;
    MemberDAO mdao = null;

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

        switch(command){
            case "/login.jh" :
                mdao = MemberDAO.getInstance();
                MemberDTO mdto = mdao.selectMember(request.getParameter("userId"), request.getParameter("userPassword"));
                if (mdto.getId() != null) {
                    request.setAttribute("mdto", mdto);
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", mdto.getName());
                    view = "main.jh";
                    response.sendRedirect(view);
                } else {
                    view = "/";
                    response.sendRedirect(view);
                } break;

            case "/main.jh" :
                view = "/main.jsp";
                System.out.println(view);
                request.getRequestDispatcher(view).forward(request, response);
                break;

            case "/signup.jh" :
                view = "/signUp.jsp";
                System.out.println(view);
                request.getRequestDispatcher(view).forward(request, response);
                break;

            case "/join.jh" :
                int result = 0;
                mdao = MemberDAO.getInstance();
                result = mdao.insertMember(request.getParameter("userId"),request.getParameter("userPassword"),request.getParameter("userName"));
                if(result == 1) {
                    view = "/";
                    System.out.println(view);
                    response.sendRedirect(view);
                    break;
                }
                view ="/signUp.jh";
                response.sendRedirect(view);
                break;

            case "/memberList.jh" :
                mdao = MemberDAO.getInstance();
                ArrayList<MemberDTO> mList = mdao.selectMemberAll();
                view = "/memberList.jsp";
                request.setAttribute("mList",mList);
                request.getRequestDispatcher(view).forward(request,response);
                break;
        }
    }
}
