/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.experiments.diffraction;

import java.util.ArrayList;
import java.util.List;
import lk.ac.kln.phys.latix.math.TrigonometricFunctions;
import lk.ac.kln.phys.latix.physics.unitcells.BodyCenteredCubicUnitCell;
import lk.ac.kln.phys.latix.physics.unitcells.FaceCenteredCubicUnitCell;
import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCell;
import lk.ac.kln.phys.latix.physics.unitcells.SimpleCubicUnitCell;
import lk.ac.kln.phys.latix.physics.unitcells.UndeterminedPrimitiveUnitCell;

/**
 *
 * @author Pavilion
 */
public class DiffractionDataPrimitiveCellFinder {
    
    private final float waveLength;
    private final List<Float> twoThetas;
    
    public DiffractionDataPrimitiveCellFinder(float waveLength, List<Float> twoThetas) {
        this.waveLength = waveLength;
        this.twoThetas = twoThetas;
    }
    
    private boolean checkForSimpleCubic(List<Float> sineSquaredTheta) {
        List<Integer> simplifierSCT = new ArrayList<>();
        
        // Reduce every value to the nearest integer after dividing by the first entry.
        for (Float sct : sineSquaredTheta) {
            int ssct = (int) Math.round(sct / sineSquaredTheta.get(0));
            simplifierSCT.add(ssct);
        }
        
        // Check whether the 7th entry is seven and if so multiply everything by 2
        if (simplifierSCT.get(6) == 7) {
            for (int i = 0; i < simplifierSCT.size(); i++) {
                int ssct = simplifierSCT.get(i) * 2;
                simplifierSCT.set(i, ssct);
            }
        }
        
        return simplifierSCT.get(0) == 1 && simplifierSCT.get(1) == 2 && simplifierSCT.get(2) == 3;
    }
    
    private boolean checkForBodyCenteredCubic(List<Float> sineSquaredTheta) {
        List<Integer> simplifierSCT = new ArrayList<>();
        
        // Reduce every value to the nearest integer after multiplying by 2 and dividing by the first entry.
        for (Float sct : sineSquaredTheta) {
            int ssct = (int) Math.round(2 * sct / sineSquaredTheta.get(0));
            simplifierSCT.add(ssct);
        }
        
        return simplifierSCT.get(0) == 2 && simplifierSCT.get(1) == 4 && simplifierSCT.get(2) == 6;
    }
    
    private boolean checkForFaceCenteredCubic(List<Float> sineSquaredTheta) {
        List<Integer> simplifierSCT = new ArrayList<>();
        
        // Reduce every value to the nearest integer after multiplying by 3 and dividing by the first entry.
        for (Float sct : sineSquaredTheta) {
            int ssct = (int) Math.round(3 * sct / sineSquaredTheta.get(0));
            simplifierSCT.add(ssct);
        }
        
        return simplifierSCT.get(0) == 3 && simplifierSCT.get(1) == 4 && simplifierSCT.get(2) == 8;
    }
    
    public PrimitiveUnitCell getUnitCell() {
        List<Float> sineSquaredThetas = TrigonometricFunctions.sineSquaredThetaFromTwoTheta(this.twoThetas);
        
        if (this.checkForSimpleCubic(sineSquaredThetas)) {
            float latticeConstant = SimpleCubicUnitCell.calculateLatticeConstant(waveLength, sineSquaredThetas);
            return new SimpleCubicUnitCell(latticeConstant);
        }
        else if (this.checkForBodyCenteredCubic(sineSquaredThetas)) {
            float latticeConstant = BodyCenteredCubicUnitCell.calculateLatticeConstant(waveLength, sineSquaredThetas);
            return new BodyCenteredCubicUnitCell(latticeConstant);
        }
        else if (this.checkForFaceCenteredCubic(sineSquaredThetas)) {
            float latticeConstant = FaceCenteredCubicUnitCell.calculateLatticeConstant(waveLength, sineSquaredThetas);
            return new FaceCenteredCubicUnitCell(latticeConstant);
        }
        else {
            return new UndeterminedPrimitiveUnitCell();
        }
    }
    
}
