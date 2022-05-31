/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DTO.*;
import DAL.*;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class ThongTinMuaBanBLL {
    ThongTinMuaBanDAL ThongTin_MuaBanDAL = new ThongTinMuaBanDAL();
    
    public ArrayList<HopDong> dsHopDong(){
        return ThongTin_MuaBanDAL.dsHopDong();
    }
    
    
    
}
