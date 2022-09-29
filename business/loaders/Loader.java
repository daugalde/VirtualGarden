package loaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import common.Constants;
import model.app.virtualGarden.Simulator;

class LocalDateTimeSerializer implements JsonSerializer <LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(localDateTime));
    }
}

public class Loader implements IFileLoader {

	@Override
	public  Simulator LoadFile(Object obj) {

		BufferedReader bufferedReader = GetFileReader ();
		
		if(bufferedReader != null) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			
			gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
			
			Gson gson =  gsonBuilder.setPrettyPrinting().create();
		
			return (Simulator)gson.fromJson(bufferedReader, obj.getClass());
		
		}
		return ( Simulator)obj;
	}
	
	private BufferedReader GetFileReader () {
        try {
			
			File file = new File(Constants.CONFIG_FILE_PATH);
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			return bufferedReader;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
	}
}
