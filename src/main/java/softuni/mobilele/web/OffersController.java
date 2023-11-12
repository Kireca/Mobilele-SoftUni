package softuni.mobilele.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.mobilele.model.dto.OfferSummaryDTO;
import softuni.mobilele.service.OfferService;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;

    public OffersController(OfferService offerService) {

        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String all(Model model,
                      @PageableDefault(
                              size = 3,
                              sort = "uuid"
                      ) Pageable pageable) {

        Page<OfferSummaryDTO> allOffers = offerService.getAllOffers(pageable);

        model.addAttribute("offers", allOffers);

        return "offers";
    }


}
