package meizi.serialization;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.ParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.text.*;
import java.util.Date;

public class MyDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = FormatOfDate.formatWithTime;
		String date = jsonparser.getText();
		//System.out.println("In Parser -- " + date);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
