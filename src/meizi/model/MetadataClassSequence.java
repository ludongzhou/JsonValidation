package meizi.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
 * Metadata
 */
public class MetadataClassSequence {
	public MetadataClassSequence(){
		
	}


	public String VideoPath;
	public String ParentID;
	public String VendorName;
	public String VendorPath;
	public String Thumbnail;
	public String Keyframes;




	public SequenceClass Sequence;
	/*
	@JsonProperty(value = "Sequence")
	private SequenceClass sequence;
	public SequenceClass getSequence() {
		return sequence;
	}
	public void setSequence(SequenceClass sequence) {
		this.sequence = sequence;
	}
	*/
	
	/*
	 * 3 Scene
	 * 鏁扮粍 ? yes
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
