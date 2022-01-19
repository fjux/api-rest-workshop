package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.data.LibraryUserRepository;
import se.lexicon.erikalfredsson.apiworkshop.model.entity.LibraryUser;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserEntityService;

import java.util.List;

@Service
@Transactional
public class LibraryUserEntityServiceImpl implements LibraryUserEntityService {
    private final LibraryUserRepository libraryUserRepository;

    public LibraryUserEntityServiceImpl(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Override
    public LibraryUser create(LibraryUserDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("LibraryUserDTO was null");
        }
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setRegDate(dto.getRegDate());
        libraryUser.setName(dto.getName());
        libraryUser.setEmail(dto.getEmail());
        return libraryUserRepository.save(libraryUser);
    }

    @Override
    public LibraryUser findById(String s) {
        return libraryUserRepository.findById(s)
                .orElseThrow(() -> new IllegalStateException("LibraryUser with id " + s + " could not be found"));
    }

    @Override
    public List<LibraryUser> findAll() {
        return libraryUserRepository.findAll();
    }

    @Override
    public LibraryUser update(String s, LibraryUserDTO dto) {
        LibraryUser libraryUser = findById(s);
        libraryUser.setName(dto.getName());
        libraryUser.setRegDate(dto.getRegDate());
        libraryUser.setEmail(dto.getEmail());
        return libraryUserRepository.save(libraryUser);
    }

    @Override
    public boolean delete(String s) {
        libraryUserRepository.deleteById(s);
        return !libraryUserRepository.existsById(s);    }

    @Override
    public LibraryUser findByEmail(String email) {
        return libraryUserRepository.findDistinctByEmailEquals(email);
    }
}
