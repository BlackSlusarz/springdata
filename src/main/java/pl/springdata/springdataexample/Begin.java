package pl.springdata.springdataexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

@Component
public class Begin {

    //Injection
    private CarRepository carRepository;

    @Autowired
    public Begin(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){
        //Instancja klasy = Encja
        //Zapis w repozytorium
      Car car = new Car("Hyundai", "i30", Color.WHITE);
        carRepository.save(car);
      Car car1 = new Car("Peugeot", "207", Color.BLACK);
        carRepository.save(car1);
      Car car2 = new Car("Citroen", "C5", Color.GREEN);
        carRepository.save(car2);

        Iterable<Car> all = carRepository.findAllByColor(Color.WHITE);
        all.forEach(System.out::println);
    }
}
