package meizi.serialization;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends JsonSerializer<CustomDate> {
    @Override
    public void serialize(CustomDate value, JsonGenerator gen, SerializerProvider arg2) throws IOException {

        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS");
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter  = FormatOfDate.formatWithTime;
		long time = value.getTime();
		
		Date d = new Date(time);
		
        String formattedDate = formatter.format(d);
        
        //System.out.println("In CustomDateSerializer -- " + formattedDate);
        
        gen.writeString(formattedDate);
    }
    /*
    @Override
    public Class<CustomDate> handledType()
    {
      return CustomDate.class;
    }
    */
}
