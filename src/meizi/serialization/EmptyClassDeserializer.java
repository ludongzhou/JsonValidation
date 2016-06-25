package meizi.serialization;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.ParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;

public class EmptyClassDeserializer extends JsonDeserializer<Object> {
	@Override
	public Object deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
		
		return new Object();

	}
}
