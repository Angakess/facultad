package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//ADAPTER

public class JasonAdapter extends VoorheesExporter{
	
	public String exportar(List<Socio> socios) {
		JSONArray sociosJson = new JSONArray();
		
		socios.stream().forEach(s -> {
			sociosJson.add(this.traducir(s));
		});
		
		return sociosJson.toJSONString();
	}
	
	private JSONObject traducir(Socio socio) {
		JSONObject socioJson = new JSONObject();
		socioJson.put("nombre", socio.getNombre());
		socioJson.put("email", socio.getEmail());
		socioJson.put("legajo", socio.getLegajo());
		return socioJson;
	}
	
}
