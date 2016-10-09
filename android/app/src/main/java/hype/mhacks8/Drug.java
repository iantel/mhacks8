package hype.mhacks8;

/**
 * Created by Ian on 2016-10-09.
 */
public class Drug {
    private String name;
    private String dosage;
    private String schedule;

    public Drug(String name, String dosage, String schedule){
        this.name = name;
        this.dosage = dosage;
        this.schedule = schedule;
    }

    public String getDosage() {
        return dosage;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }
}
