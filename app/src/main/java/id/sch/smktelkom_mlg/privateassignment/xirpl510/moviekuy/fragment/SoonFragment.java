package id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.adapter.Soon;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.model.ResultsRespons;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl510.moviekuy.service.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 */
public class SoonFragment extends Fragment {



    ArrayList<Results> mlist = new ArrayList<>();
    Soon myUpcom;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_soon, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view_soon);
        rv.setHasFixedSize(true);
        myUpcom = new Soon(this, mlist, getContext());
        rv.setAdapter(myUpcom);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataResource();

        return rootView;
    }

    private void downloadDataResource() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=9d4ef824d45886432d634bd6290346f8&language=en-US&page=1";

        GsonGetRequest<ResultsRespons> myRequest = new GsonGetRequest<ResultsRespons>
                (url, ResultsRespons.class, null, new Response.Listener<ResultsRespons>() {

                    @Override
                    public void onResponse(ResultsRespons response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        mlist.addAll(response.results);
                        myUpcom.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }



}
