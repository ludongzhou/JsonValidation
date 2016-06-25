package meizi.serialization;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.ParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.text.*;
import java.util.Date;

public class MyTimeDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SS");
		
		SimpleDateFormat format = FormatOfDate.formatOnlyTime;
		
		String date = jsonparser.getText();
		
		try {
			Date d = format.parse(date);
			return d;
			
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
