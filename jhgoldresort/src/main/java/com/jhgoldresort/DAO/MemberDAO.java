package com.jhgoldresort.DAO;

import com.jhgoldresort.DTO.MemberDTO;
import com.jhgoldresort.Util.DatabaseConnection;
import com.jhgoldresort.Util.MariadbConnection;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

    private static MemberDAO instance;

    private MemberDAO(){

    }

    public static MemberDAO getInstance() {
        if(instance == null)
            instance = new MemberDAO();
        return instance;
    }
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private DatabaseConnection dc = null;


    public int insertMember(String userid, String userpassword, String username) throws SQLException {
        int result = 0;
        try{
            dc = new MariadbConnection();
            conn = dc.getDatabaseConnection();
            ps = conn.prepareStatement("insert into users(id,password,name) values(?,?,?)");
            ps.setString(1,userid);
            ps.setString(2,userpassword);
            ps.setString(3,username);
            result = ps.executeUpdate();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally{
            dc.closeConnection(null,ps,conn);
        }
        return result;
    }



    public MemberDTO selectMember(String id, String password) throws SQLException {
        MemberDTO mdto = new MemberDTO();
        try {
            dc = new MariadbConnection();
            conn = dc.getDatabaseConnection();
            ps = conn.prepareStatement("select * from users where id = ? and password = ?");
            ps.setString(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()) {
                mdto.setId(rs.getString("id"));
                mdto.setName(rs.getString("name"));
                mdto.setPassword(rs.getString("password"));
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }finally {
            dc.closeConnection(rs,ps,conn);
        }
        return mdto;
    }

    public ArrayList<MemberDTO> selectMemberAll() throws SQLException {
        ArrayList<MemberDTO> mList = new ArrayList<MemberDTO>();
        MemberDTO mdto = null;
        try {
            dc = new MariadbConnection();
            conn = dc.getDatabaseConnection();
            ps = conn.prepareStatement("select * from users ");
            rs = ps.executeQuery();
            while(rs.next()) {
                mdto = new MemberDTO();
                mdto.setId(rs.getString("id"));
                mdto.setName(rs.getString("name"));
                mdto.setPassword(rs.getString("password"));
                mList.add(mdto);
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }finally {
            dc.closeConnection(rs,ps,conn);
        }
        return mList;
    }
}
