package se.lexicon.erikalfredsson.apiworkshop.service.interfaces;

import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.GenericCRUD;

public interface LibraryUserService extends GenericCRUD<LibraryUserDTO, LibraryUserDTO, String> {
    LibraryUserDTO findByEmail(String email);
}
