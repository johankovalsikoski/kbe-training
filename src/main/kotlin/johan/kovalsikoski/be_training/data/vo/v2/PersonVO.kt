package johan.kovalsikoski.be_training.data.vo.v2

import java.util.Date

data class PersonVO(
    var id: Long = 0,
    var name: String = "",
    var surname: String = "",
    var gender: String = "",
    var address: String? = null,
    var birthDay: Date? = null
)
