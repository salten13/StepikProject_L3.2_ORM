package servlets;

import accounts.AccountService;
import dbService.DBException;
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

//        if( ( login == null || login.isEmpty() ) || (password == null || password.isEmpty() ) ){

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        } else {
//            try{
//                accountService.addNewUser(login, password);

//            }catch (DBException e){
//                e.printStackTrace();
//            }

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("This is a response");
//        }
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
