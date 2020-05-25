package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DemoController {

    private final DemoRepository demoRepository;

    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/data")
    public List<DemoModel> getAllData() throws DemoModelNotFoundException {
        //demoRepository.findById(99).orElseThrow(DemoModelNotFoundException::new);
        return demoRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @GetMapping("/data/{id}")
    public DemoModel getData(@PathVariable int id) {
        return  demoRepository.findById(id).orElse(null);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/data")
    public DemoModel postData(@RequestBody DemoModel demoModel) {
        //demoRepository.findById(99).orElseThrow(DemoModelNotFoundException::new);
        return demoRepository.save(demoModel);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PutMapping("/data")
    public DemoModel putData(@RequestBody DemoModel demoModel) {
        demoRepository.findById(demoModel.getId()).orElseThrow();
        return demoRepository.save(demoModel);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @DeleteMapping("/data/{id}")
    public void deleteData(@PathVariable int id) {
        DemoModel demoModel = demoRepository.findById(id).orElseThrow();
        demoRepository.delete(demoModel);
    }

    private DemoModel createData() {
        DemoModel demoModel = new DemoModel();
        demoModel.setName("3");
        return demoModel;
    }
}
