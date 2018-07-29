package rocks.raccoon.terrarium.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rocks.raccoon.terrarium.model.Unit;
import rocks.raccoon.terrarium.repository.UnitRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/units")
public class UnitsController {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitsController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @GetMapping
    public List<Unit> list() {
        return unitRepository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Unit unit) {
        unitRepository.save(unit);
    }

    @GetMapping("/{id}")
    public Unit get(@PathVariable("id") long id) {
        return unitRepository.getOne(id);
    }
}
