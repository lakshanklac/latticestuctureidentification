/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.math;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pavilion
 */
public class TrigonometricFunctions {
    
    public static List<Float> sineSquaredThetaFromTwoTheta(List<Float> twoThetas) {
        List<Float> sineSquaredThetas = new ArrayList<>();
        
        for (Float twoTheta : twoThetas) {
            float thetaInDegrees = twoTheta / 2;
            float theta = (float) Math.toRadians(thetaInDegrees);
            float sineTheta = (float) Math.sin(theta);
            float sineSquaredTheta = (float) Math.pow(sineTheta, 2);
            
            sineSquaredThetas.add(sineSquaredTheta);
        }
        
        return sineSquaredThetas;
    }
    
}
