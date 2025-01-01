package org.marouanedbibih.car.modules.car;

import java.util.List;

import org.marouanedbibih.car.modules.client.ClientDTO;
import org.marouanedbibih.car.modules.client.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final CarMapper mapper;
    // private final ClientService clientService;
    private final RestTemplate restTemplate;

    // TODO: Chnage the RuntimeException to a more specific exception
    // (BussinessException)

    // Create a new car
    public CarDTO create(CarREQ req) {
        // ClientDTO client = clientService.findById(req.clientId());
        ClientDTO client = restTemplate.getForObject("http://client-service/api/client/" + req.clientId(), ClientDTO.class);

        if (client == null) {
            throw new RuntimeException("Client not found");
        }
        Car car = mapper.toEntity(req);
        car.setClientId(client.getId());
        car = repository.save(car);
        CarDTO carDTO = mapper.toDTO(car);
        carDTO.setClient(client);
        return carDTO;
    }

    // Find a car by id
    public CarDTO findById(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        // ClientDTO client = clientService.findById(car.getClientId());
        ClientDTO client = restTemplate.getForObject("http://client-service/api/client/" + car.getClientId(), ClientDTO.class);
        CarDTO carDTO = mapper.toDTO(car);
        carDTO.setClient(client);
        return carDTO;
    }

    // Update a car
    public CarDTO update(Long id, CarREQ req) {
        Car car = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (!car.getClientId().equals(req.clientId())) {
            // ClientDTO client = clientService.findById(req.clientId());
            ClientDTO client = restTemplate.getForObject("http://client-service/api/client/" + req.clientId(), ClientDTO.class);
            if (client == null) {
                throw new RuntimeException("Client not found");
            }
            car.setClientId(client.getId());
        }

        car.setMarque(req.marque());
        car.setMatricule(req.matricule());
        car.setModel(req.model());

        car = repository.save(car);

        CarDTO carDTO = mapper.toDTO(car);
        carDTO.setClient(restTemplate.getForObject("http://client-service/api/client/" + req.clientId(), ClientDTO.class));
        return carDTO;
    }

    // Delete a car
    public void delete(Long id) {
        repository.findById(id).ifPresentOrElse(
                car -> repository.deleteById(id), // Action if the car is found
                () -> {
                    throw new RuntimeException("Car not found");
                } // Action if the car is not found
        );
    }

    // Get all cars
    public List<CarDTO> getAll() {
        return repository.findAll().stream()
                .map(car -> {
                    CarDTO carDTO = mapper.toDTO(car);
                    carDTO.setClient(restTemplate.getForObject("http://client-service/api/client/" + car.getClientId(), ClientDTO.class));
                    return carDTO;
                })
                .toList();
    }

    // TODO: Add the method to fetch all cars by pagination

}
