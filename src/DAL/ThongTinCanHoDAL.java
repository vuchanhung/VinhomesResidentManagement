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
public class ThongTinCanHoDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    
   public ArrayList<CanHo> dsCanHo() {
        String sql = "select distinct MaCanHo,DienTich,Gia,SoPhong,TenKhu from CANHO ch join KHUCANHO kch on ch.Makhu=kch.MaKhu where TrangThai=0";
       
        ArrayList<CanHo> dsCanHo = new ArrayList<>();
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();
            while (rs.next()) {
                CanHo ch = new CanHo();
                ch.setMaCanHo(rs.getString(1));
                ch.setDienTich(rs.getFloat(2));
                ch.setGia(rs.getLong(3));
                ch.setSoPhong(rs.getInt(4));
                ch.setTenKhu(rs.getString(5));
                dsCanHo.add(ch);
            }
        } catch (SQLException e) {
            System.out.println("Error in ThongTinCanHoDAL: "+e.getMessage());
        }
        finally{
            try{
                conn.close();
                pres.close();
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return dsCanHo;
    }
}
