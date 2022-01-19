package se.lexicon.erikalfredsson.apiworkshop.service.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.BookDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.DTOService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookEntityService;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookEntityService bookEntityService;
    private final DTOService dtoService;

    public BookServiceImpl(BookEntityService bookEntityService, DTOService dtoService) {
        this.bookEntityService = bookEntityService;
        this.dtoService = dtoService;
    }

    @Override
    public List<BookDTO> findByReserved(boolean reserved) {
        return bookEntityService.findByReserved(reserved).stream().map(dtoService::toFullBookDTO).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findByAvailable(boolean available) {
        return bookEntityService.findByAvailable(available).stream().map(dtoService::toFullBookDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO findByTitle(String title) {
        return dtoService.toFullBookDTO(bookEntityService.findByTitle(title));
    }

    @Override
    public BookDTO create(BookDTO dto) {
        return dtoService.toFullBookDTO(bookEntityService.create(dto));
    }

    @Override
    public BookDTO findById(String s) {
        return dtoService.toFullBookDTO(bookEntityService.findById(s));
    }

    @Override
    public List<BookDTO> findAll() {
        return bookEntityService.findAll().stream().map(dtoService::toFullBookDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO update(String s, BookDTO dto) {
        return dtoService.toFullBookDTO(bookEntityService.update(s, dto));
    }

    @Override
    public boolean delete(String s) {
        return bookEntityService.delete(s);
    }
}
