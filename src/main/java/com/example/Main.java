package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        File f = new File("src/main/resources/data.txt");
        File xf = new File ("src/main/resources/xifrat.txt");
        int lectura = 0;
        String line;
        int ceasaroff = 3; 
        //De esta forma el offset se simplifica
        ceasaroff = ceasaroff % 26;
        try (
            BufferedReader br = new BufferedReader(new FileReader(f));
            BufferedWriter bw = new BufferedWriter(new FileWriter(xf))
        ){
        while ((line = br.readLine()) != null){
                
                String invline = new StringBuilder(line).reverse().toString();
                
                bw.write(invline + "\n");
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }

    }
}

