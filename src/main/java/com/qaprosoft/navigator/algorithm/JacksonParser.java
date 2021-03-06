package com.qaprosoft.navigator.algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.navigator.models.Trip;

public class JacksonParser {
	private final static Logger logger = Logger.getLogger(JacksonParser.class);
	private final static String baseFile = "src//main//resources//navigator.json";

	public static void toJSON(List<Trip> trip)  {
		try {
			ObjectMapper mapper = new ObjectMapper();
			final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trip);
			Files.deleteIfExists(new File(baseFile).toPath());			
			Files.write(new File(baseFile).toPath(), Arrays.asList(json), StandardOpenOption.CREATE);
			logger.info("json created");
		} catch (JsonGenerationException e) {
			logger.error(e);
		} catch (JsonMappingException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}	
	}	
}


