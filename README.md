# MVP Project

## Description

This is a project to demonstrate the use of the MVP pattern in Android.

I used it, when I teach Android in engineering schools.

## Step by step creation

1. Create a new project in Android Studio (do not check "use legacy android support library")
2. Create a new package "model" and design the associated classes (example : *Meeting*, *Person*, *Place*). A *Meeting* must at least contain *a subject*, *a date*, *a place*, and *a list of persons invited* to the meeting. A *Person* must at least includes *an email*. A *Place* must at least includes *a name*.
3. Create a new package "service". Add an interface *MeetingsApiService* with at least three methods : `List<Meeting> getMeetings()`, `void addMeeting(Meeting meeting)`, and `void deleteMeeting(Meeting meeting)`. Create an implementation class of that interface, that you named *DummyMeetingsApiService* for example.
4. Create a new package "utils". Add an utils class `DateEasy` that allows to convert a `String` to an `Instant` and vice versa (take into account the TimeZone, and the formatting). Add a `PersonsListFormatter` class that allows to convert a `List<Person>` to a `String`, formatted enough to be displayed.
5. Create a new package "di", and create the associated singleton `DI` class, that allows to get the instance of the `MeetingsApiService` everywhere in the app source code.
6. Create `DateEasyUnitTest`, and `MeetingsApiServiceUnitTest` classes, and write unit tests for the methods of the `DateEasy` and `MeetingsApiService` classes. Ensure every tests successfully pass.
7. Create a new subpackage "ui", in the "utils" package. Add a `SimpleTextWatcher` class that implements `TextWatcher`, and override not used methods `beforeTextChanged` and `onTextChanged`. Add a `SimpleTextWatcherFactory`, that allows to switch the icons of an TextInputLayout, depending if the text entered is empty (or not).
8. Create a new package "ui". Create the subpackage "pickers", that will allows the user to pick a date or a time (at meeting registration). Create a subsubpackage "date", and add a `DatePickerContract` interface which specify contract between presenter (fragment) and view, and between presenter and model. Create a subsubpackage "time", and do the same in order to create a time picker with MVP design in mind.
9. Create the subfolder "res/anim", and put `slide_down.xml` and `slide_up.xml` files in it.
10. Create the subfolder "res/menu", and create a simple menu for "add meeting" dialog, and "add persons" dialog.
11. Create the subfolder "res/layout", and create the following layout files : `activity_main.xml` (a constraint layout, simply containing an floating action button to add a meeting), `fragment_meeting_list.xml` (which contains at least a card view for the filters by date or place, and the recycler view for displaying the list), `fragment_meetings_list_item.xml` (used by the view holder to render a single meeting, so with its place, date, persons invited, and drop button), `fragment_meeting_registration.xml` (create a form with place, date, subject, in order to add a meeting. do not forget a link to allow to open an other dialog to add persons in that meeting), `fragment_add_people_dialog.xml` (a form with a single input to add the person email).
12. Create the subfolder "res/values", and create the initial following files : `colors.xml`, `dimens.xml`, `strings.xml`, and `styles.xml`.
13. Create the subpackage "add_persons", in the package "ui". Create the `AddPersonsDialogContract` interface, that specify the contract between presenter (fragment) and view, and between presenter and model. Create the `AddPersonsDialogPresenter` class, that implements the `AddPersonsDialogContract.Presenter` interface. Create the `AddPersonsDialogFragment` class, that implements the `AddPersonsDialogContract.View` interface. Do the same with the model, and create a factory to ease the creation of that UI.
14. Create the subpackage "meetings_registration", in the package "ui", and do the same logic as the previous item.
15. Create the subpackage "meetings_list", in the package "ui", and do the same logic as the previous item.
16. Create a `MeetingsListTest` in order to write instrumented tests for the `MeetingsListFragment` class. Ensure every tests successfully pass.

## Reasons to use Java for Android app

Students may ask some advantages over Kotlin to stick with Java :

- It's a very popular language (large community)
- It's a mature language (lots of libraries, and tools)
- It's easy to learn
- It's easy to find resources
- It's easy to find jobs (and not only with Android)
- It's easy to find developers
- It's easy to find meetups
- Frequent updates
- Core language of the SDK

## Demo Activity

You can add a demo activity in order to simplify some UI components demo : 

```java

package ... .mareu.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ... .mareu.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import ... .ui.pickers.date.DatePickerFactory;
import ... .ui.pickers.date.DatePickerFragment;
import ... .mareu.utils.DateEasy;

public class DemoActivity extends AppCompatActivity {
    
    // A button to open an UI date picker
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Get the fragment manager
        final FragmentManager fm = getSupportFragmentManager();
        // On click on the button, open the date picker
        button.setOnClickListener(v -> {
            // Create the date picker factory
            DatePickerFactory factory = new DatePickerFactory();
            // Get the fragment ..
            DatePickerFragment fragment = factory.getFragment(
                    DateEasy.now(),
                    null,
                    !false,
                    // on date set, notify the presenter
                    (datePicked) -> System.out.println("Selected date : " + datePicked)
            );
            // .. and display it
            fragment.display(fm);
        });
    }
}
```

