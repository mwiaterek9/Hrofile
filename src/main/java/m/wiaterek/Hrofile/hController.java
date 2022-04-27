package m.wiaterek.Hrofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Materials")
public class hController {
	
	@Autowired
	FrofileRepositry frofileRepositry;
	
	@GetMapping("/")
	public List<Material> getAll(){
		return frofileRepositry.getAll();
	}
	
	@GetMapping("/{id}")
	public Material getById(@PathVariable("id") int id) {
		return frofileRepositry.getByID(id);
	}
	
	@PostMapping("/")
	public int add(@RequestBody List<Material> material) {		
		return frofileRepositry.save(material);
	}
	
	@PutMapping("/{id}")
	public int update(@PathVariable("id"), int id, @RequestBody Material updatedMaterial) {
		Material material = frofileRepositry.getByID(id);		
	}	
}
