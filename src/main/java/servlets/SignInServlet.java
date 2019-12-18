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

public class SignInServlet extends javax.servlet.http.HttpServlet {

    private final AccountService accountService;

    public SignInServlet(AccountService accountService){

        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        // I NEED ADD getBYNAME METHOD TO GET accountName and accountPass from datebase
        // and then compare them with request params and if true then authorized else unauthorized

        try{
            long id = accountService.getId(login);
            UsersDataSet usersDataSet = accountService.getUserById(id);

//            response.getWriter().println(id);

            if(id == 0 || usersDataSet == null ) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Unauthorized");
                return;
            }
            if(login.equals(usersDataSet.getLogin()) && password.equals(usersDataSet.getPassword())){

                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("Authorized: " + login);
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Unauthorized");
            }

        }catch (DBException e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);

        response.getWriter().println(PageGenerator.instance().getPage("signin.html", pageVariables));

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        return pageVariables;
    }

}
