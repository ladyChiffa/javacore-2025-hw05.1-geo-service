import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    void shouldSuccessfulLocaleRU() {
        // Arrange
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать", result;

        // Act
        result = localizationService.locale(Country.RUSSIA);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldSuccessfulLocaleEN() {
        // Arrange
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Welcome", result;

        // Act
        result = localizationService.locale(Country.USA);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldSuccessfulLocaleOther() {
        // Arrange
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Welcome", result;

        // Act
        result = localizationService.locale(Country.BRAZIL);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
