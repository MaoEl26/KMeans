/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mcv26
 */
public class K_means_Algorithm {
    public ResultK calcular(List<Points> points, int k){
       List<Clusters> clusters = centroides(points,k);
       
       while (!finalizo(clusters)) {
	    prepararClusters(clusters);
	    asignarPuntos(points, clusters);
	    recalcularCentroides(clusters);
	}

	Double objFunc = FuncionObjetivo(clusters);

	return new ResultK(clusters, objFunc);
    }
    
    private void recalcularCentroides(List<Clusters> clusters) {
	for (Clusters c : clusters) {
	    if (c.getPuntos().isEmpty()) {
		c.setTermino(true);
		continue;
	    }

	    Float[] d = new Float[c.getPuntos().get(0).getGrado()];
	    Arrays.fill(d, 0f);
            c.getPuntos().forEach((p) -> {
                for (int i = 0; i < p.getGrado(); i++) {
                    d[i] += (p.getDimension(i) / c.getPuntos().size());
                }
            });

	    Points nuevoCentroide = new Points(d);

	    if (nuevoCentroide.equals(c.getCentroide())) {
		c.setTermino(true);
	    } else {
		c.setCentroide(nuevoCentroide);
	    }
	}
    }

    private void asignarPuntos(List<Points> puntos, List<Clusters> clusters) {
        for (Points punto : puntos) {
	    Clusters masCercano = clusters.get(0);
	    Double distanciaMinima = Double.MAX_VALUE;
	    for (Clusters cluster : clusters) {
		Double distancia = punto.distanciaEuclideana(cluster
			.getCentroide());
		if (distanciaMinima > distancia) {
		    distanciaMinima = distancia;
		    masCercano = cluster;
		}
	    }
	    masCercano.getPuntos().add(punto);
	}
    }

    private void prepararClusters(List<Clusters> clusters) {
        for (Clusters c : clusters) {
	    c.limpiarPuntos();
	}
    }

    private Double FuncionObjetivo(List<Clusters> clusters) {
	Double ofv = 0d;

	for (Clusters cluster : clusters) {
            for (Points punto : cluster.getPuntos()) {
		ofv += punto.distanciaEuclideana(cluster.getCentroide());
	    }
	}

	return ofv;
    }

    private boolean finalizo(List<Clusters> clusters) {
        for (Clusters cluster : clusters) {
	    if (!cluster.isTermino()) {
		return false;
	    }
	}
	return true;
    }
    
    private List<Clusters> centroides(List<Points> puntos, Integer k) {
	List<Clusters> centroides = new ArrayList<>();

	List<Float> maximos = new ArrayList<>();
	List<Float> minimos = new ArrayList<>();
	// me fijo máximo y mínimo de cada dimensión

	for (int i = 0; i < puntos.get(0).getGrado(); i++) {
	    Float min = Float.POSITIVE_INFINITY, max = Float.NEGATIVE_INFINITY;

	    for (Points punto : puntos) {
		min = min > punto.getDimension(i) ? punto.getDimension(0) : min;
		max = max < punto.getDimension(i) ? punto.getDimension(i) : max;
	    }

	    maximos.add(max);
	    minimos.add(min);
	}
        Random random = new Random();

	for (int i = 0; i < k; i++) {
	    Float[] data = new Float[puntos.get(0).getGrado()];
	    Arrays.fill(data, 0f);
	    for (int d = 0; d < puntos.get(0).getGrado(); d++) {
		data[d] = random.nextFloat()
			* (maximos.get(d) - minimos.get(d)) + minimos.get(d);
	    }

	    Clusters c = new Clusters();
	    Points centroide = new Points(data);
	    c.setCentroide(centroide);
	    centroides.add(c);
	}

	return centroides;
    }
}
