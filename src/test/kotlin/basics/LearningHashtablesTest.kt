package basics

import dev.janku.learning.basics.LearningHashtables
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class LearningHashtablesTest {
  @Test
  fun `get a set of all the distinct characters in a string - empty string`() {
    assertTrue(LearningHashtables().distinctCharactersInAString("").isEmpty())
  }

  @Test
  fun `get a set of all the distinct characters in a string - simple string`() {
    assertContentEquals(listOf('a', 'b', 'c'), LearningHashtables().distinctCharactersInAString("abcbcbcabcabcbacbacbabcabcbbcacba"))
  }
}