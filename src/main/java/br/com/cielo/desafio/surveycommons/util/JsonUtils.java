package br.com.cielo.desafio.surveycommons.util;

import br.com.cielo.desafio.surveycommons.gson.MapDeserializerDoubleAsIntFix;
import br.com.cielo.desafio.surveycommons.typeadapter.LocalDateTimeTypeAdapter;
import br.com.cielo.desafio.surveycommons.typeadapter.LocalDateTypeAdapter;
import br.com.cielo.desafio.surveycommons.typeadapter.LocalTimeTypeAdapter;
import br.com.cielo.desafio.surveycommons.typeadapter.YearMonthTypeAdapter;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.Map;

public class JsonUtils {

    public static boolean isParsable(String value) {
        try {
            new GsonBuilder().create().fromJson(value, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static GsonBuilder getDefault() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new LocalTimeTypeAdapter().nullSafe())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter().nullSafe())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter().nullSafe())
                .registerTypeAdapter(YearMonth.class, new YearMonthTypeAdapter().nullSafe())
                .registerTypeAdapter(new TypeToken<Map<String, Object>>(){}.getType(), new MapDeserializerDoubleAsIntFix());
    }

}
