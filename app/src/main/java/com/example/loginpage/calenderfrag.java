package com.example.loginpage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Date;

public class calenderfrag extends Fragment {
    private View view;
    private CalendarView cv;

    @Override
    public void onStart() {
        super.onStart();
        Date date = new Date();
        long lng = date.getTime();
        cv = view.findViewById(R.id.calendarView);
        cv.setDate(lng);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calenderfrag, container, false);
        return view;
    }
}