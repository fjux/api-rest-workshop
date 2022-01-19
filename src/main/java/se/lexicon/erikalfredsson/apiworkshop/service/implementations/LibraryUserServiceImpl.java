package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.DTOService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserEntityService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LibraryUserServiceImpl implements LibraryUserService {
    private final LibraryUserEntityService libraryUserEntityService;
    private final DTOService dtoService;

    public LibraryUserServiceImpl(LibraryUserEntityService libraryUserEntityService, DTOService dtoService) {
        this.libraryUserEntityService = libraryUserEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public LibraryUserDTO create(LibraryUserDTO dto) {
        return dtoService.toFullLibraryUserDTO(libraryUserEntityService.create(dto));
    }

    @Override
    public LibraryUserDTO findById(String s) {
        return dtoService.toFullLibraryUserDTO(libraryUserEntityService.findById(s));
    }

    @Override
    public List<LibraryUserDTO> findAll() {
        return libraryUserEntityService.findAll().stream().map(dtoService::toFullLibraryUserDTO).collect(Collectors.toList());
    }

    @Override
    public LibraryUserDTO update(String s, LibraryUserDTO dto) {
        return dtoService.toFullLibraryUserDTO(libraryUserEntityService.update(s, dto));
    }

    @Override
    public boolean delete(String s) {
        return libraryUserEntityService.delete(s);
    }

    @Override
    public LibraryUserDTO findByEmail(String email) {
        return dtoService.toFullLibraryUserDTO(libraryUserEntityService.findByEmail(email));
    }
}
