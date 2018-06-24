package com.example.likhit.g_steam.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.likhit.g_steam.R;

import com.example.likhit.g_steam.adapter.MessagesAdapter;
import com.example.likhit.g_steam.adapter.MyListAdapter;
import com.example.likhit.g_steam.helper.MySingelton;
import com.example.likhit.g_steam.model.GameList;
import com.example.likhit.g_steam.model.Message;
import com.example.likhit.g_steam.network.ApiClient;
import com.example.likhit.g_steam.network.ApiInterface;
import com.example.likhit.g_steam.network.JSONParse;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, MessagesAdapter.MessageAdapterListener {

    List<GameList> mDataset;
    public static final String json_url = "http://store.steampowered.com/api/appdetails/?appids=271590";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //////////////
    private List<Message> messages = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessagesAdapter mmAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
   // private ActionModeCallback actionModeCallback;
    private ActionMode actionMode;
    //////////////

    public HomeFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //mRecyclerView = (RecyclerView)getView().findViewById(R.id.my_recycler_view);
        //mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //sendRequest();
        //sendRequest();
        mDataset=new ArrayList<>();
        mAdapter = new MyListAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

        prepareGameData();
        /*////////////////
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);

        mmAdapter = new MessagesAdapter(getActivity(), messages, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mmAdapter);

       // actionModeCallback = new ActionModeCallback();

        // show loader and fetch messages
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        getInbox();
                    }
                }
        );
        ///////////*/


    }

    private void prepareGameData() {
        GameList game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        game = new GameList("Fun Hospital", "https://steamcdn-a.akamaihd.net/steam/apps/829420/header.jpg?t=1529631662");
        mDataset.add(game);

        mAdapter.notifyDataSetChanged();
    }

    ////////////////////////////////
    private void getInbox() {
        swipeRefreshLayout.setRefreshing(true);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Message>> call = apiService.getInbox();
        call.enqueue(new Callback<List<Message>>() {

            @Override
            public void onResponse(Call<List<Message>> call, retrofit2.Response<List<Message>> response) {
                // clear the inbox
                messages.clear();

                // add all the messages
                // messages.addAll(response.body());

                // TODO - avoid looping
                // the loop was performed to add colors to each message
                //for (Message message : response.body()) {
                // generate a random color
                //message.setColor(getRandomMaterialColor("400"));
                //  messages.add(message);
                // }

                mAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }



            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        // swipe refresh is performed, fetch the messages again
        getInbox();
    }

    @Override
    public void onIconClicked(int position) {
        //if (actionMode == null) {
       //     actionMode = startSupportActionMode(actionModeCallback);
        //}

       // toggleSelection(position);
    }

    @Override
    public void onIconImportantClicked(int position) {
        // Star icon is clicked,
        // mark the message as important
        Message message = messages.get(position);
        message.setImportant(!message.isImportant());
        messages.set(position, message);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMessageRowClicked(int position) {
        // verify whether action mode is enabled or not
        // if enabled, change the row state to activated
        //if (mAdapter.getSelectedItemCount() > 0) {
         //   enableActionMode(position);
        //} else {
            // read the message which removes bold from the row
       //     Message message = messages.get(position);
        //    message.setRead(true);
         //   messages.set(position, message);
            //mAdapter.notifyDataSetChanged();

          //  Toast.makeText(getApplicationContext(), "Read: " + message.getMessage(), Toast.LENGTH_SHORT).show();
       // }
    }

    @Override
    public void onRowLongClicked(int position) {
        // long press is performed, enable action mode
       // enableActionMode(position);
    }


    ////////////////////////////////
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_home,container,false);

        return rootview;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void sendRequest(){

        StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET,"https://store.steampowered.com/api/appdetails/?appids=829420",
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        //for(int count=0;count<response.length();count++)
                        if (response != null) {
                            try {
                                //JSONObject jsonObject=response.getJSONObject(count);
                                JSONObject jb = new JSONObject(response);
                                JSONObject id= jb.getJSONObject("829420");
                                JSONObject dat=id.getJSONObject("data");
                                JSONParse pj = new JSONParse(dat);
                                pj.parseJSON();
                                mDataset = pj.getGames();
                                mAdapter = new MyListAdapter(mDataset);
                                mRecyclerView.setAdapter(mAdapter);
                                //appNames.add(jsonObject.getString("appname"));
                                //imgid.add(count);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                    }
                },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        }
        );

//The following lines add the request to the volley queue
//These are very important
        //MySingelton.getInstance().addToRequestQueue(jsonObjectRequest);
       RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);
    }
}
