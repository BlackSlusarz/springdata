package pl.springdata.springdataexample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Zapis, odczyt danych
//Kazda encja wymaga swoje repozytorium
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    //metody do wyciagania danych
    //Znajdz wszystkie po kolorze
    List<Car> findAllByColor(Color color);
}
