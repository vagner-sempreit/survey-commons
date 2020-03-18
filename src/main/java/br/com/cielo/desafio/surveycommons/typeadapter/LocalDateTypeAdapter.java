package br.com.cielo.desafio.surveycommons.typeadapter;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localDate.toString());
        }
    }

    @Override
    public LocalDate read(JsonReader jsonReader) throws IOException {
    	var value = jsonReader.nextString();
        return StringUtils.isNotBlank(value) ? LocalDate.parse(value) : null;
    }
}
