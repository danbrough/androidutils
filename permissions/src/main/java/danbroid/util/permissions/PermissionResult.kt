package danbroid.util.permissions

/**
 * The result from a permissions request
 */
data class PermissionResult(
  val requestCode: Int,
  /**
   * The list of permissions that were requested
   */
  val permissions: Array<out String>,

  /**
   * Whether or not each pf the [permissions] was granted
   */
  val results: List<Boolean>
) {
  fun isGranted(permission: String) =
    permissions.indexOf(permission).let {
      if (it > -1) results[it] else false
    }
}