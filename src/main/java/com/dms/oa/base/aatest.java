package com.dms.oa.base;

import java.io.BufferedReader;  
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;  

public class aatest {  
    public static boolean saveUrlAs(String photoUrl, String fileName) {  
        //此方法只能用户HTTP协议  
            try {  
              URL url = new URL(photoUrl);  
              HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
            //  InputStream is=new InputStream("/tmp/pcilog/p/pkuk.log");
              InputStream is= new   ByteArrayInputStream("abc".getBytes());
             // DataInputStream in = new DataInputStream(connection.getInputStream());  
              DataInputStream in = new DataInputStream(is);  
              DataOutputStream out = new DataOutputStream(new FileOutputStream("d:/a.txt"));  
              byte[] buffer = new byte[4096];  
              int count = 0;  
              while ((count = in.read(buffer)) > 0) {  
                out.write(buffer, 0, count);  
              }  
              out.close();  
              in.close();  
              return true;  
            }  
            catch (Exception e) {  
              return false;  
            }  
          }  
           
   /*     public String getDocumentAt(String urlString) {  
        //此方法兼容HTTP和FTP协议  
            StringBuffer document = new StringBuffer();  
            try {  
              URL url = new URL(urlString);  
              URLConnection conn = url.openConnection();  
              BufferedReader reader = new BufferedReader(new InputStreamReader(conn.  
                  getInputStream()));  
              String line = null;  
              while ( (line = reader.readLine()) != null) {  
                document.append(line + "/n");  
              }  
              reader.close();  
            }  
            catch (MalformedURLException e) {  
              System.out.println("Unable to connect to URL: " + urlString);  
            }  
            catch (IOException e) {  
              System.out.println("IOException when connecting to URL: " + urlString);  
            }  
            return document.toString();  
          } */ 
          
        public static void main(String[] args) {  
           
              
              String photoUrl = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";                                    
              String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));  
              String filePath = "d:/";  
              boolean flag = saveUrlAs(photoUrl, filePath + fileName);  
              System.out.println("Run ok!/n<BR>Get URL file " + flag);  
                
        }  
}  