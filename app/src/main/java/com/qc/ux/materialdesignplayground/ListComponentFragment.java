package com.qc.ux.materialdesignplayground;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.qc.ux.materialdesignplayground.databinding.FragmentListComponentBinding;

import java.util.ArrayList;

public class ListComponentFragment extends Fragment implements SampleDataListAdapter.SampleDataLongClickListener {
    private final String LOG_TAG = ListComponentFragment.class.getSimpleName();
    private FragmentListComponentBinding fragmentListComponentBinding;
    private ActionModeCallback actionModeCallback;
    private ActionMode actionMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
        actionModeCallback = new ActionModeCallback();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        fragmentListComponentBinding = FragmentListComponentBinding.inflate(inflater, container, false);

        ArrayList<SampleDataItemModel> sampleDataItems = new ArrayList<>();
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));
        sampleDataItems.add(new SampleDataItemModel("Title", "Secondary test"));

        SampleDataListAdapter sampleDataListAdapter = new SampleDataListAdapter(sampleDataItems, ListComponentFragment.this);
        fragmentListComponentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(fragmentListComponentBinding.recyclerView.getContext()));
        fragmentListComponentBinding.recyclerView.setAdapter(sampleDataListAdapter);
        sampleDataListAdapter.notifyDataSetChanged();

        return fragmentListComponentBinding.getRoot();
    }

    @Override
    public void onItemLongClick(int position) {
        if (actionMode == null) {
            actionMode = ((AppCompatActivity) getActivity()).startSupportActionMode(actionModeCallback);
        }
    }

    private class ActionModeCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextual_action_bar, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.share:
                    return true;
                case R.id.delete:
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    }
}
