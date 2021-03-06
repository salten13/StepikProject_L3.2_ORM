package main;


import dbService.DBService;
import org.eclipse.jetty.server.Server;
import servlets.AdminServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import accounts.AccountService;
import dbService.DBServiceImpl;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.UserServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {


        DBService dbService = new DBServiceImpl();
        dbService.printConnectInfo();

        AccountService accountService = new AccountService(dbService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new AdminServlet(accountService)), "/admin1");
        context.addServlet(new ServletHolder(new UserServlet(accountService)), "/admin1/users");



//        try {
//            System.out.println("Hello");
//
//
//            if(accountService.getId("tully") == 0L ){
//
//                long userId = accountService.addNewUser("tully", "tully1");
//
//            System.out.println("Added user id: " + userId);
//
//            UsersDataSet dataSet = accountService.getUserById(userId);
//            System.out.println("User data set: " + dataSet);
//
//
////            }
//
//
//        } catch (DBException e) {
//            e.printStackTrace();
//        }




        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();


    }
}
