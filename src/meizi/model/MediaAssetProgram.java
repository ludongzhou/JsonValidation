package meizi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MediaAssetProgram {
	public MediaAssetProgram(){
	}
	
	@JsonProperty(value = "Metadata")  
	private MetadataClassProgram metadata;
	public MetadataClassProgram getMetadata(){return metadata;}
	public void setMetadata(MetadataClassProgram metadata){this.metadata = metadata;}
	
	/*
	@JsonProperty(value = "Metadata")  
	private MetadataTest metadata;
	public MetadataTest getMetadata(){return metadata;}
	public void setMetadata(MetadataTest metadata){this.metadata = metadata;}
	*/

	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(this);
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
