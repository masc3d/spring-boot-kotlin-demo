package hello

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

interface CustomerRepository :
        CrudRepository<Customer, Long>,
        CustomerRepositoryExtension {

    fun findByLastName(lastName: String): Iterable<Customer>
}

interface CustomerRepositoryExtension {
	fun invoke(): Int?
}

class CustomerRepositoryImpl : CustomerRepositoryExtension {
    private val cache = mapOf(1 to 1)

    override fun invoke(): Int? {
        return cache[1]
    }
}
