package meizi.model;

import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Metadata
 */
public class MetadataClass {
	public MetadataClass(){
		
	}
	
	
	public String VideoPath;
	public String VideoID;
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
	public List<SequenceClass> Sequence;
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
	public List<SceneClass> Scene;
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
	public List<ShotClass> Shot;
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
