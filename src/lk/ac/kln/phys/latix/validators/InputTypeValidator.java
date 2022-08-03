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
public class InputTypeValidator {
    
    private final List<String> inputs;
    
    public InputTypeValidator(List<String> inputs) {
        this.inputs = inputs;
    }
    
    public boolean isInputNumber(int idx) {
        try {
            float a = Float.parseFloat(inputs.get(idx));
            
            return true;
        }
        
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
    
    public boolean isAllInputsNumbers() {
        for (int i = 0; i < this.inputs.size(); i++) {
            if (!this.isInputNumber(i)) {
                return false;
            }
        }
        
        return true;
    }
    
}
