package com.schiztech.rovers.api;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;


public class RoversActionBuilder
{
    //region Action Fields
    private Intent mIntent = null;
    private Intent.ShortcutIconResource mIconResource = null;
    private Bitmap mIcon = null;
    private String mLabel = null;
    private int mColor = Color.WHITE;
    private boolean mIsColorChangeable = true;
    private boolean mIsIconChangeable = true;
    private static final int sApiVersion = 1;
    //endregion Action Fields

    //region Action Intent Keys
    public static final String KEY_INTENT = "rovers_action_key_intent";
    public static final String KEY_ICON_RESOURCE = "rovers_action_key_icon_resource";
    public static final String KEY_ICON= "rovers_action_key_icon";
    public static final String KEY_LABEL= "rovers_action_key_label";
    public static final String KEY_COLOR = "rovers_action_key_color";
    public static final String KEY_IS_COLOR_CHANGEABLE = "rovers_action_key_is_color_changeable";
    public static final String KEY_IS_ICON_CHANGEABLE = "rovers_action_key_is_icon_changeable";
    public static final String KEY_API_VERSION  = "rovers_action_key_api_version";
    //endregion Action Intent Keys

    protected RoversActionBuilder(){}
    public static RoversActionBuilder build(){
        return new RoversActionBuilder();
    }

    public RoversActionBuilder setIntent(Intent intent){
        mIntent = intent;
        return this;
    }

    public RoversActionBuilder setIconResource(Intent.ShortcutIconResource iconResource){
        mIconResource = iconResource;
        return this;
    }

    public RoversActionBuilder setIcon(Bitmap icon){
        mIcon = icon;
        return this;
    }

    public RoversActionBuilder setLabel(String label){
        mLabel = label;
        return this;
    }

    public RoversActionBuilder setColor(int color){
        mColor = color;
        return this;
    }

    public RoversActionBuilder setIsColorChangeable(boolean isColorChangeable){
        mIsColorChangeable = isColorChangeable;
        return this;
    }

    public RoversActionBuilder setIsIconChangeable(boolean isIconChangeable){
        mIsIconChangeable = isIconChangeable;
        return this;
    }

    public Intent create(){
        //region Validation
        if(mIntent == null)
            throw new IllegalArgumentException("Rover action must have a valid intent");

        if(mIconResource == null && mIcon == null){
            throw new IllegalArgumentException("Rover action must have either bitmap icon or icon resource");
        }

        //endregion Validation

        Intent intent = new Intent();
        intent.putExtra(this.KEY_API_VERSION, sApiVersion);

        intent.putExtra(KEY_INTENT, mIntent);
        intent.putExtra(KEY_ICON_RESOURCE, mIconResource);
        intent.putExtra(KEY_ICON, mIcon);
        intent.putExtra(KEY_LABEL, mLabel);
        intent.putExtra(KEY_COLOR, mColor);
        intent.putExtra(KEY_IS_COLOR_CHANGEABLE, mIsColorChangeable);
        intent.putExtra(KEY_IS_ICON_CHANGEABLE, mIsIconChangeable);

        return intent;
    }
}
