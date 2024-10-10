/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eliminarEjercicioDiario;

/**
 *
 * @author alex_
 */
public class FEliminarEjercicioDiario implements IEliminarEjercicioDiario{

    private CEliminarEjercicioDiario control;

    public FEliminarEjercicioDiario() {
        this.control = new CEliminarEjercicioDiario();
    }
    
    @Override
    public boolean eliminarEjercicioDiario(Long id) {
        return control.eliminarEjercicioDiario(id);
    }
    
}
