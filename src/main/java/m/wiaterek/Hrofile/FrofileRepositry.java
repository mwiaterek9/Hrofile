package m.wiaterek.Hrofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FrofileRepositry {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Material> getAll(){		
	return jdbcTemplate.query("select material_id, material_prefix from material", 
			BeanPropertyRowMapper.newInstance(Material.class));
	}
	
	public Material getByID(int id) {
		return jdbcTemplate.queryForObject("select material_id, material_prefix from material where material.material_id = ?", 
				BeanPropertyRowMapper.newInstance(Material.class), id);
	}

	public int save(List<Material> materials) {
		materials.forEach(material -> jdbcTemplate.update("INSERT into material(material_id, material_prefix) VALUES(?,?)",
				material.getMaterial_id(), material.getMaterial_prefix()));
		
		return 1;
	}

	public int update(Material materials) {
		return jdbcTemplate.update("update material set material_prefix = ? where material.material_id = ?",
				materials.getMaterial_prefix(), materials.getMaterial_id());
	}
}
