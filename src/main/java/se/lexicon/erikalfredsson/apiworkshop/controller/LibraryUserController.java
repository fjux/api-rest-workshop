package se.lexicon.erikalfredsson.apiworkshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.erikalfredsson.apiworkshop.model.dto.LibraryUserDTO;
import se.lexicon.erikalfredsson.apiworkshop.service.interfaces.LibraryUserService;

import java.util.List;

@RestController
public class LibraryUserController {
    private final LibraryUserService libraryUserService;

    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }
    @GetMapping("/api/v1/libraryuser/{id}")
    public ResponseEntity<LibraryUserDTO> findById(@PathVariable("id") String userId){
        LibraryUserDTO responseBody = libraryUserService.findById(userId);
        return ResponseEntity.ok(responseBody);
    }
    @GetMapping("/api/v1/libraryuser/{email}")
    public ResponseEntity<LibraryUserDTO> findByEmail(@PathVariable("email") String email){
        LibraryUserDTO responseBody = libraryUserService.findByEmail(email);
        return ResponseEntity.ok(responseBody);
    }
    @GetMapping("/api/v1/libraryuser")
    public ResponseEntity<List<LibraryUserDTO>> findAll(){
        List<LibraryUserDTO> responseBody = libraryUserService.findAll();
        return ResponseEntity.ok(responseBody);
    }
    @PostMapping("/api/v1/libraryuser")
    public ResponseEntity<LibraryUserDTO> create(@RequestBody LibraryUserDTO libraryUserDTO){
        LibraryUserDTO libraryUserDTO1 = new LibraryUserDTO(libraryUserDTO.getRegDate(), libraryUserDTO.getName(), libraryUserDTO.getEmail());
        libraryUserDTO1 = libraryUserService.create(libraryUserDTO1);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryUserDTO1);
    }
    @PutMapping("/api/v1/libraryuser/{id}")
    public ResponseEntity<LibraryUserDTO> update(@PathVariable("id") String userId, @RequestBody LibraryUserDTO updatedDTO){
        if (updatedDTO.getUserId().equals(userId)){
            LibraryUserDTO libraryUserDTO = libraryUserService.findById(userId);
            libraryUserDTO.setRegDate(updatedDTO.getRegDate());
            libraryUserDTO.setName(updatedDTO.getName());
            libraryUserDTO.setEmail(updatedDTO.getEmail());
            libraryUserDTO = libraryUserService.update(userId, updatedDTO);
            return ResponseEntity.ok(libraryUserDTO);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/api/v1/libraryuser/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String userId){
        libraryUserService.delete(userId);
        return ResponseEntity.noContent().build();
    }


}
