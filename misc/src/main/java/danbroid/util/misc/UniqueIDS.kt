package danbroid.util.misc

import java.util.concurrent.atomic.AtomicInteger

/**
 * Provides a [#nextID] method to return an incremental unique id
 */
interface UniqueIDS {
  companion object {
    private var _id = AtomicInteger(0)
  }

  fun nextID() = _id.incrementAndGet()
}