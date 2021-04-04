package com.example.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import static java.util.jar.Attributes.Name.CONTENT_TYPE;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        selectContent("123", "dog", "imge");

        event("12234", "tee");
    }

    void selectContent(String id, String name, String CONTENT_TYPE) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }


    void event(String id,String name){
        Bundle eventBundle = new Bundle();
        eventBundle.putString("name", name);
        eventBundle.putString("id", id);
        mFirebaseAnalytics.logEvent("event", eventBundle );
    }


}