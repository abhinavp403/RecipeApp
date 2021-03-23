# RecipeApp

Project courtesy of CodingWithMitch (https://codingwithmitch.com/courses/rest-api-mvvm-retrofit2)

The app retrieves recipe details from recipesapi.herokuapp.com and display it in various views.

I specifically installed Android Studio Canary 4.2 and used JetPack Compose for this project. 
JetPack Compose is a toolkit which writes UI functionality using Kotlin itself instead of traditionally using xml files. 
Certain changes are need to be made in build.gradle before starting to code. Use this as reference (https://developer.android.com/jetpack/compose/setup)

Architecture is MVVM (RecipeListEvent uses MVI)

Libraries Used-
1) JetPack Compose
2) Retfrofit
3) REST APIs
4) Navigation Components
5) Hilt Injection
6) Glide

Breakdown of JetPack Compose features used-
1) Row/Column/Constraint Layout
2) Recycler/Card View
3) SearchView Toolbar
4) Horizontal Scrollable Bar
5) Toggable Chips
6) State Hoisting
7) Progress Bar
8) Animations
9) Scaffold
10) SnackBar
11) Pagination
