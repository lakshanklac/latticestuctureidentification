/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.experiments.diffraction;

import java.util.List;
import lk.ac.kln.phys.latix.math.TrigonometricFunctions;
import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCell;
import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCellsUtils;

/**
 *
 * @author Pavilion
 */
public class DiffractionDataMetadataDeducer {
    
    private final PrimitiveUnitCell unitCell;
    private final List<Float> twoThetas;
    
    public DiffractionDataMetadataDeducer(PrimitiveUnitCell unitCell, List<Float> twoThetas) {
        this.unitCell = unitCell;
        this.twoThetas = twoThetas;
    }
    
    public float getDivisor() {
        List<Float> sineSquaredThetas = TrigonometricFunctions.sineSquaredThetaFromTwoTheta(this.twoThetas);
        
        if (PrimitiveUnitCellsUtils.isSimpleCubicUnitCell(unitCell)) {
            return sineSquaredThetas.get(0);
        }
        else if (PrimitiveUnitCellsUtils.isBodyCenteredCubicUnitCell(unitCell)) {
            return sineSquaredThetas.get(0) / 2;
        }
        else if (PrimitiveUnitCellsUtils.isFaceCenteredCubicUnitCell(unitCell)) {
            return sineSquaredThetas.get(0) / 3;
        }
        else {
            return 0.0f;
        }
    }
    
}
