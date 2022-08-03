/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.experiments.diffraction;

import lk.ac.kln.phys.latix.physics.experiments.XRayAnalysisSolution;
import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCell;

/**
 *
 * @author Pavilion
 */
public class DiffractionSolution implements XRayAnalysisSolution {
    
    private final PrimitiveUnitCell unitCell;
    private final float divisor;
    private final float crystalSubstanceMolarMass;
    
    public DiffractionSolution(PrimitiveUnitCell unitCell, float divisor, float crystalSubstanceMolarMass) {
        this.unitCell = unitCell;
        this.divisor = divisor;
        this.crystalSubstanceMolarMass = crystalSubstanceMolarMass;
    }

    @Override
    public PrimitiveUnitCell getUnitCell() {
        return this.unitCell;
    }
    
    public float getDivisor() {
        return divisor;
    }

    @Override
    public float getUnitCellDensity() {
        return this.getUnitCell().getDensity(this.crystalSubstanceMolarMass);
    }
    
}
