package com.labs.adnromeda.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/* loaded from: classes.dex */
public class MainActivity extends ActionBarActivity {
    public int weezy = 152;

    /* JADX INFO: Access modifiers changed from: private */
    public String getUser() {
        String resp = this.weezy > 152 ? "Legolas" : "Aragon";
        this.weezy += 100;
        return resp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPass() {
        return this.weezy > 152 ? "Saruman" : "Gandalf";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.ActionBarActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.labs.adnromeda.test1.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String user = txtUsername.getText().toString();
                String pass = txtPassword.getText().toString();
                Log.i("credentials check", user + ":" + pass);
                if (user.compareTo(MainActivity.this.getUser()) == 0 && pass.compareTo(MainActivity.this.getPass()) == 0) {
                    Log.i("credentials check", "granted access");
                    Toast.makeText(MainActivity.this.getApplicationContext(), "access granted!", 0).show();
                    Intent intent = new Intent(MainActivity.this.getApplicationContext(), MainActivity2.class);
                    MainActivity.this.startActivity(intent);
                    return;
                }
                Toast.makeText(MainActivity.this.getApplicationContext(), "access denied!", 0).show();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}