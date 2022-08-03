/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.experiments;

import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCell;

/**
 *
 * @author Pavilion
 */
public interface XRayAnalysisSolution {
    
    /**
     * Obtains a unit cell as a solution through analysis of a X Ray Analysis experiment.
     * @return PrimitiveUnitCell Unit Cell of appropriate type instantiated with proper lattice constant.
     */
    PrimitiveUnitCell getUnitCell();
    
    /**
     * Used to determine the density of the unit cell of a crystal structure (where lattice itself wont have a meaning without the atoms at lattice positions defined)
     * @return float The density of the crystal structure.
     */
    float getUnitCellDensity();
    
}
