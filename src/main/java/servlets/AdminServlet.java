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

public class AdminServlet extends javax.servlet.http.HttpServlet {

    private final AccountService accountService;

    public AdminServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        StringBuilder sb = new StringBuilder();

        // Getting all sets from DB
        try {
            List<UsersDataSet> list =  accountService.getAlldataListFromDB();

        for(UsersDataSet u : list){
            sb.append("<p>");
            sb.append(u.getId() + "   " + u.getLogin() + "   " + u.getPassword());
            sb.append("</p>");
        }
        } catch (DBException e) {
            e.printStackTrace();
        }

        response.getWriter().println(sb.toString());  // Возвращять таблицу с базы всех пользователей со всеми полями
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);

        response.getWriter().println(PageGenerator.instance().getPage("admin1.html", pageVariables));

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);


    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        return pageVariables;
    }
}
