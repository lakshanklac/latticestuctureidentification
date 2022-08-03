/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ac.kln.phys.latix.validators;

import java.util.List;

/**
 *
 * @author Pavilion
 */
public class FormValidator {
    
    private final List<String> inputs;
    
    public FormValidator(List<String> inputs) {
        this.inputs = inputs;
    }
    
    public boolean isInputNonEmpty(int idx) {
        return !this.inputs.get(idx).isEmpty();
    }
    
    public boolean isAllInputsNonEmpty() {
        for (int i = 0; i < this.inputs.size(); i++) {
            if (!this.isInputNonEmpty(i)) {
                return false;
            }
        }
        
        return true;
    }
    
}
