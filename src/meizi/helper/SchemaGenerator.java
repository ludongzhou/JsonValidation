package meizi.helper;

import meizi.model.MediaAsset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.factories.SchemaFactoryWrapper;

public class SchemaGenerator {
	
	public static void main(String[] args){
		String str = pojo2json(MediaAsset.class);
		System.out.println(str);
	}
	/*
	 * JavaClassToJsonSchema
	 */
	public static String pojo2json(Class<?> myClass){
		ObjectMapper mapper = new ObjectMapper();
        SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
        try {
			mapper.acceptJsonFormatVisitor(myClass, visitor);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JsonSchema schema = visitor.finalSchema();
        String schemaStr = "";
        try {
        	schemaStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //System.out.println(schemaStr);
        return schemaStr;
	}

}
