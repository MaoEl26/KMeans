/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusters;

import java.io.FileReader;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mcv26
 */
public class Start {
    public static void main(String[] args) throws IOException {
	CSVReader reader = new CSVReader(new FileReader("data.csv"));
	FileWriter writer = new FileWriter("out.csv");

	List<String[]> myEntries = reader.readAll();
	List<Points> puntos = new ArrayList<Points>();

	for (String[] strings : myEntries) {
	    Points p = new Points(strings);
	    puntos.add(p);
	}

	       K_means_Algorithm kmeans = new K_means_Algorithm();
	for (int k = 2; k <= 8; k++) {
	           ResultK resultado = kmeans.calcular(puntos, k);
	    writer.write("------- Con k= " + k + " ofv= " + resultado.getObjFuncVal()
		    + "-------\n");
	    int i = 0;
	    for (Clusters cluster : resultado.getClusters()) {
		i++;
		writer.write("-- Cluster " + i + " --\n");
		for (Points punto : cluster.getPuntos()) {
		    writer.write(punto.toString() + "\n");
		}
		writer.write("\nCentroide ");
		writer.write(cluster.getCentroide().toString());
		writer.write("\n\n");
	    }
	}
	writer.close();
    }
    
}
