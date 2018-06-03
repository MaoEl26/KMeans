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
public class Points {
    private Float[]  info;
    
    public Points(String[] strings){
        super();
        ArrayList<Float> points = new ArrayList<>();
        for (String string : strings){
            points.add(Float.parseFloat(string));
        }
        this.info = points.toArray(new Float[strings.length]);
    }
    
    public Points(Float[] info){
        this.info = info;
    }
    
    public float getDimension(int dimension){
        return info[dimension];
    }
    
    public int getGrado(){
        return info.length;
    }
    
    public Double distanciaEuclideana(Points destino){
        Double d = 0d;
        for (int i = 0; i < info.length; i++){
        d += Math.pow(info[i]-destino.getDimension(i),2);        
    }
        return Math.sqrt(d);
    }
    
    @Override
    public boolean equals(Object obj){
        Points other = (Points) obj;
        for(int i = 0; i < info.length; i++){
            if (info[i] != other.getDimension(i)) {
		return false;
	    }
        }return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
	sb.append(info[0]);
	for (int i = 1; i < info.length; i++) {
	    sb.append(", ");
	    sb.append(info[i]);
	}
	return sb.toString();
    }
}
