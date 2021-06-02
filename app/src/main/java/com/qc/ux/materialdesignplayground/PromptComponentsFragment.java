package com.qc.ux.materialdesignplayground;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.qc.ux.materialdesignplayground.databinding.FragmentPromptComponentsBinding;

public class PromptComponentsFragment extends Fragment {
    private final String LOG_TAG = PromptComponentsFragment.class.getSimpleName();
    private FragmentPromptComponentsBinding fragmentPromptsBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        fragmentPromptsBinding = FragmentPromptComponentsBinding.inflate(inflater, container, false);
        fragmentPromptsBinding.dialogAlert.setOnClickListener(onClickListener);
        fragmentPromptsBinding.dialogSimple.setOnClickListener(onClickListener);
        fragmentPromptsBinding.dialogConfirmation.setOnClickListener(onClickListener);
        fragmentPromptsBinding.snackbarShow.setOnClickListener(onClickListener);
        fragmentPromptsBinding.bottomSheetShow.setOnClickListener(onClickListener);

        return fragmentPromptsBinding.getRoot();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.dialogAlert:
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle(getResources().getString(R.string.dialog_title))
                            .setMessage(getResources().getString(R.string.dialog_supporting_text))
                            .setNeutralButton(getResources().getString(R.string.dialog_cancel), (dialogInterface, i) -> { })
                            .setPositiveButton(getResources().getString(R.string.dialog_accept), (dialogInterface, i) -> { })
                            .setNegativeButton(getResources().getString(R.string.dialog_decline), (dialogInterface, i) -> { })
                            .show();
                    break;
                case R.id.dialogSimple:
                    String[] itemsSimple = getResources().getStringArray(R.array.items);
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle(getResources().getString(R.string.dialog_title))
                            .setItems(itemsSimple, (dialog, which) -> {})
                            .show();
                    break;
                case R.id.dialogConfirmation:
                    String[] itemsConfirmation = getResources().getStringArray(R.array.items);
                    new MaterialAlertDialogBuilder(getContext())
                            .setTitle(getResources().getString(R.string.dialog_title))
                            .setNeutralButton(getResources().getString(R.string.dialog_cancel), (dialogInterface, i) -> { })
                            .setPositiveButton(getResources().getString(R.string.dialog_ok), (dialogInterface, i) -> { })
                            .setSingleChoiceItems(itemsConfirmation, 0, (dialog, which) -> {})
                            .show();
                    break;
                case R.id.snackbarShow:
                    Snackbar snackbar = Snackbar.make(fragmentPromptsBinding.getRoot(), getResources().getString(R.string.snackbard_message), Snackbar.LENGTH_LONG);
                    snackbar.setAction(getResources().getString(R.string.snackbard_action), v -> snackbar.dismiss());
                    snackbar.show();
                    break;
                case R.id.bottomSheetShow:
                    BottomSheetFragment bottomSheetFragment =
                            BottomSheetFragment.newInstance();
                    bottomSheetFragment.show(getChildFragmentManager(), "");
                    break;
            }
        }
    };
}
