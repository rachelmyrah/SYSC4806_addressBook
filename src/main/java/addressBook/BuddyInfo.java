package addressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    private String phoneNumber;

    private String address;

    public BuddyInfo(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public BuddyInfo(){
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    @Override
    public String toString(){
        return "\nName: " + this.name +
                "\nPhone Number: " + this.phoneNumber +
                "\nAddress: " + this.address;
    }

    public boolean equals(BuddyInfo b){
        return this.name.equals(b.name)
                && this.phoneNumber.equals(b.phoneNumber)
                && this.address.equals(b.address);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Long getId(){ return id;}

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
