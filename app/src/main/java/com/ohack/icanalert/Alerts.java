package com.ohack.icanalert;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUi;

import io.fabric.sdk.android.Fabric;

public class Alerts extends ListActivity {
    private int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        Intent intent = getIntent();
        language = intent.getIntExtra("language", 3);

        TwitterAuthConfig authConfig =  new TwitterAuthConfig("Y9UIuPZDC9ijnHxmvx3G7qdKl", "g9bE72th1SHQDANtVK1wCOhYwwnPJgU4gZEhP9wJkrAYyzBPBt");
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi());

        if (language == 0) {
            final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                    .query("#alert,from:chrisrobeless")
                    .build();
            final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                    .setTimeline(searchTimeline)
                    .build();
            setListAdapter(adapter);
        }
        else if (language == 1){
            final SearchTimeline searchTimeline = new SearchTimeline.Builder()
                    .query("#alert,from:chrisrobeless")
                    .build();
            final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
                    .setTimeline(searchTimeline)
                    .build();
            setListAdapter(adapter);
        }

    }

}
