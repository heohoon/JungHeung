package com.jhgoldresort.Common.Util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariadbConnection implements DatabaseConnection {

    public MariadbConnection() {

    }

    @Override
    public Connection getDatabaseConnection() throws NamingException, SQLException {
        Context initContext = new InitialContext();
        DataSource dataSource = (DataSource)initContext.lookup("java:comp/env/jdbc/mariadb");
        Connection conn = dataSource.getConnection();
        return conn;
    }

    @Override
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if(rs != null){
            rs.close();
        }if(ps != null){
            ps.close();
        }if(conn != null){
            conn.close();
        }
        System.out.print("close database connection");
    }
}
