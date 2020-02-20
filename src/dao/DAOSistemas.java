/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Database;
import modelo.Operaciones;
import modelo.Sistemas;

/**
 *
 * @author George
 */
public class DAOSistemas implements Operaciones  {
Database db = new Database();
Sistemas sis = new Sistemas();

@Override
public boolean insertar(Object obj) {
sis = (Sistemas) obj;
Connection con;
PreparedStatement pst;
String sql="insert into socio values (?,?,?)";

try {
    Class.forName(db.getDriver());
    con = DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPwd());
    pst = con.prepareStatement(sql);
    pst.setInt(1,sis.getId());
    pst.setString(2, sis.getDireccion());
    pst.setString(3, sis.getNombre());
    
    int filas = pst.executeUpdate();
    if (filas > 0){
        con.close();
        return true;
    } else {
        con.close();
        return false;
        
    }
    
} catch (SQLException | ClassNotFoundException e){
    JOptionPane.showMessageDialog(null, "Ocurrio el siguente error" + e.getMessage());
    return false;
}
    }

    @Override
    public ArrayList<Object[]> consultar() {
    ArrayList<Object[]> data = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql = "select * from socio";
    
    
    try {
        Class.forName(db.getDriver());
        con = DriverManager.getConnection(db.getUrl(),
        db.getUss(),
        db.getPwd()
        );
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while (rs.next()){
            Object [] fila = new Object[3];
            for (int i = 0; i < 3; i++){
                fila[i]=rs.getObject(i+1);
                
            }
            data.add(fila);
            
        }
        con.close();
    } catch (SQLException | ClassNotFoundException e){
        JOptionPane.showMessageDialog(null, "Ocurrio este error: " + e.getMessage());
    } finally {
        return data;
    }
   
    }

    @Override
    public boolean modificar(Object obj) {
    sis = (Sistemas) obj;
    Connection con;
    PreparedStatement pst;
    String sql="update socio set direccion=?, nombre=? where id=?";

try {
    Class.forName(db.getDriver());
    con = DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPwd());
    pst = con.prepareStatement(sql);
   // otro orden
//    pst.setString(1, sis.getDireccion());
//    pst.setString(2, sis.getNombre());
//     pst.setInt(3,sis.getId());

      pst.setString(1,sis.getDireccion());
    pst.setString(2, sis.getNombre());
    pst.setInt(3, sis.getId());
     
     
    int filas = pst.executeUpdate();
    if (filas > 0){
        con.close();
        return true;
    } else {
        con.close();
        return false;
        
    }
    
} catch (SQLException | ClassNotFoundException e){
    JOptionPane.showMessageDialog(null, "Ocurrio el siguente error" + e.getMessage());
    return false;
}    }
    
}
