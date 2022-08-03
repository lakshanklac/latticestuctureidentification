/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.unitcells;

/**
 *
 * @author Pavilion
 */
public class PrimitiveUnitCellsUtils {
    
    public static boolean isSimpleCubicUnitCell(PrimitiveUnitCell unitCell) {
        return unitCell.getType().equals(SimpleCubicUnitCell.LATTICE_TYPE);
    }
    
    public static boolean isBodyCenteredCubicUnitCell(PrimitiveUnitCell unitCell) {
        return unitCell.getType().equals(BodyCenteredCubicUnitCell.LATTICE_TYPE);
    }
    
    public static boolean isFaceCenteredCubicUnitCell(PrimitiveUnitCell unitCell) {
        return unitCell.getType().equals(FaceCenteredCubicUnitCell.LATTICE_TYPE);
    }
    
    public static boolean isUndeterminedUnitCell(PrimitiveUnitCell unitCell) {
        return !PrimitiveUnitCellsUtils.isSimpleCubicUnitCell(unitCell) && !PrimitiveUnitCellsUtils.isBodyCenteredCubicUnitCell(unitCell) && !PrimitiveUnitCellsUtils.isFaceCenteredCubicUnitCell(unitCell);
    }
    
}
