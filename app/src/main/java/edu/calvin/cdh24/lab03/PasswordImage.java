/*

CS262 Lab03: This is a short app that displays a sweet NASA poster when the correct password is entered.
BTW, the password is "password"

@author: Christiaan Hazlett (cdh24)
@version: Fall 2016

 */

package edu.calvin.cdh24.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class PasswordImage extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_image);


        // Get access to protected layout
        final FrameLayout playout = (FrameLayout) findViewById(R.id.protectedLayout);
        // Hide it on load
        playout.setVisibility(FrameLayout.GONE);

        // Get the textview
        final TextView tv = (TextView) findViewById(R.id.textView);

        // Add a listener to the textfield
        EditText pwbox = (EditText) findViewById(R.id.editText);
        pwbox.addTextChangedListener(new TextWatcher() {
            // Interestingly, the other override methods need to be here, even if there isn't anything in there.
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ("password".equals(s.toString())) {
                    // Correct password
                    playout.setVisibility(FrameLayout.VISIBLE);
                    tv.setText("Correct!");
                }
                else {
                    // Incorrect password
                    playout.setVisibility(FrameLayout.GONE);
                    tv.setText("Invalid password.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
