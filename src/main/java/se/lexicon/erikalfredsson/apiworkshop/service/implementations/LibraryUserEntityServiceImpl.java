package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import se.lexicon.erikalfredsson.apiworkshop.model.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserEntityService;

import java.util.List;

public class LibraryUserEntityServiceImpl implements LibraryUserEntityService {
    @Override
    public LibraryUser create(LibraryUserDTO dto) {
        return null;
    }

    @Override
    public LibraryUser findById(String s) {
        return null;
    }

    @Override
    public List<LibraryUser> findAll() {
        return null;
    }

    @Override
    public LibraryUser update(String s, LibraryUserDTO dto) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public LibraryUser findByEmail(String email) {
        return null;
    }
}
