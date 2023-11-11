package softuni.mobilele.service.impl;

import org.springframework.stereotype.Service;
import softuni.mobilele.model.dto.BrandDTO;
import softuni.mobilele.model.dto.ModelDTO;
import softuni.mobilele.repository.BrandRepository;
import softuni.mobilele.service.BrandService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        return brandRepository.findAll().stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        brand.getModelEntities().stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());
    }
}
