package softuni.mobilele.service.impl;

import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.BrandDTO;
import softuni.mobilele.model.dto.ModelDTO;
import softuni.mobilele.model.entity.Model;
import softuni.mobilele.repository.ModelRepository;
import softuni.mobilele.service.BrandService;

import java.util.*;


@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository1) {
        this.modelRepository = modelRepository1;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        // TODO better implementation , sorting !
        Map<String, BrandDTO> brands = new TreeMap<>();

        for (Model model : modelRepository.findAll()) {
            if (!brands.containsKey(model.brand().name())) {
                brands.put(model.brand().name(),
                        new BrandDTO(model.brand().name(),
                                new ArrayList<>()));
            }

            brands.get(model.brand().name()).models().add(
                    new ModelDTO(model.getId(), model.name()));

        }
        return brands.values().stream().toList();
    }
}
