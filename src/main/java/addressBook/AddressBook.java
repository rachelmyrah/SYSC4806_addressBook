package addressBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfos;

    public static void main(String[] args){
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddyInfo("Rachel",
                "111-111-1111",
                "1 Abc Rd.");
        addressBook.addBuddyInfo("Simon",
                "222-222-2222",
                "2 Def Rd.");
        addressBook.addBuddyInfo("Angie",
                "333-333-3333",
                "3 Ghi Rd.");
        System.out.println(addressBook.toString());
    }

    public AddressBook(int id) {
        this.buddyInfos = new ArrayList<BuddyInfo>();
        this.id = id;
    }

    public AddressBook(){
        this.buddyInfos = new ArrayList<BuddyInfo>();
        this.id = 1;
    }

    public void addBuddyInfo(BuddyInfo buddyInfo){
        this.buddyInfos.add(buddyInfo);
    }

    public void addBuddyInfo(String name, String phoneNumber, String address){
        this.buddyInfos.add(new BuddyInfo(name, phoneNumber, address));
    }

    public int getSize(){
        return this.buddyInfos.size();
    }

    public String toString(){
        String string = "";
        for (BuddyInfo buddyInfo : this.buddyInfos){
            string += buddyInfo.toString() + "\n";
        }
        return string;
    }

    public int getId(){ return this.id; }

    public List<BuddyInfo> getBuddyInfos(){
        return this.buddyInfos;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBuddyInfos(List<BuddyInfo> buddyInfos){
        this.buddyInfos = buddyInfos;
    }
}
