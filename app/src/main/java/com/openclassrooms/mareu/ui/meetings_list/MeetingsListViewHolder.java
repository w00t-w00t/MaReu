package com.openclassrooms.mareu.ui.meetings_list;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.model.Meeting;
import com.openclassrooms.mareu.model.Person;
import com.openclassrooms.mareu.utils.DateEasy;
import com.openclassrooms.mareu.utils.PersonsListFormatter;

import java.util.Set;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Meetings List Item View Holder
 * Represent a single item in the list
 */
public class MeetingsListViewHolder extends RecyclerView.ViewHolder {

    /**
     * The meeting to be displayed as item of the recycler view
     */
    private Meeting mMeeting;

    /**
     * UI Components
     */

    // subject of the meeting label
    @BindView(R.id.fragment_meetings_item_subject_text)
    TextView mSubjectText;

    // button to drop a meeting
    @BindView(R.id.fragment_meetings_item_delete_btn)
    ImageButton mDeleteButton;

    // date of the meeting label
    @BindView(R.id.fragment_meetings_item_date_text)
    TextView mDateText;

    // place of the meeting label
    @BindView(R.id.fragment_meetings_item_place_text)
    TextView mPlaceText;

    // expandable card view containing the persons invited to the meeting (expand button)
    @BindView(R.id.fragment_meetings_item_expand_btn)
    ImageButton mExpandButton;

    // expandable card view containing the persons invited to the meeting (collapse button)
    @BindView(R.id.fragment_meetings_item_collapse_btn)
    ImageButton mCollapseButton;

    // list of the persons invited to the meeting label
    @BindView(R.id.fragment_meetings_item_persons_text)
    TextView mPersonsFlattenListText;

    // Empty meeting (no persons invited yet) string
    @BindString(R.string.empty_meeting_persons_list)
    String mEmptyMeetingInvitedPersonsList;

    // expandable card view containing the persons invited to the meeting (card view)
    @BindView(R.id.fragment_meetings_card_view)
    CardView mCardView;

    /**
     * Constructor
     *
     * @param itemView the view of the item
     * @param onClickListener the listener to be called when the delete button is clicked
     */
    public MeetingsListViewHolder(@NonNull View itemView,
                                  MeetingsListAdapter.DropClickListener onClickListener) {
        // always call super constructor
        super(itemView);
        // bind the ui components to java code
        ButterKnife.bind(this, itemView);
        // call the listener when the delete button is clicked
        mDeleteButton.setOnClickListener(
                v -> onClickListener.onClick(v, getLayoutPosition())
        );
        // call the listener when the expand button is clicked
        mExpandButton.setOnClickListener(v -> expandOrCollapseInvitedPersons());
        // call the listener when the collapse button is clicked
        mCollapseButton.setOnClickListener(v -> expandOrCollapseInvitedPersons());
        // set the click listener on the whole item (show/hide given meeting details)
        itemView.setOnClickListener(v -> expandOrCollapseInvitedPersons());
    }

    /**
     * Set the meeting to be displayed as item of the recycler view
     * @param meeting the meeting to be displayed as item of the recycler view
     */
    public void setMeeting(Meeting meeting) {
        // set the meeting to display
        mMeeting = meeting;
        // update the ui accordingly (date, subject, place)
        mDateText.setText(DateEasy.localeSpecialStringFromInstant(meeting.getDate()));
        mSubjectText.setText(meeting.getSubject());
        mPlaceText.setText(meeting.getPlace().getName());
        // update the persons invited to the meeting list
        setPersonsList();
    }

    /**
     * Handle the expandable card view, that display the persons list
     */
    private void expandOrCollapseInvitedPersons() {
        // if the card view is collapsed, expand it
        if (mPersonsFlattenListText.getVisibility() == View.GONE) {
            // show the persons list
            mPersonsFlattenListText.setVisibility(View.VISIBLE);
            // show the collapse button
            mCollapseButton.setVisibility(View.VISIBLE);
            // hide the expand button
            mExpandButton.setVisibility(View.GONE);
        } else {
            // else collapse it
            mPersonsFlattenListText.setVisibility(View.GONE);
            // hide the collapse button
            mCollapseButton.setVisibility(View.GONE);
            // show the expand button
            mExpandButton.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Set the list of persons invited to the meeting in the UI
     */
    private void setPersonsList() {
        // get persons
        Set<Person> persons = mMeeting.getPersons();
        // create persons formatter
        PersonsListFormatter personsListFormatter = new PersonsListFormatter(persons);
        // if persons list is empty, display a message
        if(persons.isEmpty()) {
            mPersonsFlattenListText.setText(mEmptyMeetingInvitedPersonsList);
        } else {
            // else, display persons list
            mPersonsFlattenListText.setText(personsListFormatter.format());
        }
    }

}
