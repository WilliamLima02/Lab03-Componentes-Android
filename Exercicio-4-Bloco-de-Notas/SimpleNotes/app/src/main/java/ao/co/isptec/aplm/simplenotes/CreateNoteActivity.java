package ao.co.isptec.aplm.simplenotes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CreateNoteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 32, 24, 24);

        EditText title = new EditText(this);
        title.setHint("Título da nota");
        layout.addView(title);

        EditText content = new EditText(this);
        content.setHint("Texto da nota");
        content.setGravity(Gravity.TOP);
        content.setMinLines(6);
        layout.addView(content, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        LinearLayout buttons = new LinearLayout(this);

        Button ok = new Button(this);
        ok.setText("OK");
        ok.setOnClickListener(v -> {
            String noteTitle = title.getText().toString().trim();
            if (noteTitle.isEmpty()) {
                title.setError("Introduza um título");
                return;
            }
            NoteRepository.add(new Note(noteTitle, content.getText().toString().trim()));
            finish();
        });

        Button cancel = new Button(this);
        cancel.setText("Cancel");
        cancel.setOnClickListener(v -> finish());

        buttons.addView(ok, new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        buttons.addView(cancel, new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        layout.addView(buttons);
        setContentView(layout);
    }
}
