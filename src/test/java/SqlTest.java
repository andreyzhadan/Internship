import com.zhadan.sql.junior.bean.User;
import com.zhadan.sql.junior.dao.UserDao;
import com.zhadan.sql.junior.dao.UserDaoJdbc;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by azhadan on 7/10/13.
 */
public class SqlTest {

    @Test
    public void testEmpty() throws SQLException {
        System.out.println("@Test - testEmptyCollection");
        UserDao dao = new UserDaoJdbc();
        //  dao.insert(new User("andrey", "zhadan", 21));
        for (User user : dao.selectAll()) {
            System.out.println(user.toString());
        }
    }
}
