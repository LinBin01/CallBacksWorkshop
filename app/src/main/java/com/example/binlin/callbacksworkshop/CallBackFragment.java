package com.example.binlin.callbacksworkshop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CallBackFragment extends Fragment {

    private CallbackClass callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // use layout creator to associate it with this particular fragment
        View view = inflater.inflate(R.layout.fragment_callback,container,false);
        // this tells the ButterKnife library to bind the variable in this class to the specified view from above
        ButterKnife.bind(this, view);

        // this takes the view object we created and associate it with this fragment
        return view;
    }


    // required to be able to instantiate the fragment for use
    // GENERATED FOR US WHEN TYPING IN 'NEW' AND SELECTING newInstance()
    public static CallBackFragment newInstance() {

        Bundle args = new Bundle();

        CallBackFragment fragment = new CallBackFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.toast_callback_button)
    protected void createToast(){
        callback.showToast();

    }


    @OnClick(R.id.change_textview_button)
    protected void changeTextView(){
        callback.changeTextView();
    }


    @OnClick(R.id.change_background_callback_button)
    protected void changeBackground(){
        callback.changeBackgroundColor();
    }

    @OnClick(R.id.remove_callback_button)
    protected void removeCallback(){
        callback.removeFragment();
    }



    // allow the callback class to be used or 'called' from the classes that implement it.
    public void attachParent(CallbackClass callback){
        this.callback = callback;

    }

    // Inner interface class that allows data to be sent from this fragment to any class that implements it.
    public interface CallbackClass {

        void showToast();

        void changeTextView();

        void changeBackgroundColor();

        void removeFragment();
    }
}
