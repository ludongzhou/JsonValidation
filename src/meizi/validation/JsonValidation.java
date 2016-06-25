package meizi.validation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import meizi.model.MediaAsset;
import meizi.model.MediaAssetProgram;
import meizi.model.MediaAssetSequence;
import meizi.model.MediaAssetScene;
import meizi.model.MediaAssetShot;
import meizi.serialization.CustomDate;
import meizi.serialization.CustomDateDeserializer;
import meizi.serialization.CustomDateSerializer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonValidation {
	public final ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args){
		if(args.length!=1){
			System.out.println("the number of parameter should be 1,please see the document");
            return ;
		}
		JsonValidation obj = new JsonValidation();	
		obj.configMapper();
		//String folderPath = "test";
		String folderPath = args[0];
		obj.runFolder(folderPath);
	}
	
	public void runFolder(String filePath){
			 
		getAllFiles(filePath);
	}
	
	public void configMapper(){
		//registe moudle
		SimpleModule simpleMoudle = new SimpleModule();
		simpleMoudle.addDeserializer(CustomDate.class, new CustomDateDeserializer());
		//addSerializer doesn't work, I don't known why.
		//but it doesn't matter since we only need to deserialize Json to Java
		//WRITE_DATES_AS_TIMESTAMPS = false , also doesn't work
		simpleMoudle.addSerializer(CustomDate.class, new CustomDateSerializer());
		//simpleMoudle.addSerializer(new CustomDateSerializer());
		mapper.registerModule(simpleMoudle);
		
		//ACCEPT_SINGLE_VALUE_AS_ARRAY
		//http://wiki.fasterxml.com/JacksonFeaturesDeserialization
		//http://fasterxml.github.io/jackson-databind/javadoc/2.0.2/com/fasterxml/jackson/databind/DeserializationFeature.html#ACCEPT_SINGLE_VALUE_AS_ARRAY
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		//WRITE_DATES_AS_TIMESTAMPS
		//http://wiki.fasterxml.com/JacksonFeaturesSerialization
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
		//SerializationFeature.FAIL_ON_EMPTY_BEANS
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		
		mapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, false);
		
		mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
		
		//Include.NON_NULL
		mapper.setSerializationInclusion(Include.NON_NULL);
		
	}
	
	private void getAllFiles(String filePath){
		int total = 0;
		int valid = 0;
		File root = new File(filePath);
		File[] files = root.listFiles();
		for(File file : files){
			if(file.getName().equals(".DS_Store")) continue;
			else if(file.isDirectory()){
				getAllFiles(file.getAbsolutePath());
			}
			else if(file.getName().endsWith("json")){
				total ++;
				//System.out.println("+++++ " + file.getAbsolutePath() + " +++++");
				
				if(Json2Object(file) == true){
					valid ++;
					//System.out.println("----- " + "Success" + " -----");
				}
				else{
					System.out.println("----- " + "Failure" + " -----");
					System.out.println("+++++ " + file.getAbsolutePath() + " +++++");
				}
				
			}
		}

		
		//System.out.println("Total: " + total);
		//System.out.println("Valid: " + valid);
		
		
	}
	
	private void getFirstFile(String filePath){
		String FileName = "";
		File root = new File(filePath);
		File[] files = root.listFiles();
		for(File file : files){
			if(file.getName().equals(".DS_Store")) continue;
			else if(file.isDirectory()){
				getFirstFile(file.getAbsolutePath());
			}
			else{
				//total ++;
				FileName = file.getAbsolutePath();
				System.out.println("+++++ " + file.getAbsolutePath() + " +++++");
				
				if(Json2Object(file) == true){
					//valid ++;
					System.out.println("----- " + "Not any files Failure" + " -----");
				}
				else{
					System.out.println("----- " + "Failure" +  file.getAbsolutePath() + " -----");
					break;
				}
				
			}
		}
		
		
		
	}
	
	private boolean Json2Object(File jsonFile){
		 try{
			 String type = jsonFile.getName();
             String json = "";
             if (type.startsWith("Video")){
                 MediaAsset mediaAsset = mapper.readValue(jsonFile, MediaAsset.class);
                 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaAsset);
             }
             else if (type.startsWith("Program")){
                 MediaAssetProgram mediaAsset = mapper.readValue(jsonFile, MediaAssetProgram.class);
                 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaAsset);
             }
             else if (type.startsWith("Sequence")){
                 MediaAssetSequence mediaAsset = mapper.readValue(jsonFile, MediaAssetSequence.class);
                 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaAsset);
             }
             else if (type.startsWith("Scene")){
                 MediaAssetScene mediaAsset = mapper.readValue(jsonFile, MediaAssetScene.class);
                 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaAsset);
             }
             else if (type.startsWith("Shot")){
                 MediaAssetShot mediaAsset = mapper.readValue(jsonFile, MediaAssetShot.class);
                 json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mediaAsset);
             }
             FileWriter writer = new FileWriter(jsonFile);
             writer.write(json);
             writer.flush();
			 writer.close();
			 return true;
		 } catch (JsonParseException e) {  
			 System.out.println("JsonParseException: " + jsonFile.getAbsolutePath());
		     e.printStackTrace();
		 } catch (JsonMappingException e) {  
			 System.out.println("JsonMappingException: " + jsonFile.getAbsolutePath());
		     e.printStackTrace();  
		 } catch (IOException e) {  
			 System.out.println("IOException: " + jsonFile.getAbsolutePath());
		     e.printStackTrace();  
		 }
		 return false;
	}

}
