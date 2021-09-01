package danbroid.util.menu.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import danbroid.util.menu.MenuState


@Composable
private fun ProgressBar() {
  ConstraintLayout(Modifier.fillMaxSize()) {
    val (progress, title) = createRefs()
    CircularProgressIndicator(Modifier.constrainAs(progress) {
      centerTo(parent)
    })
    Text("Loading", modifier = Modifier.constrainAs(title) {
      top.linkTo(progress.bottom)
      centerHorizontallyTo(progress)
    })
  }
}

@Composable
fun Menus(menuState: MenuState) {

  //log.dtrace("Menus() $menuState")
  when (menuState) {
    is MenuState.LOADING -> {
      ProgressBar()
    }
    is MenuState.LOADED ->
      menuScreen {
        menuState.menus.forEach {
          menu(it)
        }
      }
  }
}


@Composable
@Preview
fun Test() {
  MaterialTheme {
    Box(Modifier.width(200.dp).height(400.dp)) {
      ProgressBar()
    }
  }
}


