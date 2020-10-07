package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.DBServiceImpl;
import dbService.dataSets.UsersDataSet;

import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {

    private final DBService dbService;

    public AccountService(DBService dbService) {

        this.dbService = dbService;
    }

    public long addNewUser(String login, String pass) throws DBException {
            return dbService.addUser(login, pass);
    }

    public UsersDataSet getUserById(long id) throws DBException {
        return dbService.getUser(id);
    }

    public long getId(String login) throws DBException {
        return dbService.getUserId(login);
    }

    public List<UsersDataSet> getAlldataListFromDB() throws DBException {
        return dbService.getAlldataList();

    }
}
