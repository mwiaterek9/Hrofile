package m.wiaterek.Hrofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public String update(@PathVariable("id") int id, @RequestBody Material updatedMaterial) { // zmien na update wszystkich pol
		Material material = frofileRepositry.getByID(id);	
		
		if (material != null) {
			material.setMaterial_id(id);;
			material.setMaterial_prefix(updatedMaterial.getMaterial_prefix());
			
			frofileRepositry.update(material);
			
			return "Pozycja została zaktualizowana";
		} 
		else {
			return "błąd";
		}
	}	
	
	@PatchMapping("/{id}")
	public String patch(@PathVariable("id") int id, @RequestBody Material updatedMaterial) {
		Material material = frofileRepositry.getByID(id);	
		
		if (material != null) {
			if (updatedMaterial.getMaterial_id() > 0) material.setMaterial_id(id);
			if (updatedMaterial.getMaterial_prefix() != null) material.setMaterial_prefix(updatedMaterial.getMaterial_prefix());
			
			frofileRepositry.update(material);
			
			return "Pozycja została zaktualizowana";
		} else
			return "błąd";
		
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, @RequestBody Material deleteMaterial) {
		Material material = frofileRepositry.getByID(id);
		
		if (material != null) {
			if (deleteMaterial.getMaterial_id() > 0) material.setMaterial_id(id);
			
			frofileRepositry.delete(material);
			
			return "Pozycja została usunięta";
		} else
			return "błąd";
			
	}
}
