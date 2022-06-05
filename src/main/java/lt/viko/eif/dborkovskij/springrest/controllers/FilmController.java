package lt.viko.eif.dborkovskij.springrest.controllers;

import lt.viko.eif.dborkovskij.springrest.CinemaService;
import lt.viko.eif.dborkovskij.springrest.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private CinemaService cinemaService;

//    public FilmController(CinemaService cinemaService) {
//        this.cinemaService = cinemaService;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> get(@PathVariable int id){
        return new ResponseEntity<>(cinemaService.filmRepository.get(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Film>> getAll(){
        return new ResponseEntity<>(cinemaService.filmRepository.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Film> insert(@RequestBody Film film){
        cinemaService.filmRepository.insert(film);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Film> update(@RequestBody Film film){
        cinemaService.filmRepository.update(film);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> delete(@PathVariable int id){
        cinemaService.filmRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
