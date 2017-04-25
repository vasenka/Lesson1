/**
 * Class Note with properties <b>note</b> and <b>author</b>.
 * @autor Sitnikova Vasilisa
 * @version 1.0
 */
package task6;

public class Note {
    /** Note field */
    String note;
    /** Note author's field */
    String author;
    /**
     * Constructor - new object creation (with parameters)
     * @param note - note
     * @param author - note's author
     * @see task6.Note#Note(String, String)
     */
    Note(String note, String author) {
        this.note = note;
        this.author = author;
    }
    /**
     * Function of overriding of method toString
     * @return returns the note text and it's author's.
     */
    public String toString() {
        return note+"/@created by "+author;
    }

}