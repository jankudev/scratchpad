package problems.slidingWindow

import dev.janku.learning.problems.slidingWindow.LongestSubstringWithKDistinctChars
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongsetSubstringWithKDistinctCharsTest {
  @Test
  fun `longest substring - empty string`() {
    assertEquals("", LongestSubstringWithKDistinctChars.find("", 3))
  }

  @Test
  fun `longest substring - single char`() {
    assertEquals("a", LongestSubstringWithKDistinctChars.find("a", 3))
  }

  @Test
  fun `longest substring - example with single distinct character`() {
    assertEquals("aa", LongestSubstringWithKDistinctChars.find("araaci", 1))
  }

  @Test
  fun `longest substring - example with 2 distinct character`() {
    assertEquals("araa", LongestSubstringWithKDistinctChars.find("araaci", 2))
  }

  @Test
  fun `longest substring - example with 3 distinct character`() {
    assertEquals("cbbeb", LongestSubstringWithKDistinctChars.find("cbbebi", 3))
  }
}