/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ac.kln.phys.latix.physics.unitcells;

/**
 *
 * @author Pavilion
 */
public interface PrimitiveUnitCell {
    
    /**
     * Used to obtain the type of the unit cell
     * @return String type of the unit cell such as Simple Cubic, Body Centered Cubic
     */
    String getType();
    
    /**
     * Used to obtain the type of the unit cell in the abbreviated form.
     * @return String Type of the unit cell in the abbreviated form.
     */
    String getAbbreviatedType();
    
    /**
     * Returns the lattice constant for the unit cell.
     * @return float Lattice constant without rounding up in Angstroms.
     */
    float getLatticeConstant();
    
    /**
     * Provides the atomic radius for the atoms (molecules) in the lattice points.
     * @return float Atomic radius of atoms in Angstroms.
     */
    float getAtomicRadius();
    
    /**
     * Provides the density of the lattice.
     * @param molarMass float Molar mass of the substance(atoms/molecules) of the crystal structure.
     * @return float Density of the lattice in g/(cm^3)
     */
    float getDensity(float molarMass);
    
}
