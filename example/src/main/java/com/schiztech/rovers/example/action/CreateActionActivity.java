package com.schiztech.rovers.example.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.schiztech.rovers.api.RoversActionBuilder;


public class CreateActionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //pre-created an shortcut icon - just like on regular Android shortcuts
        Intent.ShortcutIconResource iconResource =
                Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_action_roveraction);


        //create the intent to be launched when the Rovers Action is triggered
        Intent launchIntent = new Intent(this, LaunchedActivity.class);

        Intent roversActionIntent = RoversActionBuilder.build()
                .setColor(getResources().getColor(R.color.material_deep_teal_200)) //sets the default color of the Rovers Action
                .setIsColorChangeable(true)//determines if the user can change the default COLOR to another
                .setIconResource(iconResource)//sets the default icon for the Rovers Action
                //.setIcon(BITMAP object) //the default icon could also be a bitmap icon which will be cut to oval automatically by Rovers.
                .setIsIconChangeable(true)//determines if the user can change the default ICON to another
                .setLabel(getResources().getString(R.string.rovers_action_name))//the name of the Rovers Action, such as 'Call Home'
                .setIntent(launchIntent)//the intent to be launched
                .create();


        //just like a regular Android shortcut, the Rovers Action is created by a Result activity.
        // The created action is transformed into an intent which will be sent to rovers as the result.
        setResult(RESULT_OK, roversActionIntent);

        finish();

    }

}
