/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Libreria {

    private File fich;
    private File fich2;
    private File fich3;
    private PrintWriter escribir;
    private Libro lib;
    private String line;
    private Scanner sc;
    private String ficheroCompleto = "";
    private String libro;
    private String[] listaSalvada;
    private static int m = 0;
    private int uds;
    private float precio;
    private String tit;
    private String aut;
    private String[] modificar;
    private float preciom;

    public void insertarLibro() {
        tit = JOptionPane.showInputDialog("Titulo del libro");
        aut = JOptionPane.showInputDialog("Autor");
        precio = Float.parseFloat(JOptionPane.showInputDialog("Precio"));
        uds = Integer.parseInt(JOptionPane.showInputDialog("Unidades"));
        try {
            fich = new File("boletin20.txt");
            escribir = new PrintWriter(new FileWriter(fich, true));
            lib = new Libro(tit, aut, precio, uds);
            escribir.println("Titulo: " + tit + ", autor: " + aut + ", precio: " + precio + ", unidades: " + uds);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de escritura" + ex);
        } catch (IOException ex) {
            System.out.println("Error de escritura" + ex);
        } finally {
            escribir.close();
        }
    }

    public void consultarLibro() {
        try {
            String pedir = JOptionPane.showInputDialog("Titulo a consultar");
            final BufferedReader reader = new BufferedReader(new FileReader("boletin20.txt"));
            String line = "";

            while ((line = reader.readLine()) != null) {
                m = 0;
                if (line.indexOf(pedir) != -1) {
                    String[] lista = line.split("\\s*,\\s*");
                    JOptionPane.showMessageDialog(null, lista[2]);
                    m = 1;
                    break;

                }
            }
            if (m == 0) {
                JOptionPane.showMessageDialog(null, "No tenemos ese libro");
            }

            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void visualizar() {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader("boletin20.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                ficheroCompleto = ficheroCompleto + "\n" + line;
            }

            JOptionPane.showMessageDialog(null, ficheroCompleto);
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ficheroCompleto = null;
        }

    }

    public void borrarLibro() {

        fich = new File("boletin20.txt");
        fich2 = new File("boletin20.1.txt");

        try {

            final BufferedReader reader = new BufferedReader(new FileReader("boletin20.txt"));
            escribir = new PrintWriter(new FileWriter(fich2, true));
            while ((line = reader.readLine()) != null) {
                String salvadas = line;

                if (salvadas.contains("unidades: 0") != true) {

                    escribir.println(salvadas);

                    JOptionPane.showMessageDialog(null, salvadas);

                }
            }
            
            reader.close();
            escribir.close();
            fich.delete();
            fich2.renameTo(fich);

            boolean correcto = fich2.renameTo(fich);

            if (correcto) {
                System.out.println("Fichero renombrado.");

            } else {
                System.out.println("fichero no renombrado");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public void modificar() {
             fich = new File("libreria.txt");
        fich2 = new File("libreria2.txt");
        
        try {
            String pedir = JOptionPane.showInputDialog("Introduce el titulo");

            float nprecio = Float.parseFloat(JOptionPane.showInputDialog("Introduce el nuevo precio"));

            final BufferedReader reader = new BufferedReader(new FileReader("boletin20.txt"));

            escribir = new PrintWriter(new FileWriter(fich2, true));

            while ((line = reader.readLine()) != null) {
                m = 0;
                String salvadas = line;

                if (salvadas.contains(pedir) != true) {
                    escribir.println(salvadas);
                }else{

                    String[] sep = salvadas.split("\\s*,\\s*");

                    String precio = sep[2];

                    String[] precioseparado = precio.split("\\s*:\\s*");
                   
                    precioseparado[1] = String.valueOf(nprecio);
  
                    salvadas = sep[0]+", "+sep[1]+", "+precioseparado[0]+": "+precioseparado[1]+", "+sep[3];
                    escribir.println(salvadas);
                    salvadas = "";
                    precio ="";
                }
            }

            reader.close();
            escribir.close();
            fich.delete();

            boolean correcto = fich2.renameTo(fich);

            if (correcto) {
                System.out.println("Fichero renombrado.");

            } else {
                System.out.println("fichero no renombrado");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

}
}
