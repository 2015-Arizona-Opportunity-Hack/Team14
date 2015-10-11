package com.ohack.icanalert;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.UserTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

import io.fabric.sdk.android.Fabric;

public class Feed extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();

        TwitterAuthConfig authConfig =  new TwitterAuthConfig("Y9UIuPZDC9ijnHxmvx3G7qdKl", "g9bE72th1SHQDANtVK1wCOhYwwnPJgU4gZEhP9wJkrAYyzBPBt");
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi());



        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("chrisrobeless")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

}
