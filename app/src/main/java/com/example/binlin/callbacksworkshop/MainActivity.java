package com.example.binlin.callbacksworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallBackFragment.CallbackClass {

    @BindView(R.id.activity_layout)
    protected ConstraintLayout layout;

    @BindView(R.id.callback_message_textView)
    protected TextView textView;


    private CallBackFragment callBackFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.lauch_fragment_button)
    protected void lauchFragment(){
        callBackFragment = CallBackFragment.newInstance();
        callBackFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, callBackFragment).commit();
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "The MainActivity is Toasting the Fragment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeTextView() {
        textView.setText("Callback from Fragment Received");
    }

    @Override
    public void changeBackgroundColor() {
        layout.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void removeFragment() {
        getSupportFragmentManager().beginTransaction().remove(callBackFragment).commit();
    }
}
