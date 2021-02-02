package proyectofint1;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JToggleButton;

public class ProyectoFinT1 implements ActionListener {
    private static JMenuItem embaj=new JMenuItem("Embalajes");
    private static JMenuItem product=new JMenuItem("Productos");
    private static Embalajes em=new Embalajes();
    private static Productos prdct=new Productos();
    private static Pedidos pddo=new Pedidos();
    private static Envios envio=new Envios();
    private static Consultas consult=new Consultas();
    private static JMenuItem pedido=new JMenuItem("Pedidos");
    private static JToggleButton Consultas=new JToggleButton("Consultas");
    private static JToggleButton Envios=new JToggleButton("Envios");
    public  static JFrame  frame = new JFrame("ProyectoFinT1");
    public  static DatosProductos [] datosProductos;
    public  static DatosEmbalajes [] datosEmbalajes;   
    public static void main(String[] args) {    
        
        frame.setSize(800,600);
        frame.setLocation(250, 75);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        frame.setVisible(true);
        JMenuBar mb=new JMenuBar();
        frame.setJMenuBar(mb);
        
    
        JMenu Registration=new JMenu("Altas");
        Registration.setBackground(Color.GRAY);
        Registration.add(embaj);
        Registration.add(product);        
        Registration.add(pedido);
        mb.add(Registration);
        mb.add(Consultas);
        mb.add(Envios);
        frame.setVisible(true);
        embaj.addActionListener(new ProyectoFinT1());
        product.addActionListener(new ProyectoFinT1());
        pedido.addActionListener(new ProyectoFinT1());
        Consultas.addActionListener(new ProyectoFinT1());
        Envios.addActionListener(new ProyectoFinT1()); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==pedido){   
        frame.remove(prdct.getContentPane());
        frame.remove(em.getContentPane());
        frame.remove(envio.getContentPane());
        frame.remove(consult.getContentPane());
        pddo.recogerDatos();
        frame.add(pddo.getContentPane());
        frame.getContentPane().invalidate();
        frame.getContentPane().validate();
        
    }
    else if(e.getSource()==embaj){    
         
         frame.remove(prdct.getContentPane());
         frame.remove(pddo.getContentPane());
         frame.remove(envio.getContentPane());         
         frame.remove(consult.getContentPane());        
         frame.add(em.getContentPane());
         frame.getContentPane().invalidate();
         frame.getContentPane().validate();
         
    }
    else if(e.getSource()==product){
       
         frame.remove(pddo.getContentPane());
         frame.remove(em.getContentPane());
         frame.remove(envio.getContentPane());
         frame.remove(consult.getContentPane());        
         frame.add(prdct.getContentPane());
         frame.getContentPane().invalidate();
         frame.getContentPane().validate();
    }
    else if(e.getSource()==Consultas){    
         frame.remove(pddo.getContentPane());
         frame.remove(em.getContentPane());
         frame.remove(prdct.getContentPane());
         frame.remove(envio.getContentPane());  
         frame.add(consult.getContentPane());
         frame.getContentPane().invalidate();
         frame.getContentPane().validate();
        
    }
    else if(e.getSource()==Envios){
         frame.remove(pddo.getContentPane());
         frame.remove(em.getContentPane());
         frame.remove(prdct.getContentPane());
         frame.remove(consult.getContentPane());  
         frame.add(envio.getContentPane());
         frame.getContentPane().invalidate();
         frame.getContentPane().validate();
        
        
    }
}
    private static void cPanel(JPanel panel) {
    frame.getContentPane().removeAll();
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    frame.getContentPane().doLayout();
    frame.update(frame.getGraphics());
}
  
}
