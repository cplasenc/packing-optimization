package proyectofint1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatosEmbalajes {
    public  int largo, ancho, alto;
    public void EscribirFichero() {
        String NombreFichero = "Embalajes.txt";
        String datos=ancho+" : "+largo+" : "+alto+"\n";
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(NombreFichero, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(datos);
            out.close();
        } catch (IOException e) {
           
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
