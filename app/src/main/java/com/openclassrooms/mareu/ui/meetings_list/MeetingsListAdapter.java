package com.openclassrooms.mareu.ui.meetings_list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.model.Meeting;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Meetings List Adapter
 */
public class MeetingsListAdapter extends RecyclerView.Adapter<MeetingsListViewHolder> {

    /**
     * Small interface to handle drop click on a meeting
     */
    public interface DropClickListener {
        void onClick(View v, int position);
    }

    /**
     * The list of meetings to be displayed
     */
    private List<Meeting> mMeetings;

    /**
     * The listener to be notified when a meeting is dropped
     */
    private final DropClickListener mOnDropClickListener;

    /**
     * Constructor
     *
     * @param meetings the list of meetings to be displayed
     * @param onDropClickListener the listener to be notified when a meeting is dropped
     */
    public MeetingsListAdapter(List<Meeting> meetings, DropClickListener onDropClickListener) {
        mOnDropClickListener = onDropClickListener;
        setMeetings(meetings);
    }

    /**
     * Create the view holder, that will be used to display a meeting
     *
     * @param parent the parent view
     * @param viewType the view type
     * @return
     */
    @NonNull
    @Override
    public MeetingsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // context of the parent view
        Context context = parent.getContext();
        // inflate the view holder layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_mettings_list_item, parent, false);
        // return the view holder
        return new MeetingsListViewHolder(view, mOnDropClickListener);
    }

    /**
     * Update the view holder with the meeting to be displayed
     *
     * @param holder the view holder
     * @param position the position in order to get the corresponding meeting to be displayed
     */
    @Override
    public void onBindViewHolder(@NonNull MeetingsListViewHolder holder, int position) {
        holder.setMeeting(mMeetings.get(position));
    }

    /**
     * Get the number of meetings to be displayed
     *
     * @return the number of meetings to be displayed
     */
    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    /**
     * Set the list of meetings to be displayed
     * @param meetings the list of meetings to be displayed
     */
    @SuppressLint("NotifyDataSetChanged")
    public void updateMeetings(List<Meeting> meetings) {
        // set the list of meeting to be displayed
        setMeetings(meetings);
        // notify the data set changed globally
        notifyDataSetChanged();
    }

    /**
     * Setter for the list of meetings to be displayed
     * @param meetings the list of meetings to be displayed
     */
    private void setMeetings(List<Meeting> meetings) {
        mMeetings = checkNotNull(meetings);
    }

}

