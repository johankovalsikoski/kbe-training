package johan.kovalsikoski.be_training.mapper

import johan.kovalsikoski.be_training.data.vo.v1.PersonVO
import johan.kovalsikoski.be_training.mock.MockPerson
import johan.kovalsikoski.be_training.model.Person
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ModelMapperTest {

    private var inputObject: MockPerson? = null

    @BeforeEach
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToV0Test() {
        val output: PersonVO = ModelMapper.map(inputObject!!.mockEntity(), PersonVO::class.java)
        assertEquals(0, output.id)
        assertEquals(inputObject!!.mockEntity().name, output.name)
        assertEquals(inputObject!!.mockEntity().surname, output.surname)
        assertEquals(inputObject!!.mockEntity().gender, output.gender)
        assertEquals(inputObject!!.mockEntity().address, output.address)
    }

    @Test
    fun parseEntityListToV0ListTest() {
        val output: List<PersonVO> = ModelMapper.map(inputObject!!.mockEntityList(), PersonVO::class.java)
        assertEquals(3, output.size)
        assertEquals(inputObject!!.mockEntityList()[1].name, output[1].name)
    }

    @Test
    fun parseVOToEntityTest() {
        val output: Person = ModelMapper.map(inputObject!!.mockVO(), Person::class.java)
        assertEquals(0, output.id)
        assertEquals(inputObject!!.mockEntity().name, output.name)
        assertEquals(inputObject!!.mockEntity().surname, output.surname)
        assertEquals(inputObject!!.mockEntity().gender, output.gender)
        assertEquals(inputObject!!.mockEntity().address, output.address)
    }

    @Test
    fun parseVOListToEntityListTest() {
        val output: List<Person> = ModelMapper.map(inputObject!!.mockVOList(), Person::class.java)
        assertEquals(3, output.size)
        assertEquals(inputObject!!.mockEntityList()[1].name, output[1].name)
    }

}