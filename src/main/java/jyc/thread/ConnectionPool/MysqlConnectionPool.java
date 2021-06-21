package jyc.thread.ConnectionPool;

import com.mysql.cj.api.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class MysqlConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public MysqlConnectionPool(int threadCount) throws ClassNotFoundException, SQLException {
        if(threadCount > 0){
            for (int i = 0; i < threadCount; i++){
                pool.addLast(getMysqlConnection());
            }
        }
    }

    private Connection getMysqlConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String pwd = "root";
        return DriverManager.getConnection(url, user, pwd);
    }

    public Connection getPoolConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while(pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if(!pool.isEmpty()){
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }

}
