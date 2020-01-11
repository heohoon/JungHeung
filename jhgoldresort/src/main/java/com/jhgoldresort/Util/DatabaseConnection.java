package com.jhgoldresort.Util;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseConnection {
    public Connection getDatabaseConnection() throws NamingException, SQLException;

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
}
