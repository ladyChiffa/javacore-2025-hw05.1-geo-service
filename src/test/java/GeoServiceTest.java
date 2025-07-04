import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceTest {
    @Test
    void shouldSuccessfulByIP1() {
        // Arrange
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0), result;

        // Act
        result = geoService.byIp("172.123.12.19");

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldSuccessfulByIP2() {
        // Arrange
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, null,  0), result;

        // Act
        result = geoService.byIp("96.243.12.1");

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
