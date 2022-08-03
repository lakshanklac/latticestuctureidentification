/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.unitcells;

import java.util.List;
import lk.ac.kln.phys.latix.physics.constants.MatterConstants;

/**
 *
 * @author Pavilion
 */
public class SimpleCubicUnitCell implements PrimitiveUnitCell {
    
    public static final String LATTICE_TYPE = "Simple Cubic";
    public static final String LATTICE_TYPE_ABBREVIATED = "SC";
    
    private final float latticeConstant;
    
    public SimpleCubicUnitCell(float latticeConstant) {
        this.latticeConstant = latticeConstant;
    }
    
    public static float calculateLatticeConstant(float waveLength, List<Float> sineSquaredThetas) {
        return (float) ((waveLength) / (2 * Math.sqrt(sineSquaredThetas.get(0))));
    }

    @Override
    public String getType() {
        return SimpleCubicUnitCell.LATTICE_TYPE;
    }

    @Override
    public String getAbbreviatedType() {
        return SimpleCubicUnitCell.LATTICE_TYPE_ABBREVIATED;
    }

    @Override
    public float getLatticeConstant() {
        return this.latticeConstant;
    }

    @Override
    public float getAtomicRadius() {
        return this.latticeConstant / 2;
    }

    @Override
    public float getDensity(float molarMass) {
        return molarMass / (float) (Math.pow(this.latticeConstant, 3) * MatterConstants.AVEGADROS_NUMBER);
    }
    
}
