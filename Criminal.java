package classesandinterfaces;

public class Criminal extends ActionFigure {

    Criminal(String _actor) {
        super(_actor);
        location = this.getActor() + "'s lair";
    }

    protected String location;

    void sneakTo(String _location) {
        if (!this.location.equals(_location)) {
            System.out.println(this.getActor()
                    + ": squeak squeak squeak to "
                    + _location);
            this.location = _location;
        }
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public void moveTo(String location) {
        this.sneakTo(location);
    }
}
