package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Llegim els fitxers tant de data com xifrat
        File f = new File("src/main/resources/data.txt");
        File xf = new File("src/main/resources/xifrat.txt");
        String line;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Amb quin Offset de Cesar vols cifrar? (Default: 3)");
        String input = scanner.nextLine();
        int cesaroff = 0;
        //Offset de cesar per defecte es 3
        if (input.isEmpty()) {
            cesaroff = 3;
        } else {
            try {
                cesaroff = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error, introdueix un numero");
                return;
            }
            System.out.println("Cesar offset escollit: " + cesaroff);
        }
        //Try with resources per llegir i escriure fitxers
        try (
                BufferedReader br = new BufferedReader(new FileReader(f)); BufferedWriter bw = new BufferedWriter(new FileWriter(xf))) {
            
            //Fer que el programa "carregui" per mostrar el progres
            System.out.print("Llegint document");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            System.out.println("Invertint linies...");
            Thread.sleep(4000);
            System.out.println("Xifrant contingut...");
            Thread.sleep(2000);
            System.out.print("Escribint contingut al nou document");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            //Bucle que llegeix el fitxer el inverteix i el xifra
            while ((line = br.readLine()) != null) {
                String invline = new StringBuilder(line).reverse().toString();
                //Stringbuilder per construir el text xifrat a partir dels caracters invertits xifrats
                StringBuilder xifrat = new StringBuilder();
                for (char c : invline.toCharArray()) {
                    xifrat.append((char) (c + cesaroff));
                }
                bw.write(xifrat.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        System.out.println("Fitxer xifrat! comproba el resultat");
        //Funcio per desxifrar
        DesxifrarFitxer(cesaroff);
    }

    public static void DesxifrarFitxer(int offset) {
        String line;
        //Cridem als fitxers xifrat i dexifrat
        File xf = new File("src/main/resources/xifrat.txt");
        File dxf = new File("src/main/resources/desxifrat.txt");
        //Try with resources per llegir i escriure als fitxers
        try (
                BufferedReader br = new BufferedReader(new FileReader(xf)); BufferedWriter bw = new BufferedWriter(new FileWriter(dxf))) {
            //Fer que el programa "carregui" per mostrar el progres
            System.out.print("Llegint document");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            System.out.println("Desxifrant contingut...");
            Thread.sleep(2000);
            System.out.println("Desinvertint linies...");
            Thread.sleep(4000);
            System.out.print("Escribint contingut al nou document");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            //Bucle que llegeis el fitxer xifrat, el desxifra e inverteix
            while ((line = br.readLine()) != null) {
                //Stringbuilder per construir el text desxifrat a partir dels caracters xifrats 
                StringBuilder textdesxifrat = new StringBuilder();
                for (char c : line.toCharArray()) {
                    textdesxifrat.append((char) (c - offset));
                }
                //Invertim la linia desxifrada
                String invline = new StringBuilder(textdesxifrat).reverse().toString();
                bw.write(invline);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
