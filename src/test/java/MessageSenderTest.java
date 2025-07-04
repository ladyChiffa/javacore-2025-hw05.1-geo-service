import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    void shouldSuccessfulRU() {
        // Arrange
        // мокируем вспомогательные классы для MessageSender
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        // создаем объект теструемого класса
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        // Act
        String expected = "Добро пожаловать", result;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        result = messageSender.send(headers);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldSuccessfulEN() {
        // Arrange
        // мокируем вспомогательные классы для MessageSender
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.243.12.1")).thenReturn(new Location("New York", Country.USA, null,  0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        // создаем объект теструемого класса
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        // Act
        String expected = "Welcome", result;
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.243.12.1");
        result = messageSender.send(headers);

        // Assert
        Assertions.assertEquals(result, expected);
    }
}
