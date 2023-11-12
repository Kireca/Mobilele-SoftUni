package softuni.mobilele.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.mobilele.model.dto.CreateOfferDTO;
import softuni.mobilele.model.dto.OfferDetailDTO;
import softuni.mobilele.model.enums.EngineEnum;
import softuni.mobilele.service.BrandService;
import softuni.mobilele.service.OfferService;
import softuni.mobilele.service.exceptions.ObjectNotFoundException;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {


    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("engines")
    public EngineEnum[] engines() {
        return EngineEnum.values();
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new CreateOfferDTO());

        }

        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes rAtt) {


        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }


        UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/" + newOfferUUID;
    }

    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid, Model model) {


        OfferDetailDTO offerDetailDTO = offerService.getOfferDetail(uuid)
                .orElseThrow(() -> new ObjectNotFoundException("Offer with uuid " + uuid + " was not found!"));

        model.addAttribute("offerDetail", offerDetailDTO);

        return "details";
    }


    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable("uuid") UUID uuid, Model model) {


        offerService.deleteOffer(uuid);

        return "redirect:/offers/all";


    }


}
