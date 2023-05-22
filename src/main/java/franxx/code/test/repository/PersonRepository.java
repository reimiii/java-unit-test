package franxx.code.test.repository;

import franxx.code.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);
}
