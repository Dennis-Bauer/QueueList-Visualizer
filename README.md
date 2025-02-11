# **Queue List Visualizer (German)** 

Ein Visualisierungstool für Wateschlangen-Listen, programmiert in **Java** mit **JavaFX**.  

## **Funktionen**  

- **Visualisierung der Zeiger**: Es werden die zwei Zeiger (**First**, **Last**) gezeigt.
- **Keine sichtbaren Werte in den Nodes**: Werte, beim First-zeiger, werden erst vollständig sichtbar, wenn `front()` aufgerufen wird.  
- **Voreingestellte Test-Liste**: Eine vorgefertigte Liste kann genutzt und bearbeitet werden.  
- **Erstellung neuer Listen**:  
  - Leere Liste  
  - Liste mit einem initialen Element  
- **Methodennamen als Button-Beschriftungen**: Die Buttons sind exakt so benannt wie die Methoden.  
- **Eingabe über Input-Box**: Werte werden aus der Input-Box entnommen.  
- **Anpassbare Darstellung** in der `Main`-Klasse:  
  - **Fenstergröße**  
  - **Schriftart und Schriftgröße**  
  - **Farben der Pfeile**  
- **Integer-Liste**: Standardmäßig sind Zahlen auf **3 Ziffern begrenzt** (anpassbar in `Main`).  

## **Methoden**  

### `enqueue(Content)`  
Fügt das **Element ans Ende** der Liste hinzu (`Content` aus der Input-Box).  

### `dequeue()`  
Löscht das **Element, am anfang**.

### `front()`  
Macht die gespeicherte Zahl, auf dem der First-Zeiger steht, in der **List-View heller**.  

### `isEmpty()`  
Gibt `true` zurück, wenn die Liste **leer** ist.  

---

Diese **Queue-List Visualisierung** bietet eine intuitive Möglichkeit, das Verhalten einer **Warteschlangen-Liste** zu verstehen und zu testen. 

---

# **Queue List Visualizer (English)**  

A visualization tool for linked lists, programmed in **Java** with **JavaFX**.  

## **Features**  

- **Current Pointer Display**: Only the node where the **Current pointer** is located is visible.  
- **Pointer Visualization**: The three pointers (**Current**, **First**, **Last**) are displayed.  
- **No visible values in the nodes**: Values at the Current pointer are only fully visible when `getContent()` is called.  
- **Predefined Test List**: A predefined list can be used and modified.  
- **Creating New Lists**:  
  - Empty list  
  - List with an initial element  
- **Method names as button labels**: The buttons are named exactly as the methods.  
- **Input via Input Box**: Values are taken from the input box.  
- **Customizable Display** in the `Main` class:  
  - **Window size**  
  - **Font style and size**  
  - **Arrow colors**  
- **Integer List**: By default, numbers are limited to **3 digits** (configurable in `Main`).  

## **Methods**  

### `next()`  
Moves the **Current pointer** to the next node. If it reaches the end, it is set to `null`. If `Current == null`, nothing happens.  

### `toFirst()`  
Sets the **Current pointer** to the first element. If the list is empty, `Current` remains `null`.  

### `toLast()`  
Sets the **Current pointer** to the last element. If the list is empty, `Current` remains `null`.  

### `append(Content)`  
Adds the **element to the end** of the list (`Content` from the input box).  

### `insert(Content)`  
Inserts an **element right next to** the Current pointer (`Content` from the input box).  

### `remove()`  
Deletes the **element at the Current pointer**. If `Current == null`, nothing happens.  

### `hasCurrentAccess()`  
Returns `true` if `Current` is **not null**, otherwise `false`. The result is displayed in the **Output label**.  

### `setContent(Content)`  
Changes the **value of the current node** (`Content` from the input box). If `Current == null`, nothing happens.  

### `getContent()`  
Makes the stored number in the **List-View lighter** when `Current` points to a valid node.  

### `isEmpty()`  
Returns `true` if the list is **empty**.  

---

This **Linked List Visualization** provides an intuitive way to understand and test the behavior of a **linked list**.

# **Example Pictures (Beispiel Bilder)**  
<img width="790" alt="List_normalView" src="https://github.com/user-attachments/assets/226676b7-6cba-4af7-be69-1b58dfbfd6a8" />
<img width="790" alt="List_CreateNewListView" src="https://github.com/user-attachments/assets/baa75520-8557-4167-ab63-bbdd86b9a1c1" />
<img width="789" alt="List_1Element_Current-Null_IsEmpty-False" src="https://github.com/user-attachments/assets/f238c367-aa5a-45f6-a9e9-9f870789129a" />
