package deque

import org.jetbrains.spek.api.Spek
import org.junit.Assert.*

/**
 * Spek BDD Test for Deque Class
 */
class DequeSpecs: Spek(spekBody = {
    given("Given an Empty Queue") {
        val deque: Deque<Int> = Deque()
        on("Peeking first value") {
            val value = deque.getFirst()
            it("should result in null value") {
                assertNull(value)
            }
        }
        on("Peeking last value"){
            val value = deque.getLast()
            it("should result in a null value"){
                assertNull(value)
            }
        }
    }
    given("Given a Queue with 1 value") {
        val deque: Deque<Int> = Deque()
        deque.addFirst(1)
        on("Fetching first value") {
            val value = deque.getFirst()
            it("1. should not result in null value") {
                assertNotNull(value)
                assertEquals(1, value)
            }
            it("2. should have removed the final value"){
                assertNull(deque.peekFirst())
            }
        }
    }
    given("Given a Queue with 1 value") {
        val deque: Deque<Int> = Deque()
        deque.addFirst(1)
        on("Fetching last value") {
            val value = deque.getLast()
            it("1. should not result in null value") {
                assertNotNull(value)
                assertEquals(1, value)
            }
            it("2. should have removed the final value"){
                assertNull(deque.peekFirst())
            }
        }
    }
    given("Given a Queue with 2 values") {
        val deque: Deque<Int> = Deque()
        deque.addFirst(2)
        deque.addFirst(1)
        on("Fetching first value") {
            val value = deque.peekFirst()
            it("should not result in null value") {
                assertNotNull(value)
                assertEquals(1, value)
            }
        }
        on("Fetching last value") {
            val value = deque.peekLast()
            it("should not result in null value") {
                assertNotNull(value)
                assertEquals(2, value)
            }
        }
        on("Removing last value") {
            deque.removeLast()
            it("There should be 1 value left on the queue") {
                val value = deque.peekFirst()
                assertNotNull(value)
                assertEquals(1, value)
            }
        }
    }
})