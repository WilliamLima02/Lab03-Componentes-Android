package ao.co.isptec.aplm.simplenotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListNotesActivity extends Activity {
    private LinearLayout notesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 32, 24, 24);

        TextView title = new TextView(this);
        title.setText("Minhas notas");
        title.setTextSize(24);
        layout.addView(title);

        notesContainer = new LinearLayout(this);
        notesContainer.setOrientation(LinearLayout.VERTICAL);
        layout.addView(notesContainer, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));

        Button newNote = new Button(this);
        newNote.setText("New Note");
        newNote.setOnClickListener(v ->
                startActivity(new Intent(this, CreateNoteActivity.class)));
        layout.addView(newNote);

        setContentView(layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }

    private void showNotes() {
        notesContainer.removeAllViews();
        for (int i = 0; i < NoteRepository.getAll().size(); i++) {
            final int position = i;
            Button noteButton = new Button(this);
            noteButton.setText(NoteRepository.get(position).getTitle());
            noteButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, ReadNoteActivity.class);
                intent.putExtra("note_position", position);
                startActivity(intent);
            });
            notesContainer.addView(noteButton);
        }
    }
}
