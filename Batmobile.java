package classesandinterfaces;

public class Batmobile implements Mobile {
    private String location;
    public Batmobile() {
        location = Gotham.LOCATION_CAVE;
    }
    
    
    public void driveTo(String _location) {
        if (!this.location.equals(_location)) {
            System.out.println("batmobile races from " + 
                    this.location + 
                    ", and vrooms to " + _location + "!!! URCH!!!!");
            this.location=_location;
        }
    }
    
    @Override
    public void moveTo(String location) {
        driveTo(location);
    }
    
    @Override
    public String getLocation() { return this.location; }
}
