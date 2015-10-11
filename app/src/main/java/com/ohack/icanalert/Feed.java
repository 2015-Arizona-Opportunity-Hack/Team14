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
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Button;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;

import io.fabric.sdk.android.Fabric;

public class Feed extends ListActivity {
    final TweetTimelineListAdapter adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent intent = getIntent();

        TwitterAuthConfig authConfig =  new TwitterAuthConfig("Y9UIuPZDC9ijnHxmvx3G7qdKl", "g9bE72th1SHQDANtVK1wCOhYwwnPJgU4gZEhP9wJkrAYyzBPBt");
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi());

        Button refresh = (Button)(findViewById(R.id.refreshBtn));

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("chrisrobeless")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);



    }
    public void refreshButton(View view){
        adapter.refresh(new Callback<TimelineResult<Tweet>>() {
            @Override
            public void success(Result<TimelineResult<Tweet>> result) {

            }

            @Override
            public void failure(View view) {
                System.out.print("fail?");
            }
        });
    }

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



}


