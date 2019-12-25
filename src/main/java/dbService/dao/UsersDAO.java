package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);

        Object result =  criteria.add(Restrictions.eq("login", name)).uniqueResult();

        if(result == null) return 0;
        return ((UsersDataSet) result).getId();
    }

    public long insertUser(String login, String pass) throws HibernateException {
        return (long) session.save(new UsersDataSet(login, pass));
    }

    @SuppressWarnings("unchecked")
    public List<UsersDataSet> getAlldata(){
        try
        {
            return session.createCriteria(UsersDataSet.class).list();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
