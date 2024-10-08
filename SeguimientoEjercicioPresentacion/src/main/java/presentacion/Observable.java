package presentacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex_
 */
public class Observable {
    private List<Observador> observers = new ArrayList<>();

    public void addObserver(Observador o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (Observador o : observers) {
            o.update(); 
            System.out.println("Se notifico");
        }
    }
}
