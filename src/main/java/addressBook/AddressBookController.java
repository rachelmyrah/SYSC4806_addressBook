package addressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository repo;

    @GetMapping("/book")
    public String getAddressBook(@RequestParam(name = "id", required = true) int id, Model model) {
        AddressBook addressBook = repo.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}