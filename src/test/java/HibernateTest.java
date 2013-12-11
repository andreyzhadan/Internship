//import static org.hibernate.criterion.Order.desc;
//import static org.hibernate.criterion.Restrictions.eq;
//import static org.hibernate.criterion.Restrictions.ge;

/**
 * Created by azhadan on 7/29/13.
 */
public class HibernateTest {
//    private Session session;
//    private Transaction tx;
//
//    @Before
//    public void setUp() {
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        this.session = factory.openSession();
//        this.tx = session.beginTransaction();
//    }
//
//    @Test
//    public void testSelectById() throws SQLException {
//        User user = (User) session.get(User.class, 1L);
//        System.out.println(user);
//    }
//
//    @Test
//    public void testSelectAll() throws SQLException {
//        Query query = session.createQuery("from User");
//        List<User> allUsers = query.list();
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testSelectAllByCriteria() throws SQLException {
//        Criteria criteria = session.createCriteria(User.class);
//        List<User> allUsers = criteria.list();
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testSelectWhereCriteria() throws SQLException {
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(eq("name", "Mike"))
//                .add(ge("id", 2L))
//                .addOrder(desc("id"));
//        List<User> allUsers = criteria.list();
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testInsert() throws SQLException {
//        User newUser = new User("Mike", "Stone", 21);
//        session.save(newUser);
//        System.out.println(newUser);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        this.tx.commit();
//        this.session.close();
//    }
}
