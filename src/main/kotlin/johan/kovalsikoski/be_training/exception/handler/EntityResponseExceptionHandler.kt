package johan.kovalsikoski.be_training.exception.handler

import johan.kovalsikoski.be_training.exception.ExceptionResponse
import johan.kovalsikoski.be_training.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class EntityResponseExceptionHandler: ResponseEntityExceptionHandler() {

    fun globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            message = ex.message ?: "Unknown error",
            details = request.getDescription(false),
            timestamp = Date()
        )

        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            message = ex.message ?: "Unknown error",
            details = request.getDescription(false),
            timestamp = Date()
        )
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

}
