package dev.startup.runner.run;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository repo;

    public RunController(RunRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Run> findAll(){
      return   repo.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void create(@Valid @RequestBody Run run){
        repo.create(run);
    }


    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @PutMapping("{id}")
    void update(@Valid  @RequestBody Run run , @PathVariable Integer id){
        repo.update(run,id);
    }

    @ResponseStatus(HttpStatus.LOOP_DETECTED)
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        repo.delete(id);
    }


    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = repo.findById(id);

        if (run.isPresent()){
            return  run.get();
        }else{
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/home")
    String home(){
        return "Runner Controller HOME";
    }


}
