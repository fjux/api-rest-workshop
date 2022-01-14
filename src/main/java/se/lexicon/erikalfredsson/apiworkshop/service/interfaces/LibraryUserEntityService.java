package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;

public interface LibraryUserEntityService extends GenericCRUD<LibraryUser, LibraryUserDTO, String>{
    LibraryUser findByEmail(String email);
}
