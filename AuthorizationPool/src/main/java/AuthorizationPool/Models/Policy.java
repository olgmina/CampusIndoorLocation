package AuthorizationPool.Models;

public class Policy {
    private int location;
    private int date;
    private int staff;
    private int equipment;

    public Policy() {
    }

    public Policy(int location, int date, int staff, int equipment){
        this.location = location;
        this.date = date;
        this.staff = staff;
        this.equipment = equipment;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

}
