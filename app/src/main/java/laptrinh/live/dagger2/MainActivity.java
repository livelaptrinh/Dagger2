package laptrinh.live.dagger2;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import laptrinh.live.dagger2.data.DataManager;
import laptrinh.live.dagger2.data.model.User;
import laptrinh.live.dagger2.di.component.ActivityConponent;
import laptrinh.live.dagger2.di.component.DaggerActivityConponent;
import laptrinh.live.dagger2.di.module.ActivityModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;

    private ActivityConponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

   public ActivityConponent getActivityComponent(){
       if (activityComponent == null){
           activityComponent = DaggerActivityConponent
                   .builder()
                   .activityModule(new ActivityModule(this))
                   .applicationComponent(DemoApplication.get(this).getComponent())
                   .build();
       }

       return activityComponent;
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}
