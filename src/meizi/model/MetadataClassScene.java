package meizi.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
 * Metadata
 */
public class MetadataClassScene {
	public MetadataClassScene(){
		
	}

	public String VideoPath;
	public String ParentID;
	public String VendorName;
	public String VendorPath;
	public String Thumbnail;
	public String Keyframes;
	public String UploadTime;
	public String VideoPlayPath;
	public int Visible;
	public int LogID;
	public int MaterialID;

	public SceneClass Scene;
	/*
	@JsonProperty(value = "Scene")
	private SceneClass scene;
	public SceneClass getScene() {
		return scene;
	}
	public void setScene(SceneClass scene) {
		this.scene = scene;
	}
	*/
	
	/*
	 * 4 Shot
	 */

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);
			//json = "{}";
		} catch (JsonParseException e) {  
		    e.printStackTrace();
		} catch (JsonMappingException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
		return json;
	}
}
