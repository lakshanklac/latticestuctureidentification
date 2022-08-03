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
public class FaceCenteredCubicUnitCell implements PrimitiveUnitCell {
    
    public static final String LATTICE_TYPE = "Face Centered Cubic";
    public static final String LATTICE_TYPE_ABBREVIATED = "FCC";
    
    private final float latticeConstant;
    
    public FaceCenteredCubicUnitCell(float latticeConstant) {
        this.latticeConstant = latticeConstant;
    }
    
    public static float calculateLatticeConstant(float waveLength, List<Float> sineSquaredThetas) {
        return (float) (((waveLength * Math.sqrt(3)) / (2 * Math.sqrt(sineSquaredThetas.get(0)))));
    }
    
    @Override
    public String getType() {
        return FaceCenteredCubicUnitCell.LATTICE_TYPE;
    }

    @Override
    public String getAbbreviatedType() {
        return FaceCenteredCubicUnitCell.LATTICE_TYPE_ABBREVIATED;
    }

    @Override
    public float getLatticeConstant() {
        return this.latticeConstant;
    }

    @Override
    public float getAtomicRadius() {
        return (float) Math.sqrt(2) * this.latticeConstant / 4;
    }

    @Override
    public float getDensity(float molarMass) {
        return (4 * molarMass) / (float) (Math.pow(this.latticeConstant, 3) * MatterConstants.AVEGADROS_NUMBER);
    }
    
}
