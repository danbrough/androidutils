package danbroid.util.menu.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Audiotrack
import androidx.compose.material.icons.filled.QueueMusic
import androidx.compose.material.icons.filled.RemoveFromQueue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import danbroid.util.menu.AppIcon
import danbroid.util.menu.Menu
import danbroid.util.menu.MenuDSL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun IconImage(
  imageUrl: Any,
  contentDescription: String?,
  modifier: Modifier = Modifier,
) {
  Image(
    painter = rememberImagePainter(data = imageUrl) {
      //crossfade(true)
      transformations(RoundedCornersTransformation(8.dp.value))
    },
    contentDescription = contentDescription,
    modifier = modifier,
    contentScale = ContentScale.FillBounds,
  )
}

@Composable
fun MenuListIcon(_icon: Any?, title: String = "") {
  val imageModifier =
    Modifier.size(52.dp)
      .padding(2.dp)
  // .padding(start = 8.dp, top = 0.dp, bottom = 0.dp)

  val icon = AppIcon.lookupIcon(_icon)


  val iconTint = MaterialTheme.colors.primary

  icon?.also {
    when (it) {
      is Bitmap ->
/*        DemoImage(
            imageUrl = it,
            title,
            modifier = imageModifier
        )*/
        Image(
          it.asImageBitmap(),
          title,
          modifier = imageModifier.clip(RoundedCornerShape(8.dp)),
          contentScale = ContentScale.FillBounds
        )
      /*       Icon(
                 it.asImageBitmap(),
                 title,
                 modifier = imageModifier.clip(RoundedCornerShape(8.dp)),
                 tint = Color.Unspecified
             )*/
      is String ->
        IconImage(
          imageUrl = it,
          title,
          modifier = imageModifier
        )
      is ImageVector ->
        Icon(
          it,
          title,
          modifier = imageModifier,
          tint = iconTint
        )
      is Int ->
        Icon(
          painterResource(it),
          title,
          modifier = imageModifier,
          tint = iconTint,
        )
      else ->
        IconImage(
          imageUrl = it.toString(),
          title,
          modifier = imageModifier
        )
    }
  } ?: Icon(
    Icons.Filled.Audiotrack,
    contentDescription = null,
    tint = iconTint,
    modifier = imageModifier
  )
}

@Composable
private fun MenuListItemRow(
  modifier: Modifier,
  title: String,
  subTitle: String,
  _icon: Any?
) {
  Row(
    modifier = modifier.height(62.dp).fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Start,

    ) {

    Spacer(Modifier.width(8.dp))
    MenuListIcon(_icon, title)
    /*  Image(
          Icons.Filled.Audiotrack, "",
          contentScale = ContentScale.Fit,
          //modifier = Modifier.size(42.dp),
          colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
      )*/
    Column(
      Modifier.padding(start = 8.dp).fillMaxWidth(),
      verticalArrangement = Arrangement.Bottom
    ) {
      Text(title, style = MaterialTheme.typography.subtitle1)

      buildAnnotatedString {

      }
      Text(
        subTitle,
        overflow = TextOverflow.Ellipsis, maxLines = 2,
        modifier = Modifier.alpha(ContentAlpha.medium),
        style = MaterialTheme.typography.body2
      )
    }
  }
}


@Composable
fun MenuListItemImpl(
  modifier: Modifier,
  title: String,
  subTitle: String,
  _icon: Any?,
  highLighted: Boolean = false,
) {
  if (highLighted) {
    Box {
      MenuListItemRow(modifier, title, subTitle, _icon)
      Box(
        Modifier.height(62.dp).fillMaxWidth()
          .background(MaterialTheme.colors.secondaryVariant.copy(alpha = 0.2f))
      ) {

      }
    }
  } else
    MenuListItemRow(modifier, title, subTitle, _icon)
  Divider()
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
private fun MenuItemPreview() {
  MaterialTheme {
    Column {

      ListItem(
        secondaryText = { Text("This is the secondary text") },
        icon = { MenuListIcon(AppIcon.ICON_MAP, "Settings") }
      ) {
        Text("This is the primary text")
      }
      Divider()

      MenuListItemImpl(Modifier, "The title", "The Subtitle", Icons.Default.QueueMusic)
      Divider()
      MenuListItemImpl(
        Modifier,
        "The title2",
        "The Subtitle which is a lot longer and so will probably over flow the text display thingy still typing ",
        Icons.Default.RemoveFromQueue,
        highLighted = true
      )
      Divider()
    }
  }
}


@MenuDSL
inline fun LazyListScope.menu(
  menu: Menu,
  sticky: Boolean = false,
  highLighted: Boolean = false,
  clickable: Boolean = true
) = menu(menu.id, menu, sticky, highLighted, clickable, {})


@MenuDSL
inline fun LazyListScope.menu(
  id: String = "_${MenuContext.NEXT_ID++}",
  menu: Menu = Menu(id, "Untitled"),
  sticky: Boolean = false,
  highLighted: Boolean = false,
  clickable: Boolean = true,
  crossinline onCreate: @Composable Menu.() -> Unit
) {

  // log.dtrace("menuID: ${menu.id}")

  val itemContent: @Composable LazyItemScope.() -> Unit = {
    menu.onCreate()
    val context = LocalMenuContext.current
    val scope = rememberCoroutineScope()
    val itemModifier =
      if (clickable) Modifier.clickable(true, menu.title, onClick = {
        scope.launch(Dispatchers.Main) {
          context.onMenuClicked(menu)
        }
      }) else Modifier

    if (sticky) {
      Card(elevation = 1.dp) {
        MenuListItemImpl(
          itemModifier,
          menu.title,
          menu.subTitle,
          menu.icon,
          highLighted = highLighted
        )
      }
    } else MenuListItemImpl(
      itemModifier,
      menu.title,
      menu.subTitle,
      menu.icon,
      highLighted = highLighted
    )
  }

  if (sticky)
    stickyHeader(menu.id, itemContent)
  else
    item(menu.id, itemContent)
}


private val log = danbroid.logging.getLog("danbroid.util.menu.ui")


@SuppressLint("ComposableNaming")
@MenuDSL
@Composable
fun menuScreen(block: LazyListScope.() -> Unit) {

  LazyColumn {
    block()
  }

}
