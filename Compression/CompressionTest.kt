import compression.runLengthEncoding
import org.jetbrains.spek.api.Spek
import org.junit.Assert.*

/**
 * Spek BDD test for Run Length Encoding
 */
class RunLengthEncodingTest: Spek({
    given("Empty String"){
        it("Returns Empty String"){
            assertEquals("",runLengthEncoding(""))
        }
    }
    given("Single character"){
        it("Returns 1A"){
            assertEquals("1B",runLengthEncoding("B"))
        }
    }
    given("All same Character"){
        it("It returns 5A"){
            assertEquals("5A",runLengthEncoding("AAAAA"))
        }
    }
    given("A mix of characters then "){
        it("It returns expected encoding"){
            assertEquals("5A3B4C2A",runLengthEncoding("AAAAABBBCCCCAA"))
        }
    }
    given("A longer string then "){
        it("It returns expected encoding without overflow"){
            assertEquals("5A3B4C7A3B4C7A3B4C7A3B4C7A3B4C7A3B4C7A3B4C7A3B4C7A3B4C2A",
                    runLengthEncoding("AAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAAAAAAABBBCCCCAA"))
        }
    }
})