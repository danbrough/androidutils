package danbroid.util.menu

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 *
 */
class ContentManager(val context: Context) {

  fun liveItemFlow(id: String, builder: MenuItemBuilder): Flow<MenuItem> = itemFlow(id, builder)

  private fun itemFlow(id: String, builder: MenuItemBuilder): Flow<MenuItem> = flow {
    var item = builder.createItem(context, id)
    log.trace("emitting first item")
    emit(item)

    builder.liveItem?.also {
      it.invoke(context, item).also {
        log.trace("emitting live item: $it")
        emit(it)
        item = it
      }
    }

    liveChildren(item, builder)?.also {
      item.children = it
      emit(item)
    }

  }.flowOn(Dispatchers.IO)

  suspend fun liveChildren(item: MenuItem, builder: MenuItemBuilder): List<MenuItem>? {

    builder.liveChildren?.invoke(context, item)?.also {
      return it
    }

    val hasInlineChild = builder.children?.firstOrNull { it.inlineChildren } != null
    if (!hasInlineChild) return null
    val children = mutableListOf<MenuItem>()
    builder.children?.forEach {
      it as MenuItemBuilder
      if (it.inlineChildren) {
        it.children?.map {
          it as MenuItemBuilder
          it.createItem(context, it.id!!)
        }?.also {
          children.addAll(it)
        }

      } else {
        children.add(it.createItem(context, it.id!!))
      }
    }

    return if (children.isEmpty()) null else children
  }


  companion object {
    @Volatile
    private var INSTANCE: ContentManager? = null

    @JvmStatic
    fun getInstance(context: Context) = INSTANCE ?: synchronized(ContentManager::class.java) {
      INSTANCE ?: ContentManager(context).also {
        INSTANCE = it
      }
    }
  }
}


private val log = org.slf4j.LoggerFactory.getLogger(ContentManager::class.java)
