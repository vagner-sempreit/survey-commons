package br.com.cielo.desafio.surveycommons.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeTypeAdapter extends TypeAdapter<LocalTime> {

    @Override
    public void write(JsonWriter jsonWriter, LocalTime localTime) throws IOException {
        if (localTime == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localTime.toString());
        }
    }

    @Override
    public LocalTime read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        } else {
            return LocalTime.parse(jsonReader.nextString(), DateTimeFormatter.ISO_DATE_TIME);
        }
    }
}
