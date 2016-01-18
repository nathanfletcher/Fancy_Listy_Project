<h1>Android Studio Navigation Drawer with Fragments Tutorial </h1>

<h3>Step (1)</h3>
*Start your project with a Navigation drawer Activity as your main activity*
You can do this by starting a new project then giving it a name.
When you are asked to select the type of activity to start with, choose "Navigation Drawer Activity"

<h3>Step (2)</h3>
In the main activitie's layout file, you put this <Frame Layout> code into your main activity.
It is where all the fragments would be display replaced etc.
```
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent" android:id="@+id/fragment_container"/>
```
<h3>Step (3)</h3>
*Create a relative layout file.*

In Android studio, right-click on the "layout" folder, then click
New > Layout Resource File

Withing the pop-up window that comes up, make sure that the Root Element is set to
"RelativeLayout" if not, you could type it in yourself.

Give the file a name and then click create. For this project, I called mine "fragment1_layout"

<h3>Step (4)</h3>
*Create a class that extends Fragment*

Right-click on the folder where all the java classes are stored. It's usually named after the reverse website name of the project.
For this project, it's called com.ketecode.fancylistproject
then go to New>Java Class

Give the class a name and create it by clicking OK. For this project, I called it "FirstFragment"
Feel free to call it anything. Remember that each fragment class and fragment layout you create would act as a
normal activity. It would become visible when the user clicks on an item in the navigation menu, like an activity.

Within the class, add "extends Fragment" in the declaration of the file. Android studio would automatically import the class
Don't worry if you're getting an error. It's because the Fragment extension require you to overide a certain method we would look at in the next step.

<h3>Step (5)</h3>
*Overriding onCreateView()*

Create some space within the class and right-click within the class.
In the popup menu, click Generate>Override Methods
A popup window would appear then you look for onCreateView(). Click on it.
Android Studio would override the method within the class for you.

In that method we would need to reference the layout file we just created.
We do this by creating an instance of the View class like so...
```
View view = inflater.inflate(R.layout.fragment1_layout, container, false);
```
Remember that you also have to initialixze all the enements in the design within this method
e.g if you have a TextView within the layout you want to work with, you initialize it like this.

First, declare the TextView variable on top of the class and initialize it in the method. (see FirstFragment.java)
Finally return view.

<h3>And Finally, Step (6)</h3>
*Connecting your created fragment to the navigation drawer*

We would put the fragment in the MainActivity and also call an Intent to display it when the first menu Item is clicked
Otherwise when the app is launched, the user would see a blank screen unless they tap the first menu item in the Navigation Drawer

Withing the onCreate() method of your main class, put this piece of code at the bottom of the method to load the first fragment </br>
```
//Initial fragment code
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //calling the first menu item's fragment to be displayed using FragmentManager class
        FirstFragment frag1 = new FirstFragment();
        fragmentTransaction.add(R.id.fragment_container, frag1, "Our First Fragment");
        fragmentTransaction.commit();
```

Scroll down to this method line created by Android Studio

```
@Override
    public boolean onNavigationItemSelected(MenuItem item){...}
```
within it are the menu items inside an "if{} else if{}" statement.
They would perform whatever action you put in them when you tap on them.
We would create an Intent that would call back the fragment into view when the user clicks on it.
The code is similar to what was done in onCreate()
The only difference is that instead of `fragmentTransaction.**add**(...` we use `fragmentTransaction.**replace**(...`

*//Put this code inside the first "if" statement that represents the first menu item*
```
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment frag1 = new FirstFragment();
        fragmentTransaction.replace(R.id.fragment_container, frag1, "Our First Fragment");
        fragmentTransaction.commit();
```
*//Check out how I optimized it in my MainActivity.java class*


From this point on you would be able to create more fragments and work with them. A few things to note:
Fragments cannot talk to each other directly. i.e you cannot create an instance of one fragment and let it
pass values to another fragment
In order to do that, you would have to create an interface within your fragment classes for the
MainActivity to implement.
You can find out more about how Fragments work with this **YouTube video tutorial:**
[The New Boston Fragments Tutorial](https://www.youtube.com/watch?v=vyykjIPNBXY)

Try out my app and let me know what you think and if you have any issues.
I've added more fragments :P
