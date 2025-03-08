package johan.kovalsikoski.be_training.service

import johan.kovalsikoski.be_training.exception.ResourceNotFoundException
import johan.kovalsikoski.be_training.model.Person
import johan.kovalsikoski.be_training.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun createPerson(person: Person): Person {
        logger.info("Creating person with id: ${person.id}")
        repository.save(person)
        return person
    }

    fun findById(id: Long): Person {
        logger.info("Finding person with id: $id")

        return repository.findById(id).orElseThrow { ResourceNotFoundException("No person found with id: $id") }
    }

    fun findAll(): List<Person> {
        logger.info("Finding all persons")
        return repository.findAll()
    }

    fun updatePerson(person: Person): Person {
        logger.info("Updating person with id: ${person.id}")
        val entity = repository.findById(person.id).orElseThrow { ResourceNotFoundException("No person found with id: ${person.id}") }
        entity.run {
            name = person.name
            surname = person.surname
            gender = person.gender
            address = person.address
        }
        return entity
    }

    fun deletePerson(id: Long) {
        logger.info("Deleting person with id: $id")
        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No person found with id: $id") }
        repository.delete(entity)
    }

}
