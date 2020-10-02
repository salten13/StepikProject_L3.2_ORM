package servlets;

import accounts.AccountService;
import dbService.DBException;
import dbService.dataSets.UsersDataSet;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllUsersServlet extends javax.servlet.http.HttpServlet {

    private final AccountService accountService;

    public AllUsersServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
//        response.getWriter().println((PageGenerator.instance().getPage()));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);

        response.getWriter().println(PageGenerator.instance().getPage("allusers.html", pageVariables));

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);


    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        return pageVariables;
    }
}
