package com.schiztech.rovers.example.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.schiztech.rovers.api.RoversActionBuilder;


public class CreateActionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent.ShortcutIconResource iconResource =
                Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_action_roveraction);


        Intent launchIntent = new Intent(this, LaunchedActivity.class);

        Intent result = RoversActionBuilder.build()
                .setColor(getResources().getColor(R.color.material_deep_teal_200))
                .setIconResource(iconResource)
                .setLabel(getResources().getString(R.string.action_name))
                .setIntent(launchIntent)
                .create();

        setResult(RESULT_OK, result);

        finish();

    }

}
