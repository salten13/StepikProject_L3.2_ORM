package dbService;


import dbService.dataSets.UsersDataSet;

import java.util.List;

public interface DBService {


    UsersDataSet getUser(long id) throws DBException;

    long addUser(String login, String pass) throws DBException;

    long getUserId(String login) throws DBException;

    void printConnectInfo();

    List<UsersDataSet> getAlldataList() throws DBException;

}
