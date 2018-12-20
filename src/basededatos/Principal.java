/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author alxz_
 */
public class Principal {
    
    public static void main(String[] args){
        Conexion cn = new Conexion();
        cn.conectar();
        String ruta;
        
        
        //Metodo que realiza el query para buscar
        ResultSet r = cn.consulta("select Nombre_Completo, Foto from Hoja3");
        try {
            while(r.next()){
                
                ruta ="C:/Users/alxz_/Documents/NetBeansProjects/BaseDeDatos/Fotos/" + r.getString("Nombre_Completo")+".jpeg";
                
                
      ByteArrayInputStream bis = new ByteArrayInputStream(r.getBytes("Foto"));
      BufferedImage bf1 = ImageIO.read(bis);
      if (bf1 != null){
      ImageIO.write(bf1, "jpg", new File(ruta));
      }
      //System.out.println("image created");
                System.out.println(ruta);   
                //System.out.println(r.getInt("Id")+r.getString("No_Control")+r.getString("CARRERA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
