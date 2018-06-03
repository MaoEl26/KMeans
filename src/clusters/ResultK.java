/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mcv26
 */
public class ResultK {
    private List<Clusters> clusters = new ArrayList<>();
    private final Double ObjFuncVal;

    public ResultK(List<Clusters> clusters, Double ObjFuncVal) {
	super();
	this.ObjFuncVal = ObjFuncVal;
	this.clusters = clusters;
    }

    public List<Clusters> getClusters() {
	return clusters;
    }

    public Double getObjFuncVal() {
	return ObjFuncVal;
    }
}
