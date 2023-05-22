package franxx.code.test.service;

import franxx.code.test.data.Person;
import franxx.code.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;
    private PersonService service;

    @BeforeEach
    void setUp() {
        service = new PersonService(repository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.get("Not Found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambahkan behavior ke mock object
        Mockito.when(repository.selectById("zeroTwo"))
                .thenReturn(new Person("zeroTwo", "ZeroTwo"));

        var person = service.get("zeroTwo");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("zeroTwo", person.getId());
        Assertions.assertEquals("ZeroTwo", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = service.register("Hilmi");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Hilmi", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(repository, Mockito.times(1))
                .insert(new Person(person.getId(), "Hilmi"));
    }
}
