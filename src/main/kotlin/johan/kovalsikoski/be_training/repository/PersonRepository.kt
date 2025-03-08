package johan.kovalsikoski.be_training.repository

import johan.kovalsikoski.be_training.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long?>
