package m.wiaterek.Hrofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material{
	private int material_id;
	private String material_prefix;

	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}

	public String getMaterial_prefix() {
		return material_prefix;
	}

	public void setMaterial_prefix(String material_prefix) {
		this.material_prefix = material_prefix;
	}
}
