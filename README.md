To eat donuts, add:
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
to build.gradle(Project)

and add
dependencies {
	compile 'com.github.PhilJay:MPAndroidChart:v3.0.2'
}
to build.gradle(Module)

-Lifesavers
