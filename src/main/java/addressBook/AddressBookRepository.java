package addressBook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBook", path="addressBook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Integer> {
    AddressBook findById(int id);
}
