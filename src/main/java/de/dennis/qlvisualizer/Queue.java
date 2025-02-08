package de.dennis.qlvisualizer;

import de.dennis.qlvisualizer.Panes.ListView;
import javafx.scene.control.ScrollPane;


public class Queue extends ScrollPane {

    private final ListView LIST_VIEW = new ListView();

    private int listLength;

    private ListElement first;
    private ListElement last;

    public Queue(ListElement firstElement) {
        setContent(LIST_VIEW);

        addFirstElement(firstElement);
    }

    public Queue() {
        setContent(LIST_VIEW);

        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setMinHeight(Main.WINDOW_HEIGHT * 0.35);


        listLength = 0;

        first = null;
        last = null;
    }

    public void append(ListElement e) {
        if (last == null ) addFirstElement(e);
        else if (last.getNext() == null) {
            listLength++;

            if (first == last) last.getGraphicObject().setPosArrowToFirst();
            else last.getGraphicObject().setPosArrowVisible(false);

            last.setNext(e);
            last = e;

            e.getGraphicObject().setPosArrowToLast();
            e.getGraphicObject().setPosArrowVisible(true);

            LIST_VIEW.addNode(e, listLength);
        }
        else throw new IllegalCallerException("Das 'Nächste Element' vom letztem Element, ist nicht Null! So kann es nicht das letzte Element sein!");
    }

    public void insert(ListElement e) {
        if (last == null && first == null) addFirstElement(e);
        else {
            if (current != null) {
                listLength++;

                e.setNext(current.getNext());
                current.setNext(e);

                if (current == last) {
                    last.getGraphicObject().setPosArrowVisible(false);
                    last = e;
                    last.getGraphicObject().setPosArrowToLast();
                    last.getGraphicObject().setPosArrowVisible(true);
                }

                LIST_VIEW.addNode(e, currentPos);
            } // Sonst eigentlich, fehler schmeißen
        }
    }

    public void remove() {
        if (current != null) {
            ListElement previous = getPreviousElement();
            if (previous != null) {
                listLength--;

                if (current == last) {
                    last = previous;
                    last.setNext(null);

                    last.getGraphicObject().setPosArrowToLast();
                    last.getGraphicObject().setPosArrowVisible(true);

                    current = null;

                    LIST_VIEW.removeNode(currentPos + 1);
                } else {
                    previous.setNext(current.getNext());

                    LIST_VIEW.removeNode(currentPos + 1);


                    current = current.getNext();
                    current.getGraphicObject().setCurrentArrowVisible(true);
                }
            } else {
                first = first.getNext();

                if (first != null) {
                    first.getGraphicObject().setPosArrowVisible(true);
                    first.getGraphicObject().setPosArrowToFirst();

                    current = current.getNext();
                    if (current != null) current.getGraphicObject().setCurrentArrowVisible(true);

                    LIST_VIEW.removeNode(1);
                } else {
                    LIST_VIEW.removeNode(1);

                    current = null;
                    first = null;
                    last = null;
                }

            }
        }
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    private void addFirstElement(ListElement e) {
        listLength = 1;

        first = e;
        last = e;

        e.getGraphicObject().setPosArrowToBoth();
        e.getGraphicObject().setPosArrowVisible(true);

        LIST_VIEW.addNode(e, 1);
    }

}
