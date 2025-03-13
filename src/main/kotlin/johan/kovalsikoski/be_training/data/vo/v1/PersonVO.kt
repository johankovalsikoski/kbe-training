package johan.kovalsikoski.be_training.data.vo.v1

data class PersonVO(
    var id: Long = 0,
    var name: String = "",
    var surname: String = "",
    var gender: String = "",
    var address: String? = null
)
