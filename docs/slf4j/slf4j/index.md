//[slf4j](index.md)



# slf4j  
 [common] 

##  Yet another SL4J implementation for Android  


##  Usage  


###  Gradle:  


From gradle you need to include the maven repository   in your repositories

maven { url 'https://jitpack.io' }

and then include:

compile 'com.github.danbrough.androidutils:slf4j:master-SNAPSHOT'

in your dependencies (for the latest version), or:

compile 'com.github.danbrough.androidutils:slf4j:1.0.6'

for a particular version



###  Configuration:  


see: 

# Overriding the default slf4j.properties  
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
 [androidJvm] 

##  Yet another SL4J implementation for Android  


##  Usage  


###  Gradle:  


From gradle you need to include the maven repository   in your repositories

maven { url 'https://jitpack.io' }

and then include:

compile 'com.github.danbrough.androidutils:slf4j:master-SNAPSHOT'

in your dependencies (for the latest version), or:

compile 'com.github.danbrough.androidutils:slf4j:1.0.6'

for a particular version



###  Configuration:  


see: 

# Overriding the default slf4j.properties  
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

##  Yet another SL4J implementation for Android  


##  Usage  


###  Gradle:  


From gradle you need to include the maven repository   in your repositories

maven { url 'https://jitpack.io' }

and then include:

compile 'com.github.danbrough.androidutils:slf4j:master-SNAPSHOT'

in your dependencies (for the latest version), or:

compile 'com.github.danbrough.androidutils:slf4j:1.0.6'

for a particular version



###  Configuration:  


see: 

# Overriding the default slf4j.properties  
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

##  Yet another SL4J implementation for Android  


##  Usage  


###  Gradle:  


From gradle you need to include the maven repository   in your repositories

maven { url 'https://jitpack.io' }

and then include:

compile 'com.github.danbrough.androidutils:slf4j:master-SNAPSHOT'

in your dependencies (for the latest version), or:

compile 'com.github.danbrough.androidutils:slf4j:1.0.6'

for a particular version



###  Configuration:  


see: 

# Overriding the default slf4j.properties  
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


## Packages  
  
|  Name|  Summary| 
|---|---|
| <a name="org.slf4j.impl////PointingToDeclaration/"></a>[org.slf4j.impl](org.slf4j.impl/index.md) | 

