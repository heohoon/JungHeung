package com.jhgoldresort.Util;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    public Connection getDatabaseConnection() throws NamingException, SQLException;
}
