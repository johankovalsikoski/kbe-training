package johan.kovalsikoski.be_training.controller

import johan.kovalsikoski.be_training.data.vo.v1.PersonVO
import johan.kovalsikoski.be_training.data.vo.v2.PersonVO as PersonVOV2
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
    fun findUserById(@PathVariable(value = "id") id: Long): PersonVO {
        return personService.findById(id)
    }

    @RequestMapping(value = ["/all"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllUsers(): List<PersonVO> {
        return personService.findAll()
    }

    @RequestMapping(
        value = ["/v2"],
        method = [RequestMethod.POST],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createPersonV2(@RequestBody person: PersonVOV2): PersonVOV2 {
        return personService.createPersonV2(person)
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createPerson(@RequestBody person: PersonVO): PersonVO {
        return personService.createPerson(person)
    }

    @RequestMapping(
        method = [RequestMethod.PUT],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updatePerson(@RequestBody person: PersonVO): PersonVO {
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