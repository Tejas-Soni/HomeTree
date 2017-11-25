package hackers.com.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class HomeActivity extends AppCompatActivity  {



    TextView textmsg;
    Animation animFadein;
    ImageView imageView;
    VideoView videoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);



        textmsg=(TextView)findViewById(R.id.hometree_anim);
        imageView = (ImageView) findViewById(R.id.img_anim);
        animFadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_anim);
//        videoView = (VideoView)findViewById(R.id.vid_back_play);
//        Uri uri = Uri.parse("hy"+R.raw.videosong);
//        videoView.setVideoURI(uri);
//        videoView.start();


        textmsg.startAnimation(animFadein);
        imageView.startAnimation(animFadein);



    }
}
