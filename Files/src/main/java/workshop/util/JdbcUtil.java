package workshop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Slf4j
public final class JdbcUtil {

    private static final Logger log = LoggerFactory.getLogger(JdbcUtil.class);

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USERNAME = "ora";
    private static final String PASSWORD = "root";

    private static Connection INSTANCE = null;

    private JdbcUtil() {
    }

    public static Connection getConnection() {
        if (INSTANCE == null) {
            try {
                INSTANCE = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                log.info("ERROR: " + e);
            }
            log.info("connection object is created");
        }
        return INSTANCE;
    }
}
