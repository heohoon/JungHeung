package com.jhgoldresort.Member.DAO;

import com.jhgoldresort.Member.DTO.MemberDTO;
import com.jhgoldresort.Common.Util.DatabaseConnection;
import com.jhgoldresort.Common.Util.MariadbConnection;
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


    public int insertMember(String id, String password, String name) throws SQLException {
        int result = 0;
        try{
            dc = new MariadbConnection();
            conn = dc.getDatabaseConnection();
            ps = conn.prepareStatement("insert into users_tb (user_id, user_password, user_name) values ( ?, ?, ?)");
            ps.setString(1,id);
            ps.setString(2,password);
            ps.setString(3,name);
            result = ps.executeUpdate();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            dc.closeConnection(null, ps, conn);
        }
        return result;
    }



    public MemberDTO selectMember(String id, String password) throws SQLException {
        MemberDTO mdto = new MemberDTO();
        try {
            dc = new MariadbConnection();
            conn = dc.getDatabaseConnection();
            ps = conn.prepareStatement("select * from users_tb where user_id = ? and user_password = ?");
            ps.setString(1,id);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()) {
                mdto.setId(rs.getString("user_id"));
                mdto.setName(rs.getString("user_name"));
                mdto.setPassword(rs.getString("user_password"));
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
            ps = conn.prepareStatement("select * from users_tb ");
            rs = ps.executeQuery();
            while(rs.next()) {
                mdto = new MemberDTO();
                mdto.setIdx(rs.getInt("user_idx"));
                mdto.setId(rs.getString("user_id"));
                mdto.setName(rs.getString("user_name"));
                mdto.setPassword(rs.getString("user_password"));
                mList.add(mdto);
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            dc.closeConnection(rs,ps,conn);
        }
        return mList;
    }
}
