package addressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingBuddyInfos {
    @Autowired AddressBookRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(AccessingBuddyInfos.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few BuddyInfos
            BuddyInfo bi1 = new BuddyInfo("Rachel", "111-111-1111", "1 abc");
            BuddyInfo bi2 = new BuddyInfo("Simon", "222-222-2222", "2 abc");
            BuddyInfo bi3 = new BuddyInfo("Angie", "333-333-3333", "3 abc");

            repository.save(bi1);
            repository.save(bi2);
            repository.save(bi3);

            AddressBook a = new AddressBook();
            a.addBuddyInfo(bi1);
            a.addBuddyInfo(bi2);
            a.addBuddyInfo(bi3);

            repo.save(a);
            // fetch all BuddyInfos
            System.out.println("BuddyInfos found with findAll():");
            System.out.println("-------------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                System.out.println(buddyInfo.toString());
            }
            System.out.println("");

            // fetch an individual addressBook.BuddyInfo by ID
            BuddyInfo BuddyInfo = repository.findById(1L);
            System.out.println("addressBook.BuddyInfo found with findById(1L):");
            System.out.println("--------------------------------");
            System.out.println(BuddyInfo.toString());
            System.out.println("");

            // fetch BuddyInfos by name
            System.out.println("addressBook.BuddyInfo found with findByLastName('Bauer'):");
            System.out.println("--------------------------------------------");
            repository.findByName("Rachel").forEach(rachel -> {
                System.out.println(rachel.toString());
            });
            System.out.println("");
        };
    }

}