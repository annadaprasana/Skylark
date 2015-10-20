package com.ags.annada.skylark.json;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Annada on 20/10/2015.
 */
public class SetModel{
    private static final String TAG = SetModel.class.getSimpleName();

    private String mUid;
    private String[] mSchedule_urls;
    private String mPublish_on;
    private String mQuoter;
    private boolean mFeatured;
    private String mLanguage_modified_by;
    private String[] mPlans;
    private int mCached_film_count;
    private String mModified_by;
    private int mTemp_id;
    private String mTitle;
    private String mSelf;
    private String mCreated_by;
    private String mLanguage_publish_on;
    private String mLanguage_modified;
    private boolean mHas_price;
    private String mSet_type_url;
    private String mTemp_image;
    private int mFilm_count;
    private String mBody;
    private String mLanguage_version_url;
    private String mQuote;
    private double mLowest_amount;
    private String mFormatted_body;
    private String[] mImage_urls;
    private String mHierarchy_url;
    private String mSchedule_url;
    private boolean mActive;
    private String mSlug;
    private int mVersion_number;
    private String mLanguage_ends_on;
    private String mCreated;
    private String[] mItems;
    private int mLanguage_version_number;
    private String mModified;
    private String mSummary;
    private String mEnds_on;
    private String mVersion_url;
    private String mSet_type_slug;


    public String getUid(){return this.mUid;}

    public void setUid(String uid){this.mUid = uid;}

    public String[] getSchedule_urls(){return this.mSchedule_urls;}

    public void setSchedule_urls(String[] schedule_urls){this.mSchedule_urls = schedule_urls;}

    public String getPublish_on(){return this.mPublish_on;}

    public void setPublish_on(String publish_on){this.mPublish_on = publish_on;}

    public String getQuoter(){return this.mQuoter;}

    public void setQuoter(String quoter){this.mQuoter = quoter;}

    public boolean getFeatured(){return this.mFeatured;}

    public void setFeatured(boolean featured){this.mFeatured = featured;}

    public String getLanguage_modified_by(){return this.mLanguage_modified_by;}

    public void setLanguage_modified_by(String language_modified_by){this.mLanguage_modified_by = language_modified_by;}

    public String[] getPlans(){return this.mPlans;}

    public void setPlans(String[] plans){this.mPlans = plans;}

    public int getCached_film_count(){return this.mCached_film_count;}

    public void setCached_film_count(int cached_film_count){this.mCached_film_count = cached_film_count;}

    public String getModified_by(){return this.mModified_by;}

    public void setModified_by(String modified_by){this.mModified_by = modified_by;}

    public int getTemp_id(){return this.mTemp_id;}

    public void setTemp_id(int temp_id){this.mTemp_id = temp_id;}

    public String getTitle(){return this.mTitle;}

    public void setTitle(String title){this.mTitle = title;}

    public String getSelf(){return this.mSelf;}

    public void setSelf(String self){this.mSelf = self;}

    public String getCreated_by(){return this.mCreated_by;}

    public void setCreated_by(String created_by){this.mCreated_by = created_by;}

    public String getLanguage_publish_on(){return this.mLanguage_publish_on;}

    public void setLanguage_publish_on(String language_publish_on){this.mLanguage_publish_on = language_publish_on;}

    public String getLanguage_modified(){return this.mLanguage_modified;}

    public void setLanguage_modified(String language_modified){this.mLanguage_modified = language_modified;}


    public boolean getHas_price(){return this.mHas_price;}

    public void setHas_price(boolean has_price){this.mHas_price = has_price;}

    public String getSet_type_url(){return this.mSet_type_url;}

    public void setSet_type_url(String set_type_url){this.mSet_type_url = set_type_url;}

    public String getTemp_image(){return this.mTemp_image;}

    public void setTemp_image(String temp_image){this.mTemp_image = temp_image;}

    public int getFilm_count(){return this.mFilm_count;}

    public void setFilm_count(int film_count){this.mFilm_count = film_count;}

    public String getBody(){return this.mBody;}

    public void setBody(String body){this.mBody = body;}

    public String getLanguage_version_url(){return this.mLanguage_version_url;}

    public void setLanguage_version_url(String language_version_url){this.mLanguage_version_url = language_version_url;}

    public String geQuote(){return this.mQuote;}

    public void setQuote(String quote){this.mQuote = quote;}

    public double getLowest_amount(){return this.mLowest_amount;}

    public void setLowest_amount(double lowest_amount){this.mLowest_amount = lowest_amount;}

    public String getFormatted_body(){return this.mFormatted_body;}

    public void setFormatted_body(String formatted_body){this.mFormatted_body = formatted_body;}

    public String[] getImage_urls(){return this.mImage_urls;}

    public void setImage_urls(String[] image_urls){this.mImage_urls = image_urls;}

    public String getHierarchy_url(){return this.mHierarchy_url;}

    public void setHierarchy_url(String hierarchy_url){this.mHierarchy_url = hierarchy_url;}

    public String getSchedule_url(){return this.mSchedule_url;}

    public void setSchedule_url(String schedule_url){this.mSchedule_url = schedule_url;}

    public boolean getActive(){return this.mActive;}

    public void setActive(boolean active){this.mActive = active;}

    public String getSlug(){return this.mSlug;}

    public void setSlug(String slug){this.mSlug = slug;}

    public int getVersion_number(){return this.mVersion_number;}

    public void setVersion_number(int version_number){this.mVersion_number = version_number;}

    public String getLanguage_ends_on(){return this.mLanguage_ends_on;}

    public void setLanguage_ends_on(String language_ends_on){this.mLanguage_ends_on = language_ends_on;}

    public String getCreated(){return this.mCreated;}

    public void setCreated(String created){this.mCreated = created;}

    public String[] getItems(){return this.mItems;}

    public void setItems(String[] items){this.mItems = items;}

    public int getLanguage_version_number(){return this.mLanguage_version_number;}

    public void setLanguage_version_number(int language_version_number){this.mLanguage_version_number = language_version_number;}

    public String getModified(){return this.mModified;}

    public void setModified(String modified){this.mModified = modified;}

    public String getSummary(){return this.mSummary;}

    public void setSummary(String summary){this.mSummary = summary;}

    public String getEnds_on(){return this.mEnds_on;}

    public void setEnds_on(String ends_on){this.mEnds_on = ends_on;}

    public String getVersion_url(){return this.mVersion_url;}

    public void setVersion_url(String version_url){this.mVersion_url = version_url;}

    public String getSet_type_slug() {
        return this.mSet_type_slug;}

    public void setSet_type_slug(String set_type_slug){this.mSet_type_slug = set_type_slug;
    }

}
