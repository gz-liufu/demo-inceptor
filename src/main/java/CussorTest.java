import java.sql.*;
import oracle.jdbc.internal.OracleTypes;
public class CussorTest {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        String sql = "{call test.getEmpByDeptno(?,?)}";
//Hive2 JDBC URL with LDAP
        String jdbcURL = "jdbc:hive2://172.20.234.103:10000/default";
        Connection conn = DriverManager.getConnection(jdbcURL, "hive", "123456");
        CallableStatement cst = conn.prepareCall(sql);
        cst.setString(1, "aa");
        cst.registerOutParameter(2,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rst = (ResultSet) cst.getObject(2);
        while (rst.next()) {
            System.out.println(rst.getString("deptno"));
        }
        rst.close();
        cst.close();
        conn.close();
    }
}
