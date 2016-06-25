package meizi.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*
 * Metadata
 */
public class MetadataClassProgram {
	public MetadataClassProgram(){
		
	}


	public String VideoPath;
	public String ParentID;
	public String VendorName;
	public String VendorPath;
	public String Thumbnail;
	public String Keyframes;



	public ProgramClass Program;
	/*
	@JsonProperty(value = "Program")
	private ProgramClass program;
	public ProgramClass getProgram() {
		return program;
	}
	public void setProgram(ProgramClass program) {
		this.program = program;
	}
	*/
	
	/*
	 * 2 Sequence
	 * 鏁扮粍 锛� yes
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
