package danbroid.util.permissions

data class PermissionResult(
  val requestCode: Int,
  val permissions: Array<out String>,
  val results: List<Boolean>
) {
  fun isGranted(permission: String) =
    permissions.indexOf(permission).let {
      if (it > -1) results[it] else false
    }
}