# COVIAware - Android Study Jams App

## Problem Statement

In the purview of the pandemic, it has become essential to be aware of the updates related to the COVID-19 pandemic. There is the need of a platform that provides all such updates in one place. Technological advancements have made it easy to access such information via mobile applications.

## Proposed Solution

<b>COVIAware</b> is a Kotlin mobile Android application that keeps the user updated with the latest news related to the COVID-19 pandemic and provides a feature of bookmarking important articles for future read. The user can also read the news articles without leaving the application with the help of a web view. The news articles are fetched from the News API. Firebase Authentication is used for the register/login feature.

## Functionality & Concepts used

- User Interface: Constraint and Relative Layout were used extensively with Fragments being used for Recycler Views. A salient splash screen was also created using Android Jetpack splash screen library

- User Experience: Use of familiar audience EditText with hints and interactive buttons made it easier for users to register or sign in without providing any detailed instructions pages. Navigation is aided by the menu options in the ActionBar and makes used of the Android Jetpack Navigation component.

- MVVM Architecture: The Model-View-ViewModel architecture was followed extensively while developing the application. The ViewModel interacts with the Repository to collect and send data to and from the Retrofit service and the Room database.

- RecyclerView: To present the list of latest news articles fetched from the <a href="https://newsapi.org/">News API</a> and bookmarked articles stored in the Room database.

- Room Database: The bookmarked articles are stored in the user's device locally using Room database using coroutines. They are also retrieved from the database to view them in the Bookmarks fragment. Since the data class created for this entity had to passed as navigation arguments, the Serializable class was implemented and convertors were created.

- Retrofit and Moshi: They are used to fetch the data from the News API using coroutines and parsing them to Kotlin data class objects.

- Firebase: It is used to provide authentication features i.e., registration and login.

- Coroutines: Suspending functions were used to insert data into the Room database and also to fetch data from the News API using Retrofit.

## Application Link & Future Scope

You can view the source code of the application on [GitHub](https://github.com/DSC-VJTI/Android-Study-Jam-App). Download the [APK](https://github.com/DSC-VJTI/Android-Study-Jam-App/releases/tag/v1.0.0) from the Releases Assets to try it out. [Here](https://drive.google.com/drive/u/0/folders/1WlKDbWRc6u1aSGoZtyeMyffeMlHu7den?authuser=2) are some glimpses of the mobile application.
<br/>
As a part of the future scope, the functionalities of the application can be extended to include a search feature for the news articles and displaying an infinite scroll of news articles using pagination.
