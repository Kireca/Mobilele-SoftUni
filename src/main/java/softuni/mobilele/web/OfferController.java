package softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.service.BrandService;
import softuni.mobilele.service.OfferService;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }


    @GetMapping("/all")
    public String all() {
        return "offers";
    }


    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }


    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping()
    public String add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);
        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }
}
