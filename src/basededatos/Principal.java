/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author alxz_
 */
public class Principal {
    
    public static void main(String[] args){
        Conexion cn = new Conexion();
        cn.conectar();
        String ruta;
        Blob blob;
        
        
        //Metodo que realiza el query para buscar
        ResultSet r = cn.consulta("select Nombre_Completo, Foto from Hoja3;");
    
        try {
            while(r.next()){
                
                ruta ="C:/Users/alxz_/Documents/NetBeansProjects/BaseDeDatos/Fotos/" + r.getString("Nombre_Completo")+".png";
                             
            if(r.getBinaryStream("Foto")!=null){    
            File image = new File(ruta);
            FileOutputStream fos = new FileOutputStream(image);
            byte [] buffer = r.getBytes("Foto");
            InputStream is = r.getBinaryStream("Foto");
             
            while(is.read(buffer)>0){
                fos.write(buffer);
            }
            fos.close();
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

