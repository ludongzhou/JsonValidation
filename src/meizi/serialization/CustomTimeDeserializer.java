package meizi.serialization;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.ParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.text.*;
import java.util.Date;

public class CustomTimeDeserializer extends JsonDeserializer<CustomTime> {
	@Override
	public CustomTime deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = FormatOfDate.formatOnlyTime;
		String date = jsonparser.getText();
		//System.out.println("In CustomDateDeserializer -- " + date);
		try {
			Date d = format.parse(date);
			long time = d.getTime();
			CustomTime c = new CustomTime(time);
			return c;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
