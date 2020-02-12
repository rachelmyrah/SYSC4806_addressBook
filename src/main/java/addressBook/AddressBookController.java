package addressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository repo;

    @GetMapping("/book")
    public String getAddressBook(@RequestParam(name = "id") int id, Model model) {
        AddressBook addressBook = repo.findById(id);
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addressBook";
    }

    @PostMapping("/book")
    public String addBuddyInfo(@RequestParam(name = "id") int id, @ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook addressBook = repo.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}