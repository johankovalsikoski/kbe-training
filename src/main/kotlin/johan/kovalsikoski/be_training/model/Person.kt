package johan.kovalsikoski.be_training.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 15)
    var name: String = "",

    @Column(nullable = false, length = 40)
    var surname: String = "",

    @Column(nullable = false, length = 6)
    var gender: String = "",

    @Column(nullable = true, length = 100)
    var address: String? = null
)
