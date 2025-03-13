package johan.kovalsikoski.be_training.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object ModelMapper {

    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun <S, D> map(source: S, destination: Class<D>): D = mapper.map(source, destination)

    fun <S, D> map(source: List<S>, destination: Class<D>): List<D> = source.map { map(it, destination) }

}
