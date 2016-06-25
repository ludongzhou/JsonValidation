package meizi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MediaAssetSequence {
	public MediaAssetSequence(){
	}
	
	@JsonProperty(value = "Metadata")  
	private MetadataClassSequence metadata;
	public MetadataClassSequence getMetadata(){return metadata;}
	public void setMetadata(MetadataClassSequence metadata){this.metadata = metadata;}
	
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
