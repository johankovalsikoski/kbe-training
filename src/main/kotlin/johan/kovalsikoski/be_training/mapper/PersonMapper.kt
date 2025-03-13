package johan.kovalsikoski.be_training.mapper

import johan.kovalsikoski.be_training.data.vo.v2.PersonVO
import johan.kovalsikoski.be_training.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        return PersonVO(
            id = person.id,
            name = person.name,
            surname = person.surname,
            gender = person.gender,
            address = person.address,
            birthDay = Date()
        )
    }

    fun mapVOToEntity(personVO: PersonVO): Person {
        return Person(
            id = personVO.id,
            name = personVO.name,
            surname = personVO.surname,
            gender = personVO.gender,
            address = personVO.address,
        )
    }

}