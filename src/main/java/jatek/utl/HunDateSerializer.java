package jatek.utl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Magyarra formázott dátum és időpont készítés a
 * {@link JsonUtil#toHunDateJson JsonUtil.toHunDateJson} metódus működéséhez.
 * A java.sql.Date formázása yyyy.MM.dd. lesz.
 * A java.util.Date formázása yyyy.MM.dd. HH:mm:ss lesz.
 *
 * @author Jenei Attila
 */
public class HunDateSerializer extends DateSerializer {

    //TODO: a végére nem teszünk pontot mert a kliens datePicker összefossa magát
    private static final DateTimeFormatter DATE_HUN = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private static final DateTimeFormatter DATETIME_HUN = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");

    @Override
    public void serialize(Date value, JsonGenerator g, SerializerProvider provider) throws IOException {
        if (value instanceof java.sql.Date) {
            LocalDate localDate = ((java.sql.Date) value).toLocalDate();
            g.writeString(localDate.format(DATE_HUN));
        } else {
            g.writeString(DATETIME_HUN.format(value.toInstant().atZone(ZoneId.systemDefault())));
        }
    }
}
