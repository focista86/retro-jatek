package jatek.utl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author szarvas
 */

@Component
public class HunDateDeserializer extends JsonDeserializer<Date> {
    @Autowired
    private Logger logger;

    private static final DateTimeFormatter FORMATTER_HUN_DATETIME = DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm:ss");
    private static final DateTimeFormatter FORMATTER_HUN_DATE_11 = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
    private static final DateTimeFormatter FORMATTER_HUN_DATE_10 = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private static final ZoneId ZONE_HUN = ZoneId.of("Europe/Budapest");

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (jp.getCurrentToken() == JsonToken.VALUE_STRING) {
            String s = jp.getText().trim();
            try {
                return parse(s);
            } catch (DateTimeParseException ex) {
                logger.log(Level.WARNING, "jackson parse hiba", ex);
                throw ex;
            }
        }
        throw ctxt.wrongTokenException(jp, Date.class, JsonToken.NOT_AVAILABLE, "expected JSON Array, String or Number");
    }

    private Date parse(String s) {
        if (s.length() == 0) {
            return null;
        } else if (s.length() == 20) {
            LocalDateTime dateTime = LocalDateTime.parse(s, FORMATTER_HUN_DATETIME);
            Date date = Date.from(dateTime.atZone(ZONE_HUN).toInstant());
            logger.log(Level.FINE, "" + s + " --> " + date);
            return date;
        } else if (s.length() == 11) {
            LocalDate localDate = LocalDate.parse(s, FORMATTER_HUN_DATE_11);
            
            return java.sql.Date.valueOf(localDate);
        } else if (s.length() == 10) {
            LocalDate localDate = LocalDate.parse(s, s.charAt(4) == '.' ? FORMATTER_HUN_DATE_10 : DateTimeFormatter.ISO_DATE);
            
            return java.sql.Date.valueOf(localDate);
        } else {
            //a 4 számjegyű zone offsetet kettősponttal bővítjük, mert a kurva java time formatterei nem fogadják el
            // 2018-06-09T22:00:00.000+0000  --->
            // 2018-06-09T22:00:00.000+00:00
            int index = s.indexOf('+');
            if (index != -1 && index == s.length() - 5 && s.indexOf(':', index) == -1) {
                s = s.substring(0, index + 3) + ":" + s.substring(index + 3);
            }
            //
            ZonedDateTime zdt = ZonedDateTime.parse(s);
            //Loggers.logDebug(this, "" + s + " --> " + date);
            return Date.from(zdt.toInstant());
        }
    }

    public static void main(String[] args) {
      /*String s = "2018-06-21T22:00:00.000Z";
      ZonedDateTime zdt = ZonedDateTime.parse(s);
      System.out.println("ISO: " + DateTimeFormatter.ISO_DATE_TIME.format(zdt));
      Date date = Date.from(zdt.toInstant());
      System.out.println("" + date);
      Eljaras eljaras = new Eljaras();
      eljaras.setBeerkezesDat(date);
      System.out.println("" + eljaras.getBeerkezesDat());*/

        HunDateDeserializer hdd = new HunDateDeserializer();
        System.out.println(hdd.parse("2018-06-09T22:00:00.000Z"));
        System.out.println(hdd.parse("2018-06-10T00:00:00.000+02:00"));
        System.out.println(hdd.parse("2018.06.10."));
        System.out.println(hdd.parse("2018.06.10"));
        System.out.println(hdd.parse("2018-06-10"));
        System.out.println(hdd.parse("2018-06-09T22:00:00.000+00:00"));
        System.out.println(hdd.parse("2018-06-09T22:00:00.000+0000"));
    }
}
