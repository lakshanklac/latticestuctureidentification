/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.experiments.diffraction;

import java.util.List;
import lk.ac.kln.phys.latix.physics.experiments.XRayAnalysisExperiment;
import lk.ac.kln.phys.latix.physics.experiments.XRayAnalysisSolution;
import lk.ac.kln.phys.latix.physics.unitcells.PrimitiveUnitCell;

/**
 *
 * @author Pavilion
 */
public class DiffractionExperiment implements XRayAnalysisExperiment {
    
    /* Wave Length of the Light used for the experiment */
    private final float waveLength;
    /* Molar mass of the substance on which the experiment is carried out (for example, the molar mass of the powder in powder method */
    private final float molarMass;
    /* Experimental observations of two theta values */
    private final List<Float> twoThetas;
    
    public DiffractionExperiment(float waveLength, float molarMass, List<Float> twoThetas) {
        this.waveLength = waveLength;
        this.molarMass = molarMass;
        this.twoThetas = twoThetas;
    }

    @Override
    public XRayAnalysisSolution getSolution() {
        DiffractionDataPrimitiveCellFinder finder = new DiffractionDataPrimitiveCellFinder(waveLength, twoThetas);
        PrimitiveUnitCell unitCell = finder.getUnitCell();
        
        DiffractionDataMetadataDeducer deducer = new DiffractionDataMetadataDeducer(unitCell, this.twoThetas);
        float divisor = deducer.getDivisor();
        
        return new DiffractionSolution(unitCell, divisor, this.molarMass);
    }
    
}
