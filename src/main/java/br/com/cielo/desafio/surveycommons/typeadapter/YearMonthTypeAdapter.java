package br.com.cielo.desafio.surveycommons.typeadapter;

import java.io.IOException;
import java.time.YearMonth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class YearMonthTypeAdapter extends TypeAdapter<YearMonth> {

    @Override
    public void write(JsonWriter jsonWriter, YearMonth localDate) throws IOException {
        if (localDate == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(localDate.toString());
        }
    }

    @Override
    public YearMonth read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        } else {
            return YearMonth.parse(jsonReader.nextString());
        }
    }
}
