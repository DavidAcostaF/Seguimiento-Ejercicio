/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eliminarEjercicio;

/**
 *
 * @author alex_
 */
public class FEliminarEjercicio implements IEliminarEjercicio{

    private CEliminarEjercicio control;

    public FEliminarEjercicio() {
        this.control = new CEliminarEjercicio();
    }
    
    @Override
    public boolean eliminarEjercicio(Long id) {
        return control.eliminarEjercicio(id);
    }
    
}
