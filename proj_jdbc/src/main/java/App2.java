import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args){

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = null;

        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
        List<Author> list = session.createQuery("FROM Author").list();
        System.out.println(list);
//        session.save(new Author("sasa",32));
//        session.save(new Author("masa",49));
//        session.save(new Author("katy",20));
//        session.getTransaction().commit();
    }

   /*
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3307/users?serverTimezone=UTC";
        String user = "root";
        String password = "debd1867";
        Connection connection = null;
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection =
                    DriverManager.getConnection(url,user,password);

            String sql = "SELECT * FROM USERS";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            List<String> list = new ArrayList<String>();
            while (rs.next()){
                list.add(rs.getString("NAME"));
            }

            System.out.println(list);

            String sql1 = "INSERT INTO users (NAME,GENDER,ADDRESS) " +
                    "VALUES(?,?,?)";

            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql1);

            for(int i =0; i<10000; i++){
                ps.setString(1,"NoName"+i);
                ps.setString(2, "MAle"+i);
                ps.setString(3, "Moscow"+i);
                ps.addBatch();
            }

            int[] res = ps.executeBatch();
            if(res.length<10000){
                connection.rollback();
            }
            connection.commit();
            System.out.println(res);
            *//*
            String sql = "INSERT INTO users (NAME,GENDER,ADDRESS) " +
                    "VALUES(?,?,?)";

            st = connection.prepareStatement(sql);
            st.setString(1, "Dasha");
            st.setString(2,"Fem");
            st.setString(3, "omsk");

            System.out.println(st.executeUpdate());
*//*

//            String sql = "CREATE TABLE IF NOT EXISTS USERS(" +
//                    " ID INT AUTO_INCREMENT," +
//                    " NAME VARCHAR(255)," +
//                    " GENDER VARCHAR(255)," +
//                    " ADDRESS VARCHAR(255), " +
//                    " PRIMARY KEY(ID))";
//
//            st = connection.createStatement();
//            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

*/
}
