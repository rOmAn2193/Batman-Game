package classesandinterfaces;

public class CombatBoots implements Explicative {

    @Override
    public String taunt(String subject) {
        return "I heard " + 
                subject + "'s momma wears combat boots.";
    } 
}
