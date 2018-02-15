# danbroid_slf4j
Yet another SL4J implementation for Android

## Usage

### Gradle:
From gradle you need to include the maven repository 
 in your repositories
 
 
```gradle
maven { url 'https://jitpack.io' }
```


and then include:

```gradle
compile 'com.github.danbrough.util:slf4j:master-SNAPSHOT'
```

in your dependencies (for the latest version), or:

```gradle
compile 'com.github.danbrough:danbroid_slf4j:v1.001'
```

for a particular version

### Configuration:

see: 

```ini
# Overriding the default logging.properties
# the logger names are hierarchical (via the . operator) and must be
# defined top down/depth first.
# eg:
#   A=
#   A.B=
#   A.B.C=
#   D=
#   D.E= ..


#
# default logger settings


#level = (native,trace,debug,info,warn,error)
level=native

# or color=true if you prefer
colour=true

tag=DEMO

# default logger settings for package1 (and all below)
package1_tag=DEMO_PKG1

#apart from tags, RHS values are case insensitive
package1_level=Warn
package1_colour=falSe


# specific logger settings for package1.Class1
package1.Class1_level=info
package1.Class1_colour=true
package1.Class1_tag=DEMO_CLASS1

package2_color=false
package2_tag=DEMO_PKG2
package2_level=native
```
