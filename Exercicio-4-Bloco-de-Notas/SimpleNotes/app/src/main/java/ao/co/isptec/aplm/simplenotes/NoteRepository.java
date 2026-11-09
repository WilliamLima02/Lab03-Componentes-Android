package ao.co.isptec.aplm.simplenotes;

import java.util.ArrayList;
import java.util.List;

public final class NoteRepository {
    private static final List<Note> notes = new ArrayList<>();

    private NoteRepository() { }

    public static void add(Note note) { notes.add(note); }
    public static List<Note> getAll() { return notes; }
    public static Note get(int position) { return notes.get(position); }
}
