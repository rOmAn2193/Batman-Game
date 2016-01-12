public class Gotham {


    public static final String LOCATION_CITY_HALL = "City Hall";
    public static final String LOCATION_BANK = "Gotham Global Bank";
    public static final String LOCATION_CAVE = "Bat Cave";
    public static final String LOCATION_TOWER = "Wayne Tower";
    public static final String[] LOCATIONS
            = {LOCATION_CITY_HALL, LOCATION_BANK,
                LOCATION_CAVE, LOCATION_TOWER};
    
    public static final String[] FIRST_NAMES = { "Alice", "Bob", "Nancy" };
    public static final String[] LAST_NAMES = { "Smith", "Jones" };
    public static String getRandomName() {
        return rand(FIRST_NAMES)+" "+rand(LAST_NAMES);
    }
    
    public static Criminal getRandomCriminal() {
        return new Criminal(getRandomName());
    }

    public static String getRandomLocation() {
        return rand(LOCATIONS);
    }

    void go() {
        Batman bruce = new Batman("Christian Bale");
        
        bruce.add(new CombatBoots());
        Criminal joker = new Criminal("Heath Ledger");
        joker.add((at)->at + "'s armpits are flea infested.");
        joker.add((at)->at + "'s face looks like an old boot.");

        Criminal bane = new Criminal("Tom Hardy");
        bane.add(new Explicative() {
            @Override
            public String taunt(String subject) {
                return subject + "'s daddy wears socks and sandles.";
            }
        });

        ArrayList<Mobile> moveables = new ArrayList<Mobile>();
        moveables.add(bruce);
        moveables.add(joker);
/*        moveables.add(bane); */
        moveables.add(bruce.getBatmobile());

        for (int i=0; i<1; ++i) {
            moveables.add(Gotham.getRandomCriminal());
        }
        
        moveables.add(new Criminal("boot stomper") {
           @Override
           public void moveTo(String _location) {
               if (!this.getLocation().equals(_location)) {
                System.out.println(getActor() + " stomp stomp to " + _location);
                this.location = _location;
               }
           }
        });
        
        for (int day = 0; day < 3; ++day) {
            System.out.println("Day " + day);

            // everything moveable (that is not a batmobile) moves
            for (Mobile m : moveables) {
                if (!(m instanceof Batmobile)) {
                    m.moveTo(Gotham.getRandomLocation());
                }
            }

            // batman fights criminals
            for (Mobile m : moveables) {
                if (m instanceof Criminal) {
                  bruce.fightCriminal((Criminal)m);
                }
            }

        }
    }

}
