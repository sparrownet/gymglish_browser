package com.davidi.gymglishbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dror on 24-Jun-16.
 */
public class LinksActivity extends Activity {

    private ListView mLinksListView;
    private LinkAdapter mLinksAdapter;
    private ArrayList<Link> mLinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        // generate links list
        generateLinksList();

        mLinksListView = (ListView) findViewById(R.id.list_links);
        mLinksAdapter = new LinkAdapter(this, mLinks);
        mLinksListView.setAdapter(mLinksAdapter);

        mLinksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ConnectivityManager cm =
                        (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();

                if (isConnected) {
                    Link selectedLink = mLinks.get(position);
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra(WebActivity.URL, selectedLink.getUrl());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.err_msg_internet), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void generateLinksList() {
        mLinks.add(new Link("Gymglish Home", "https://www.gymglish.com/"));
        mLinks.add(new Link("Frantastique", "https://www.frantastique.com/"));
        mLinks.add(new Link("Vate Faire Conjuguer", "http://www.vatefaireconjuguer.com/"));
        mLinks.add(new Link("The Word of the Month", "http://www.thewordofthemonth.com/en/word/blue"));
        mLinks.add(new Link("Allez Vous Faire Conjuguer", "http://www.allezvousfaireconjuguer.com/"));
    }
}
