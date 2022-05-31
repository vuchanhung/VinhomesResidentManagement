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
public class TaiKhoanDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<TaiKhoan> show(boolean vaiTro){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String strSQL = "SELECT TenTaiKhoan,MatKhau FROM TAIKHOAN WHERE VaiTro='"+vaiTro+"'";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            rs = pres.executeQuery();
            
            //ResultSet r =  s.executeQuery("SELECT TenTaiKhoan,MatKhau FROM TAIKHOAN WHERE VaiTro='"+vaiTro+"'");
       
            while (rs.next()){
                list.add(new TaiKhoan(rs.getString("TenTaiKhoan"), rs.getString("MatKhau")));
            }   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return list;
    }
    public TaiKhoan dangNhap(String userName,String passWord) {
		boolean vaiTro;
		TaiKhoan tk=null;
                String sql = "select * from TAIKHOAN where TenTaiKhoan=? and MatKhau=?";
		try {
                    //String sql="select * from TAIKHOAN where TenTaiKhoan=? and MatKhau=?";	
                    dbu = new DBUtils();
                    conn = dbu.createConn();
                    pres = conn.prepareStatement(sql);
                    //rs = pres.executeQuery();
            //
                //    PreparedStatement pre=connection.prepareStatement(sql);
                    pres.setString(1, userName);
                    pres.setString(2, passWord);
                    rs=pres.executeQuery();
                    if (rs.next()) {
                            tk=new TaiKhoan();
                            tk.setTenTaiKhoan(rs.getString("TenTaiKhoan"));
                            tk.setMatKhau(rs.getString("MatKhau"));
                            tk.setVaiTro(rs.getBoolean("VaiTro"));
                            vaiTro=rs.getBoolean("VaiTro");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
    
   // public boolean getVaiTro(TaiKhoan tk){
      //  return tk.isVaiTro();
   // }
    public boolean insert(String tenTaiKhoan,String matKhau) {
        String sql = "Insert into TAIKHOAN values(?,?,?)";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            //rs = pres.executeQuery();

                
            //PreparedStatement pre = ConnectSQL.connect().prepareStatement("INSERT [dbo].[TAIKHOAN] VALUES (?, ?, ?)");
            pres.setString(1,tenTaiKhoan);
            pres.setString(2,matKhau);
            pres.setBoolean(3,false);
            pres.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
 
    }
    
    public boolean update(String tenTaiKhoan,String matKhau,boolean vaiTro){
        
        String sql = "Update TAIKHOAN set TenTaiKhoan = ?, MatKhau = ? where VaiTro =?";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            //rs = pres.executeQuery();
            //PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyChungCu].[dbo].[TAIKHOAN] "
             //       + "SET TenTaiKhoan = ?,MatKhau =? WHERE VaiTro =?");
            pres.setString(1,tenTaiKhoan);
            pres.setString(2,matKhau);
            pres.setBoolean(3,vaiTro);
            return  pres.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean update(String tenTaiKhoan,String matKhau){
        String sql = "Update TAIKHOAN set MatKhau = ? where TenTaiKhoan = ?";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            //PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyChungCu].[dbo].[TAIKHOAN] "
             //       + "SET MatKhau =? WHERE TenTaiKhoan =?");
            pres.setString(2,tenTaiKhoan);
            pres.setString(1,matKhau);
            return  pres.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    
    
    
}
