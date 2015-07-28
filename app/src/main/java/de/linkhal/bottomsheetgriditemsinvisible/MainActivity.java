package de.linkhal.bottomsheetgriditemsinvisible;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomSheetLayout bottomSheet = (BottomSheetLayout) findViewById(R.id.bottomsheet);

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final Intent shareIntent = new Intent();

                shareIntent.putExtra(Intent.EXTRA_TEXT, "hello world");
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                bottomSheet.showWithSheetView(
                        new IntentPickerSheetView(MainActivity.this,
                                shareIntent, "Share with...",
                                new IntentPickerSheetView.OnIntentPickedListener() {
                                    @Override
                                    public void onIntentPicked(Intent intent) {
                                        bottomSheet.dismissSheet();
                                        startActivity(intent);
                                    }
                                }));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
