package classesandinterfaces;

import java.util.ArrayList;
import static classesandinterfaces.Tools.*;

public abstract class ActionFigure implements Mobile {
    static int count = 0;
    final private String actor;
    public ActionFigure(String _actor) {
        this.actor=_actor;
        ++count;
    }
    public String getActor() { return this.actor; }
    public abstract void moveTo(String location);
    public abstract String getLocation();
    
    void add(Explicative explicative) {
        explicatives.add(explicative);
    }
    void remove(Explicative explicative) {
        explicatives.remove(explicative);
    }
    void taunt(ActionFigure target) {
        if (explicatives.size() > 0) {
            String message = rand(explicatives).taunt(target.getActor());
            System.out.println(message);
        }
    }
    ArrayList<Explicative> explicatives = 
            new ArrayList<Explicative>();
}
