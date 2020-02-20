/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author George
 */
public class Database {
String url;
String uss;
String pwd;
String driver;

    
    public Database (){
        this.url = "jdbc:mysql://localhost:3306/club_nautico?useSSL=false";
        this.uss = "root";
        this.pwd = "admin";
        this.driver = "com.mysql.jdbc.Driver";
    }

    public String getUrl() {
        return url;
    }

    public String getUss() {
        return uss;
    }

    public String getPwd() {
        return pwd;
    }

    public String getDriver() {
        return driver;
    }
    
    
    
    
    
}
