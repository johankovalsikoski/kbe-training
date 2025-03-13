package johan.kovalsikoski.be_training.mock

import johan.kovalsikoski.be_training.data.vo.v1.PersonVO
import johan.kovalsikoski.be_training.model.Person

class MockPerson {

    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockVO(): PersonVO {
        return mockVO(0)
    }


    fun mockEntity(number: Int): Person {
        return Person(
            name = "name$number",
            surname = "surname$number",
            gender = if (number % 2 == 0) "Male" else "Female",
            address = "address$number",
        )
    }

    fun mockVO(number: Int): PersonVO {
        return PersonVO(
            name = "name$number",
            surname = "surname$number",
            gender = if (number % 2 == 0) "Male" else "Female",
            address = "address$number",
        )
    }

    fun mockEntityList(): List<Person> {
        return listOf(mockEntity(0), mockEntity(1), mockEntity(2))
    }

    fun mockVOList(): List<PersonVO> {
        return listOf(mockVO(0), mockVO(1), mockVO(2))
    }
}