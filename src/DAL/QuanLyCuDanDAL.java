/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;


        
/**
 *
 * @author PC
 */
public class QuanLyCuDanDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    
    public ArrayList<CuDan> ListCuDan() {
        //ResultSet rs = ConnectSQL.connect().createStatement().executeQuery(query);
        String sql = "select * from CUDAN";
        
        ArrayList<CuDan> dsCuDan = new ArrayList<>();
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();
            while (rs.next()) {
                CuDan cd = new CuDan();
                cd.setMaCuDan(rs.getString(1));
                cd.setTenCuDan(rs.getString(2));
                cd.setNgaySinh(rs.getString(3));
                cd.setGioiTinh(rs.getBoolean(4));
                cd.setSoDT(rs.getString(5));
                cd.setSoCMT(rs.getString(6));
                cd.setQueQuan(rs.getString(7));

                dsCuDan.add(cd);
            }
        } catch (SQLException e) {
            System.out.println("Error in QuanLyCuDanDAL: " + e.getMessage());
        }
        finally {
            try{
                conn.close();
                pres.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return dsCuDan;
    }
    
    
    
    
    



}
