package com.example.user.expandrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<FormsList> formList =  new ArrayList<>() ;
    private GenreAdapter adapter;
    private RecyclerView mrecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = (RecyclerView) findViewById(R.id.form_recycler_view);
        mrecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutManager);

        try {
            loadJsonFromAsset();

            load_form_data();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //To get the json file data
    public String loadJsonFromAsset() throws IOException {
        String json = null;
        InputStream is = getAssets().open("forms.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer,"UTF-8");
        return json;
    }


    public void load_form_data()
    {

        try {
            JSONObject jsonObject = new JSONObject(loadJsonFromAsset());

            String Device = jsonObject.getString("Device");
            String StatusCode = jsonObject.getString("StatusCode");

            JSONArray formArray = jsonObject.getJSONArray("forms");
            Log.d("FORMAR ","FORMAR "+formArray);
            for(int index=0; index < formArray.length(); index++)
            {
                JSONObject obj = formArray.getJSONObject(index);
                Log.d("ISNEIR ","ISNEIR "+obj);
                FormsList formsList = new FormsList();
                formsList.setFormId(obj.getString("formId"));
                formsList.setFormType(obj.getString("formType"));

                String formPrefill = obj.getString("FormPreFill");

                //If the formPrefill object is not empty
                List<FormPreFillData> fromPrefillList = new ArrayList<>();

                if(!formPrefill.equals("") || !formPrefill.isEmpty())
                {
                    JSONObject formPrefillobj = new JSONObject(formPrefill);
                    JSONArray formPrefillDataArray = formPrefillobj.getJSONArray("FormPreFillData");
                    Log.d("FORMPREFILLDATAARRA","FORMPREFILLDATAARRA"+formPrefillDataArray);



                    for(int index1=0; index1 < formPrefillDataArray.length(); index1++)
                    {

                        JSONObject FormPreFillDataobj = formPrefillDataArray.getJSONObject(index1);
                        Log.d("IDADD ","IDADD "+FormPreFillDataobj);
                        FormPreFillData formPreFillData = new FormPreFillData();
                        formPreFillData.setPreFillkey(FormPreFillDataobj.getString("PreFillkey"));
                        formPreFillData.setPrefilldescription(FormPreFillDataobj.getString("Prefilldescription"));

                        fromPrefillList.add(formPreFillData);

                    }

                }
                formsList.setFormURL(obj.getString("formURL"));
                formsList.setFormLinkURL(obj.getString("formLinkURL"));
                formsList.setFormName(obj.getString("formName"));
                formsList.setToken(obj.getString("Token"));
                formsList.setFormPreFillList(fromPrefillList);

                formList.add(formsList);

                Log.d("SOZEDFDF ","SOZEDFDF "+fromPrefillList.size() + "FORNMSULKST "+formList.size());

            }


            List<Genre> genres = getGenres();
            adapter = new GenreAdapter(genres);
            mrecyclerView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }


    public List<Genre> getGenres() {

        List<Genre> genreList = new ArrayList<>();
        for(int index=0; index < formList.size(); index++)
        {
            Genre genre = new Genre(formList.get(index).getFormName(),index,formList.get(index).getFormPreFillList());
            genreList.add(genre);

        }

        return genreList;
    }
}
