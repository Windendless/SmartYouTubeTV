package com.liskovsoft.smartyoutubetv.bootstrap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.liskovsoft.smartyoutubetv.R;
import com.liskovsoft.smartyoutubetv.misc.LangUpdater;

public class BootstrapActivity extends FullscreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new LangUpdater(this).update();
        setContentView(R.layout.activity_bootstrap);
    }

    public void selectFlavour(View view) {
        switch (view.getId()) {
            case R.id.button_webview:
                startActivity(this, com.liskovsoft.smartyoutubetv.flavors.webview.SmartYouTubeTVActivity.class);
                break;
            case R.id.button_xwalk:
                startActivity(this, com.liskovsoft.smartyoutubetv.flavors.xwalk.SmartYouTubeTVActivity.class);
                break;
            case R.id.button_exo:
                startActivity(this, com.liskovsoft.smartyoutubetv.flavors.exoplayer.SmartYouTubeTVActivity.class);
                break;
            case R.id.button_exo2:
                startActivity(this, com.liskovsoft.smartyoutubetv.flavors.exoplayer.SmartYouTubeTVActivity2.class);
                break;
        }
    }
    
    private void startActivity(Context ctx, Class clazz) {
        Intent intent = new Intent();
        // NOTE: make activity transparent (non-reachable from launcher or resents)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setClass(ctx, clazz);
        startActivity(intent);
    }
}
