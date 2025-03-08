package johan.kovalsikoski.be_training.controller

import johan.kovalsikoski.be_training.model.Person
import johan.kovalsikoski.be_training.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findUserById(@PathVariable(value = "id") id: Long): Person {
        return personService.findById(id)
    }

    @RequestMapping(value = ["/all"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllUsers(): List<Person> {
        return personService.findAll()
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createPerson(@RequestBody person: Person): Person {
        return personService.createPerson(person)
    }

    @RequestMapping(
        method = [RequestMethod.PUT],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updatePerson(@RequestBody person: Person): Person {
        return personService.updatePerson(person)
    }

    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.DELETE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deletePerson(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        personService.deletePerson(id)
        return ResponseEntity.noContent().build<Any>()
    }
}