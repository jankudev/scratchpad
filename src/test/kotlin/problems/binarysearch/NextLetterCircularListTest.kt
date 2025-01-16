package problems.binarysearch

import dev.janku.learning.problems.binarysearch.NextLetterCircularList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NextLetterCircularListTest {
  @Test
  fun `closest letter - empty array should throw exception`() {
    val array = emptyArray<Char>()
    assertFailsWith<IllegalArgumentException> {
      NextLetterCircularList.nextLetterAfterKey(array, 'a')
    }
  }

  @Test
  fun `closest letter - key in list`() {
    val array = arrayOf('a', 'c', 'f', 'h')
    assertEquals('h', NextLetterCircularList.nextLetterAfterKey(array, 'f'))
  }

  @Test
  fun `closest letter - key out of list`() {
    val array = arrayOf('a', 'c', 'f', 'h')
    assertEquals('a', NextLetterCircularList.nextLetterAfterKey(array, 'm'))
  }

  @Test
  fun `closest letter - key on list boundary`() {
    val array = arrayOf('a', 'c', 'f', 'h')
    assertEquals('a', NextLetterCircularList.nextLetterAfterKey(array, 'h'))
  }
}