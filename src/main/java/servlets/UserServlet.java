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
import java.util.List;
import java.util.Map;

public class UserServlet extends javax.servlet.http.HttpServlet {

    private final AccountService accountService;

    public UserServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            // get all user data sets from db and put in freemarker template for dynamic using
            List<UsersDataSet> list = accountService.getAlldataListFromDB();
            Map<String, Object> pageVariables = createPageVariablesMap(list);

            response.setContentType("text/html;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(PageGenerator.instance().getPage("users.html", pageVariables));

        }catch (DBException dbe){
            dbe.printStackTrace();
        }





    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String, Object> pageVariables = createPageVariablesMap(request);
//
//        response.getWriter().println(PageGenerator.instance().getPage("users.html", pageVariables));
//
//        response.setContentType("text/html;charset=UTF-8");
//        response.setStatus(HttpServletResponse.SC_OK);
//
//
//    }

    private static Map<String, Object> createPageVariablesMap(List<UsersDataSet> list) {

        Map<String, Object> pageVariables = new HashMap<>();

        pageVariables.put("users", list);

        return pageVariables;
    }
}
