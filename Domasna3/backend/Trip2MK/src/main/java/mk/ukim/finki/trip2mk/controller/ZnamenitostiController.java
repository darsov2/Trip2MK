package mk.ukim.finki.trip2mk.controller;

import mk.ukim.finki.trip2mk.entities.Znamenitosti;
import mk.ukim.finki.trip2mk.service.ZnamenitostiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/landmarks")
public class ZnamenitostiController {
    private final ZnamenitostiService znamenitostiService;

    public ZnamenitostiController(ZnamenitostiService znamenitostiService) {
        this.znamenitostiService = znamenitostiService;
    }

    @GetMapping()
    public List<Znamenitosti> getAllZnamenitosti()
    {
        return znamenitostiService.findAll();
    }
}
