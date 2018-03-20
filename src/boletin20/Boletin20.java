/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import javax.swing.JOptionPane;

/**
 *
 * @author estudios
 */
public class Boletin20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Libreria lb = new Libreria();
      int op=1;
      while(op!=5){
      op=JOptionPane.showOptionDialog(null, "boletin20", "Opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Insertar Libro","Consultar libro","Visualizar","borrar","modificar","Salir"}, null);
      
      switch(op){
          case 0:
              lb.insertarLibro();
              break;
          case 1:
              lb.consultarLibro();
              break;
          case 2:
              lb.visualizar();
              break;
          case 3:
              lb.borrarLibro();
              break;
          case 4:
              lb.modificar();
              break;
          case 5:
              break;
          default:JOptionPane.showMessageDialog(null, "Opcion no valida");
      }
      }
      }
    }

    
    

