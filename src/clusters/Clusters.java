/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusters;


import java.util.ArrayList;
/**
 *
 * @author mcv26
 */
public class Clusters {
    private ArrayList<Points> puntos = new ArrayList<>();
    private Points centroide;
    private boolean termino = false;
    
    public Points getCentroide(){
        return centroide;
    }
    
    public void setCentroide(Points centroide){
        this.centroide = centroide;
    }
    
    public ArrayList<Points> getPuntos(){
        return puntos;
    }
    
    public boolean isTermino(){
        return termino;
    }
    
    public void setTermino(boolean termino){
        this.termino = termino;
    }
    
    public void limpiarPuntos(){
        puntos.clear();
    }
    
    @Override
    public String toString(){
        return centroide.toString();
    }
}
