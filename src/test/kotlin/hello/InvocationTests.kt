package hello

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.StopWatch

/**
 * Created by masc on 2019-07-01.
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest
class InvocationTests {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var customerRepo: CustomerRepository

    @Test
    fun invoke() {
        val ITERATIONS = 3000000

        // warmup
        repeat(ITERATIONS) { customerRepo.invoke() }

        // measure
        repeat(10) {
            val sw = StopWatch().also { it.start() }
            repeat(ITERATIONS) { customerRepo.invoke() }
            sw.stop()
            log.info("$sw")
        }
    }
}