package proyectofint1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class  DatosProductos {
    public  int largo, ancho, alto;
    public  String descripcion; 
    public int cantidad;
    public  List<DatosEmbalajes> datosEmb ;
    public DatosProductos(){
        
        datosEmb=new ArrayList();
        leerDatosEmbalaje();
        
    } 
    private void leerDatosEmbalaje(){
        String NombreFichero="Embalajes.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NombreFichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                DatosEmbalajes d=new DatosEmbalajes();
                
                String [] arr=linea.split(":");
                if(!linea.equals(""))
                {    d.ancho=Integer.parseInt(arr[0].replace(" ", ""));
                    d.largo=Integer.parseInt(arr[1].replace(" ",""));
                    d.alto=Integer.parseInt(arr[2].replace(" ",""));
                    datosEmb.add(d);  
                }
            }
        } catch (IOException e) {
        
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
        
            }
        }
         
    }
    public void escribirEnFichero() {
        String nombreFichero = "Productos.txt";
        String datos=descripcion+" : "+ancho+" : "+largo+" : "+alto+"\n";
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(nombreFichero, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(datos);
            out.close();
        } 
        catch (IOException e) {
            
        }
        finally {
            if(out != null)
                out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                
            }
        }
        
    }
    public void EscribirPedido(String id, String da,String qu) {
        String NombreFichero = "Pedidos.txt";
        String datos=id+"#"+descripcion+":"+ancho+":"+largo+":"+alto+":"+cantidad+"\tTamaño caja== "+da+" Nº de Cajas : "+qu+"\n";
                
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(NombreFichero, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(datos);
            out.close();
        } 
        catch (IOException e) {
            
        }
        finally {
            if(out != null)
                out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                
            }
        }
    }
    public List<String> recogerProductos(){
        List<String> l=new ArrayList();
        String NombreFichero="Productos.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NombreFichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                
                String [] arr=linea.split(":");
                if(!linea.equals("")) {   
                    l.add(arr[0]); 
                }
            }
        } catch (IOException e) {
        
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
        
            }
        }
        
        return l;
    }
    
    public List<DatosProductos> recogerDatosProductos(){
        List<DatosProductos> l=new ArrayList();
        String NombreFichero="Productos.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NombreFichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                
                String [] arr=linea.split(":");
                if(!linea.equals("")){
                    DatosProductos d=new DatosProductos();
                    
                    d.descripcion=arr[0];
                    
                    d.ancho=Integer.parseInt(arr[1].replace(" ", ""));
                    
                    d.largo=Integer.parseInt(arr[2].replace(" ",""));
                    
                    d.alto=Integer.parseInt(arr[3].replace(" ",""));
                     
                    l.add(d);                    
                }
            }
        } catch (IOException e) {
        
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
        
            }
        }
        
        return l;
    }
    
    
     public int [] TamanoMinCaja(DatosProductos d) {
         int [] dimen=new int[4];
         for(int i=0; i<3; i++) 
             dimen[i]=Integer.MAX_VALUE;
         for (int i=0; i<datosEmb.size(); i++) {
             if(  (dimen[0]>=datosEmb.get(i).ancho && dimen[1]>=datosEmb.get(i).alto && dimen[2]>=datosEmb.get(i).largo ) 
                  &&   (d.ancho<=datosEmb.get(i).ancho && d.alto<=datosEmb.get(i).alto && d.largo<=datosEmb.get(i).largo )) 
             {
                dimen[0]=datosEmb.get(i).ancho;
                dimen[1]=datosEmb.get(i).largo;
                dimen[2]=datosEmb.get(i).alto;
                for(int j=1;  ; j++) {
                    if((j*dimen[0])>=(d.ancho*d.cantidad) && (j*dimen[1])>=(d.largo*d.cantidad) && (j*dimen[2])>=(d.alto*d.cantidad) )
                    {   
                        dimen[3]=j;
                        break;
                    }
                }
             }
         
        }                  
         return dimen;
     }
     public List<DatosProductos> recogerPedidoProducto(String pedidoid) {
        String NombreFichero="Pedidos.txt";
        List<DatosProductos> ls=new ArrayList();
        BufferedReader br = null;
        try {
            pedidoid="ID-no."+pedidoid;
                    
            br = new BufferedReader(new FileReader(NombreFichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                DatosProductos d=new DatosProductos();
                
                
                if(!linea.equals("")){
                    String [] arr0=linea.split("\t");
                    String [] arr1=arr0[0].split("#");
                    if(arr1[0].equals(pedidoid)){
                        String [] arr=arr1[1].split(":");
                        d.descripcion=arr[0]; 
                        d.ancho=Integer.parseInt(arr[1]);
                        d.largo=Integer.parseInt(arr[2]);
                        d.alto=Integer.parseInt(arr[3]);
                        d.cantidad=Integer.parseInt(arr[4]);
                        ls.add(d); 
                    }
//  datosEmb.add(d);  
                   
                }
            }
        } catch (IOException e) {
        
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
        
            }
        }
         
     return ls;
     }
   public void EscribirEnvios(String pedidoid, String Status){
        String NombreFichero = "Envios.txt";
        String datos=pedidoid+" : "+Status;
                
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(NombreFichero, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(datos);
            out.close();
        } 
        catch (IOException e) {
            
        }
        finally {
            if(out != null)
                out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                
            }
        } 
   }
          
}
