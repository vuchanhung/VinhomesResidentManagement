/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.*;
import DTO.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;
/**
 *
 * @author PC
 */
public class TaiKhoanBLL {
    
    
    TaiKhoanDAL TK = new TaiKhoanDAL();
    public boolean checkEmpty(){
        return TK.show(false).isEmpty();
    }
    
    public TableModel show(){
        ArrayList<TaiKhoan> list = TK.show(false);
        String[] colunmNames = {"Username","Password"};
        Object[][] data = new Object[list.size()][colunmNames.length];
        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getTenTaiKhoan();
            data[i][1] = list.get(i).getMatKhau();
        }
        
        return new DefaultTableModel(data,colunmNames);
    }
    public TaiKhoan dangNhapBLL (String userName,String passWord){
        TaiKhoan tk = TK.dangNhap(userName, passWord);
        return tk;
    }
    
    public boolean GetVaiTro(TaiKhoan tk){
        return tk.isVaiTro();
    }
    public boolean checkAccountManager(String tenTaiKhoan,String matKhau){
         ArrayList<TaiKhoan> list = TK.show(true);
         return matKhau.equalsIgnoreCase(list.get(0).getMatKhau()) && tenTaiKhoan.equalsIgnoreCase(list.get(0).getTenTaiKhoan());
    }
    
    public boolean insert(String tenTaiKhoan,String matKhau){
        return TK.insert(tenTaiKhoan,matKhau);  
    }
    
    public boolean update(String tenTaiKhoan,String matKhau,boolean vaiTro){
        return TK.update(tenTaiKhoan,matKhau,vaiTro);
        
    }
    
     public boolean update(String tenTaiKhoan,String matKhau){
        return TK.update(tenTaiKhoan,matKhau);
        
    }
    
}
