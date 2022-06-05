package lt.viko.eif.dborkovskij.springrest;

import lt.viko.eif.dborkovskij.springrest.model.Cinema;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CinemaService {
    private Cinema cinema = new Cinema(1);//CreateCinema.generateCinema();

    public FilmRepository filmRepository = new FilmRepository(cinema);
    public TheaterRoomRepository theaterRoomRepository= new TheaterRoomRepository(cinema);

    @Bean
    public static Cinema cinema() {
        return new Cinema();
    };
}
