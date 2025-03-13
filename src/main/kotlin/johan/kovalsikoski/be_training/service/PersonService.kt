package johan.kovalsikoski.be_training.service

import johan.kovalsikoski.be_training.data.vo.v1.PersonVO
import johan.kovalsikoski.be_training.data.vo.v2.PersonVO as PersonVOV2
import johan.kovalsikoski.be_training.exception.ResourceNotFoundException
import johan.kovalsikoski.be_training.mapper.ModelMapper
import johan.kovalsikoski.be_training.mapper.PersonMapper
import johan.kovalsikoski.be_training.model.Person
import johan.kovalsikoski.be_training.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var personMapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun createPerson(person: PersonVO): PersonVO {
        logger.info("Creating person with id: ${person.id}")

        val entity = ModelMapper.map(person, Person::class.java)
        return ModelMapper.map(repository.save(entity), PersonVO::class.java)
    }

    fun createPersonV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating person with id: ${person.id}")

        val entity = personMapper.mapVOToEntity(person)
        return personMapper.mapEntityToVO(repository.save(entity))
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding person with id: $id")

        return repository.findById(id)
            .map {
                ModelMapper.map(it, PersonVO::class.java)
            }
            .orElseThrow { ResourceNotFoundException("No person found with id: $id") }
    }

    fun findAll(): List<PersonVO> {
        logger.info("Finding all persons")

        return ModelMapper.map(repository.findAll(), PersonVO::class.java)
    }

    fun updatePerson(person: PersonVO): PersonVO {
        logger.info("Updating person with id: ${person.id}")

        val entity = repository.findById(person.id).orElseThrow { ResourceNotFoundException("No person found with id: ${person.id}") }
        entity.run {
            name = person.name
            surname = person.surname
            gender = person.gender
            address = person.address
        }

        return ModelMapper.map(repository.save(entity), PersonVO::class.java)
    }

    fun deletePerson(id: Long) {
        logger.info("Deleting person with id: $id")

        val entity = repository.findById(id).orElseThrow { ResourceNotFoundException("No person found with id: $id") }
        repository.delete(entity)
    }

}
