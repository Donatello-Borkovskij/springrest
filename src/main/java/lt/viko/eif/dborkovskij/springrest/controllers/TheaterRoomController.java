package lt.viko.eif.dborkovskij.springrest.controllers;

import lt.viko.eif.dborkovskij.springrest.CinemaService;
import lt.viko.eif.dborkovskij.springrest.model.TheaterRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaterRoom")
public class TheaterRoomController {
    @Autowired
    private CinemaService cinemaService;

//    public TheaterRoomController(CinemaService cinemaService) {
//        this.cinemaService = cinemaService;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TheaterRoom> get(@PathVariable int id){
        return new ResponseEntity<>(cinemaService.theaterRoomRepository.get(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TheaterRoom>> getAll(){
        return new ResponseEntity<>(cinemaService.theaterRoomRepository.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TheaterRoom> insert(@RequestBody TheaterRoom theaterRoom){
        cinemaService.theaterRoomRepository.insert(theaterRoom);
        return new ResponseEntity<>(theaterRoom, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<TheaterRoom> update(@RequestBody TheaterRoom theaterRoom){
        cinemaService.theaterRoomRepository.update(theaterRoom);
        return new ResponseEntity<>(theaterRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TheaterRoom> delete(@PathVariable int id){
        cinemaService.theaterRoomRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
