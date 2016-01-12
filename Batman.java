package classesandinterfaces;

public class Batman extends ActionFigure {
    public Batman(String _actor)
    {
        super(_actor);
    }

    private Batmobile batmobile = new Batmobile();
    public Batmobile getBatmobile() { return this.batmobile; }
    public void setBatmobile(Batmobile _batmobile) 
    {
        this.batmobile=_batmobile;
    }
    
    @Override
    public String getLocation() {
        return this.batmobile.getLocation();
    }
    
    @Override
    public void moveTo(String location) {
        this.batmobile.driveTo(location);
    }
    
    public void fightCriminal(Criminal criminal)
    {
        this.batmobile.driveTo(criminal.getLocation());
        criminal.taunt(this);
        this.sock(criminal);
    }
    
    public void sock(Criminal criminal) 
    {
        taunt(criminal);
        System.out.println(this.getActor() + " POW!!!");
        System.out.println(criminal.getActor() + " UGH!");
    }
}
