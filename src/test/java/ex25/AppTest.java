package ex25;

import org.junit.jupiter.api.Test;

import static ex25.App.passwordValidator;
import static org.junit.jupiter.api.Assertions.*;
public class AppTest
{
    @Test
    void main() {
    }

    @Test
    void testpasswordValidator() {
        assertEquals(2, passwordValidator("asd"));
    }
}
