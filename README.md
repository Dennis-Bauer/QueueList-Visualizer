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

A visualization tool for queue lists, programmed in **Java** with **JavaFX**.  

## **Features**  

- **Pointer visualization**: Displays the two pointers (**First**, **Last**).  
- **No visible values in the nodes**: Values at the First pointer become fully visible only when `front()` is called.  
- **Predefined test list**: A prebuilt list can be used and modified.  
- **Creation of new lists**:  
  - Empty list  
  - List with an initial element  
- **Method names as button labels**: Buttons are named exactly like the methods.  
- **Input via input box**: Values are taken from the input box.  
- **Customizable display** in the `Main` class:  
  - **Window size**  
  - **Font and font size**  
  - **Arrow colors**  
- **Integer list**: By default, numbers are **limited to 3 digits** (customizable in `Main`).  

## **Methods**  

### `enqueue(Content)`  
Adds the **element to the end** of the list (`Content` from the input box).  

### `dequeue()`  
Removes the **first element** of the list.  

### `front()`  
Highlights the stored number at the **First pointer** in the list view.  

### `isEmpty()`  
Returns `true` if the list is **empty**.  

---

This **Queue List Visualization** provides an intuitive way to understand and test the behavior of a **queue list**.  

---

# **Example Pictures (Beispiel Bilder)**  

<img width="788" alt="QV-Startscreen" src="https://github.com/user-attachments/assets/8489504d-c8d9-4635-be9c-94906014a8e7" />
<img width="790" alt="QV-ListView+Function" src="https://github.com/user-attachments/assets/dfb19e28-192a-4a4d-8c51-dcc4e2f0ea15" />
<img width="793" alt="QV-ListView" src="https://github.com/user-attachments/assets/9ca4147d-8110-43b5-8f95-eb29d9cf10f8" />
