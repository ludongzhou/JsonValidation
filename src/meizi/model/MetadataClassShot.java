package meizi.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
 * Metadata
 */
public class MetadataClassShot {
	public MetadataClassShot(){
		
	}


	public String VideoPath;
	public String ParentID;
	public String VendorName;
	public String VendorPath;
	public String Thumbnail;
	public String Keyframes;



	/*
	 * 4 Shot
	 */
	public ShotClass Shot;
	/*
	@JsonProperty(value = "Shot")
	private ShotClass shot;
	public ShotClass getShot() {
		return shot;
	}
	public void setShot(ShotClass shot) {
		this.shot = shot;
	}
	*/
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
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
