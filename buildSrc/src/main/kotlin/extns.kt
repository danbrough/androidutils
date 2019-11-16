fun ProjectVersions.getVersionName(
  versionCode: Int = VERSION_CODE,
  projectVersion: Int = PROJECT_VERSION
) =
  "1.0.${projectVersion}" +
      if (IN_BETA) "-beta%02d".format(
        versionCode - projectVersion
      ) else ""

fun ProjectVersions.getIncrementedVersionName() =
  if (IN_BETA) getVersionName(VERSION_CODE + 1) else
    getVersionName(VERSION_CODE, PROJECT_VERSION + 1)