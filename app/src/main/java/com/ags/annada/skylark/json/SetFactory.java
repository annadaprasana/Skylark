package com.ags.annada.skylark.json;

import android.os.Parcel;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Annada on 20/10/2015.
 */
public class SetFactory {
    private static final String TAG = SetFactory.class.getSimpleName();

    /*
    private static final String JSON_UID_KEY = "uid";
    private static final String JSON_SCHEDULER_URLS_KEY = "schedule_urls";
    private static final String JSON_PUBLISH_ON_KEY = "publish_on";
    private static final String JSON_QUOTER_KEY = "quoter";
    private static final String JSON_FEATURED_KEY = "featured";
    private static final String JSON_LANGUAGE_MODIFIED_BY_KEY = "language_modified_by";
    private static final String JSON_PLANS_KEY = "plans";
    private static final String JSON_CACHED_FILM_COUNT_KEY = "cached_film_count";
    private static final String JSON_MODIFIED_BY_KEY = "modified_by";
    private static final String JSON_TEMP_ID_KEY = "temp_id";
    private static final String JSON_TITLE_KEY = "title";
    private static final String JSON_SELF_KEY = "self";
    private static final String JSON_CREATED_BY_KEY = "created_by";
    private static final String JSON_LANGUAGE_PUBLISH_ON_KEY = "language_publish_on";
    private static final String JSON_LANGUAGE_MODIFIED_KEY = "language_modified";
    private static final String JSON_HAS_PRICE_KEY = "has_price";
    private static final String JSON_SET_TYPE_URL_KEY = "set_type_url";
    private static final String JSON_TEMP_IMAGE_KEY = "temp_image";
    private static final String JSON_FILM_COUNT_KEY = "film_count";
    private static final String JSON_BODY_KEY = "body";
    private static final String JSON_LANGUAGE_VERSION_URL_KEY = "language_version_url";
    private static final String JSON_QUOTE_KEY = "quote";
    private static final String JSON_LOWEST_AMOUNT_KEY = "lowest_amount";
    private static final String JSON_FORMATTED_BODY_KEY = "formatted_body";
    private static final String JSON_IMAGE_URLS_KEY = "image_urls";
    private static final String JSON_HIERARCHY_URL_KEY = "hierarchy_url";
    private static final String JSON_SCHEDULE_URL_KEY = "schedule_url";
    private static final String JSON_ACTIVE_KEY = "active";
    private static final String JSON_SLUG_KEY = "slug";
    private static final String JSON_VERSION_NUMBER_KEY = "version_number";
    private static final String JSON_LANGUAGE_ENDS_ON_KEY = "language_ends_on";
    private static final String JSON_CREATED_KEY = "created";
    private static final String JSON_ITEMS_KEY = "items";
    private static final String JSON_LANGUAGE_VERSION_NUMBER_KEY = "language_version_number";
    private static final String JSON_MODIFIED_KEY = "modified";
    private static final String JSON_SUMMARY_KEY = "summary";
    private static final String JSON_ENDS_ON_KEY = "ends_on";
    private static final String JSON_VERSION_URL_KEY = "version_url";
    private static final String JSON_SET_TYPE_SLUG_KEY = "set_type_slug";
    */

    //Decode Set json into Set Model
    private static SetModel decodeJson(JSONObject setJson){
        Gson gson = new Gson();
        SetModel setModel = gson.fromJson(setJson.toString(), SetModel.class);

        return setModel;
    }

    //Decodes json results into arry of set model objects
    public static ArrayList<SetModel> decodeJson(JSONArray setJsonArray){
        ArrayList<SetModel> setModels = new ArrayList<SetModel>(setJsonArray.length());

        JSONObject setJson;
        SetModel setModel;

        for(int index=0; index < setJsonArray.length(); index++ ){
            try {
                setJson = setJsonArray.getJSONObject(index);

                setModel = decodeJson(setJson);

                if(setModel != null){
                    setModels.add(decodeJson(setJson));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG,e.getMessage());
                continue;
            }
        }

        return setModels;
    }
}
