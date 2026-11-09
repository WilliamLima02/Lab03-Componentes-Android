package ao.co.isptec.aplm.simplenotes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadNoteActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra("note_position", -1);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 32, 24, 24);

        if (position >= 0 && position < NoteRepository.getAll().size()) {
            Note note = NoteRepository.get(position);

            TextView title = new TextView(this);
            title.setText(note.getTitle());
            title.setTextSize(24);
            layout.addView(title);

            TextView content = new TextView(this);
            content.setText(note.getContent());
            content.setTextSize(18);
            content.setPadding(0, 24, 0, 0);
            layout.addView(content);
        } else {
            TextView error = new TextView(this);
            error.setText("Nota não encontrada.");
            layout.addView(error);
        }
        setContentView(layout);
    }
}
