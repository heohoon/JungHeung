package com.jhgoldresort.DAO;

import com.jhgoldresort.DTO.MemberDTO;
import com.jhgoldresort.Util.DatabaseConnection;
import com.jhgoldresort.Util.MariadbConnection;
import org.mariadb.jdbc.MariaDbConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    private static MemberDAO instance;

    private MemberDAO(){

    }

    public static MemberDAO getInstance() {
        if(instance == null)
            instance = new MemberDAO();
        return instance;
    }

    public MemberDTO selectMember(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberDTO mdto = new MemberDTO();
        try {
            conn = new MariadbConnection().getDatabaseConnection();
            ps = conn.prepareStatement("select * from users where id = ?");
            ps.setString(1,id);
            rs = ps.executeQuery();
            rs.next();
            mdto.setId(rs.getString("id"));
            mdto.setName(rs.getString("name"));
            mdto.setPassword(rs.getString("password"));
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {
                rs.close();
            }
            else if (ps != null){
                ps.close();
            }
            else if (conn != null) {
                conn.close();
            }
        }
        return mdto;
    }
}
