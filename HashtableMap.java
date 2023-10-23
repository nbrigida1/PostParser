// --== CS400 Project One File Header ==--
// Name: Nicholas Brigida
// CSL Username: brigida
// Email: brigida@wisc.edu
// Lecture #: Lec 3 1:20-2:10
// Notes to Grader: <any optional extra notes to your grader>
import java.util.NoSuchElementException;
@SuppressWarnings("unchecked")
public class HashtableMap<KeyType,ValueType> implements MapADT<KeyType,ValueType>{

    private int capacity;
    private int size;
    protected KeyValuePair[] table;
    public HashtableMap(int capacity)
    {
        table = new KeyValuePair[capacity];
        this.capacity = capacity;

    }
    public HashtableMap() // with default capacity = 8
    {
        table = new KeyValuePair[8];
        this.capacity = 8;
    }

    @Override
    public void put(KeyType key, ValueType value) throws IllegalArgumentException {
        if(key == null || containsKey(key))
        {
            throw new IllegalArgumentException("Error, key is either null or duplicate");
        }
        int index = (Math.abs(key.hashCode()))%capacity;
        if(table[index] == null || table[index].getKey().equals("rem"))
        {
            table[index] = new KeyValuePair(key, value);
        }
        else {
            for (int i = index+1; i != index; i++) {
                if(i >= capacity)
                {
                    i = 0;
                }
                if(table[i] == null)
                {
                    table[i] = new KeyValuePair(key, value);
                    break;
                }
            }
        }
        this.size ++;
        double dbSize = (double)(size);
        double dbCapac = (double)(capacity);
//        System.out.println(dbSize/dbCapac);

        //Rehashing
        if((dbSize/dbCapac)>= .7)
        {
            KeyValuePair[] newTable = new KeyValuePair[2*capacity];
            KeyValuePair[] oldTable = table;
            table = newTable;
            int oldCapacity = capacity;
            capacity = 2*capacity;
            this.size=0;
            for (int i = 0; i < oldCapacity; i++) {
                if(oldTable[i] != null && oldTable[i].getKey() != null && !oldTable[i].getKey().equals("rem"))
                {
                    put((KeyType) oldTable[i].getKey(), (ValueType) oldTable[i].getValue());
                }
            }

//            KeyValuePair[] newTable = new KeyValuePair[2*capacity];
//            for (int i = 0; i < capacity; i++) {
//                newTable[i] = table[i];
//            }
//            table = newTable;
//            capacity = 2*capacity;
        }
    }

    @Override
    public boolean containsKey(KeyType key) {
        boolean keyInTable = false;
        for (int i = 0; i < capacity; i++) {
            if(table[i]!= null && table[i].getKey().equals(key))
            {
                keyInTable = true;
            }
        }
        return keyInTable;
    }

    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        int startingIndex = (Math.abs(key.hashCode()))%capacity;
        for (int i = 0; i < table.length; i++) {
            if(table[i]!= null && table[i].getKey().equals(key))
            {
                return (ValueType)table[i].getValue();
            }
        }
        throw new NoSuchElementException("No such element exists for that key");
    }

    @Override
    public ValueType remove(KeyType key) throws NoSuchElementException {
        int index = (Math.abs(key.hashCode()))%capacity;
        KeyValuePair returned = table[index];
        if(returned == null)
        {
            throw new NoSuchElementException("No such element exists for that key");
        }
        table[index] = new KeyValuePair<>("rem", "rem");
        size--;
        return (ValueType) returned.getValue();
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            if(table[i]!= null)
            {
                table[i] = null;
            }
        }
        this.size= 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}


