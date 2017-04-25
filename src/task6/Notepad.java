/**
 * Class Notepad with properties <b>notepad</b> and <b>SIZE</b>.
 * @autor Sitnikova Vasilisa
 * @version 1.0
 */

package task6;

import java.util.Scanner;

public class Notepad {
    /** The field Notepad (which is array) */
    Note[] notepad;
    /** The field notepad's size (max quantity of possible notes) */
    private static final int SIZE = 1000;

    /**
     * Constructor - new object creation
     * @see task6.Notepad#Notepad()
     */
    public Notepad() {
        this.notepad = new Note[SIZE];
    }
    /**
     * Function of getting reference value
     * @return returns the name of person who is adding or editing notes.
     */
    String signature() {
        System.out.println("Enter your name ===>");
        Scanner inAuthor = new Scanner(System.in);
        String author = inAuthor.nextLine();
        return author;
    }
    /**
     * Procedure of getting operation value
     */
    void operation() {
        System.out.println("Enter operation (add|delete|edit|notes|exit) ===>");
        Scanner inOperation = new Scanner(System.in);
        String operation = inOperation.next();

        if (operation.equals("add")) {
            addNote();
        } else if (operation.equals("notes")) {
            allNotes();
        } else if (operation.equals("delete")) {
            delNote();
        } else if (operation.equals("edit")) {
            changeNote();
        } else if (operation.equals("exit")) {
            System.out.println("End of session");
        } else {
            System.out.println("Error: no such operation");
        }

    }
    /**
     * @param idOfNote - number of note in the notepad
     * @param numberOfDeletedNotes - quantity of notes that were deleted
     * @param author - note's author
     */
    int idOfNote = 0;
    int numberOfDeletedNotes = 0;
    String author;
    /**
     * Procedure of adding the note to the notepad
     */
    void addNote() {

        if (idOfNote<SIZE) {
            author = signature();
            System.out.println("New note: ");
            Scanner inNewNote = new Scanner(System.in);
            String newNote = inNewNote.nextLine();
            Note note = new Note(newNote, author);
            notepad[idOfNote] = note;
            System.out.println(note);
            idOfNote++;
            operation();
        } else if (numberOfDeletedNotes>0) {
            Note[] newNotepad = new Note[notepad.length];

            int i=0;
            int j=0;
            while ((i<notepad.length)&(j<notepad.length)) {
                if (notepad[j] != null) {
                    newNotepad[i] = notepad[j];
                    i++;
                }
                j++;
            }
            idOfNote--;

            notepad = newNotepad;
            String author = signature();
            System.out.println("New note: ");
            Scanner inNewNote = new Scanner(System.in);
            String newNote = inNewNote.nextLine();
            Note note = new Note(newNote, author);
            notepad[idOfNote] = note;
            System.out.println(note);
            idOfNote++;
            operation();
        } else {
            System.out.println("Error: notepad is full. You should delete some notes to continue adding");
            operation();
        }
    }
    /**
     * Procedure of all notes outputting
     */
    void allNotes() {
        for (int i=0;i<notepad.length;i++) {
            if (notepad[i]!=null) {
                System.out.println(notepad[i]);
            }
        }
        operation();
    }
    /**
     * Procedure of note deleting
     * It should be done with ArrayList...
     */
    void delNote() {
        System.out.println("Enter note id to delete: ");
        Scanner inDel = new Scanner(System.in);
        int id = inDel.nextInt();
        notepad[id] = null;
        numberOfDeletedNotes++;
        System.out.println("Deleted!");
        operation();
    }
    /**
     * Procedure of note editing
     */
    void changeNote() {
        System.out.println("Enter note id to edit: ");
        Scanner inCh = new Scanner(System.in);
        int idCh = inCh.nextInt();

        System.out.println("Enter your name ===>");
        Scanner inAuthor = new Scanner(System.in);
        String author = inAuthor.nextLine();

        System.out.println("Edit: ");
        Scanner inEdit = new Scanner(System.in);
        String editNote = inEdit.nextLine();
        Note editN = new Note(editNote, author);
        notepad[idCh] = editN;

        System.out.println("Replaced with: " + editN);
        operation();
    }

}
