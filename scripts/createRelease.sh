#!/bin/bash


cd `dirname $0` && cd ..

#arrIN=(${IN//;/ })

if [ $# -eq 0 ]; then
    VERSION_CODE=$(awk '/const val VERSION_CODE/ {print $5}' <   buildSrc/src/main/kotlin/ProjectVersions.kt)
    VERSION_CODE=$(( VERSION_CODE + 1 ))
else
    VERSION_CODE=$1
fi


VERSION_NAME=$(./gradlew -q projectVersion -PVERSION_CODE=$VERSION_CODE)

echo Creating release: $VERSION_NAME

while true; do
    read -p "Do you wish to proceed?: " yn
    case $yn in
        [Yy]* ) break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

if git tag | grep "$VERSION_NAME" > /dev/null; then
  while true; do
    read -p "Existing Tag $VERSION_NAME found. Shall I delete it?: " yn
    case $yn in
        [Yy]* ) break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
  done
  echo removing existing tag "$VERSION_NAME"
  git tag -d "$VERSION_NAME"
  git push origin --delete "$VERSION_NAME"
fi

sed -i buildSrc/src/main/kotlin/ProjectVersions.kt \
    -e 's:VERSION_CODE = .*:VERSION_CODE = '$VERSION_CODE':g'

git add .
git commit -am "$VERSION_NAME"
git tag "$VERSION_NAME" && git push && git push origin "$VERSION_NAME"

