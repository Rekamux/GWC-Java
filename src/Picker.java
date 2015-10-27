import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Picker
{
    private static String _path = "json/";
    private static String _listName = "list.json";
    private static String _pickedName = "picked.json";
    private static String _notPickedName = "notPicked.json";

    private enum FileType
    {
        List, Picked, NotPicked
    };

    private EnumMap<FileType, File> _files =
        new EnumMap<FileType, File>(FileType.class);

    static String getFileName(FileType type) throws Exception
    {
        switch (type)
        {
        case List:
            return _listName;
        case Picked:
            return _pickedName;
        case NotPicked:
            return _notPickedName;
        default:
            throw new Exception("Invalid type passed");
        }
    }

    static String getFilePath(FileType type) throws Exception
    {
        return _path + getFileName(type);
    }

    /**
     * @return true if created
     */
    private boolean createFile(FileType ft) throws Exception
    {
        String path = getFilePath(ft);
        File file = new File(path);
        boolean created = false;

        if (!file.exists())
        {
            if (ft == FileType.List)
            {
                throw new Exception("Can't find " + path);
            }
            else
            {
                if (!file.createNewFile())
                {
                    throw new Exception("Can't create " + path);
                }
                created = true;
            }
        }

        _files.put(ft, file);

        return created;
    }

    private JSONObject tryParse(FileType ft) throws Exception
    {
        File file = _files.get(ft);
        JSONObject jo = (JSONObject) JSONValue.parse(new FileReader(file));

        if (jo == null)
        {
            throw new Exception("Cannot parse " + getFilePath(ft));
        }

        return jo;
    }

    private void verifyFile(FileType ft, boolean justCreated) throws Exception
    {
        if (justCreated)
        {
            if (ft == FileType.List)
            {
                throw new Exception("Cannot have created " + ft.toString());
            }
            else if (ft == FileType.NotPicked)
            {
                JSONObject jo = tryParse(FileType.List);
                writeFile(ft, jo);
            }
        }
        else
        {
            tryParse(ft);
        }
    }

    private void writeFile(FileType ft, JSONObject object) throws IOException
    {
        FileWriter fw = new FileWriter(_files.get(ft));
        object.writeJSONString(fw);
        fw.close();
    }

    public Picker() throws Exception
    {
        for (FileType ft : FileType.values())
        {
            verifyFile(ft, createFile(ft));
        }
    }

    public class Pick
    {
        public String name;
        public int index;

        public Pick(String name, int index)
        {
            this.name = name;
            this.index = index;
        }

        @Override
        public String toString()
        {
            return name + " (" + index + " : " + Integer.toBinaryString(index)
                + ")";
        }

        public String getKey()
        {
            return Integer.toString(index);
        }
    }

    @SuppressWarnings("unchecked")
    public Pick pick() throws Exception
    {
        FileType ftnp = FileType.NotPicked;
        JSONObject jonp = tryParse(ftnp);
        int size = jonp.size();
        FileType ftp = FileType.Picked;
        JSONObject jop = tryParse(ftp);

        if (size == 0)
        {
            System.err.println("Error:  " + ftnp.toString() + " is empty!");
            return null;
        }

        Random r = new Random();
        int arrayIndex = r.nextInt(size);
        Object key = jonp.keySet().toArray()[arrayIndex];
        String name = (String) jonp.get(key);

        jonp.remove(key);
        jop.put(key, name);

        writeFile(ftnp, jonp);
        writeFile(ftp, jop);

        return new Pick(name, Integer.decode((String) key));
    }

    @SuppressWarnings("unchecked")
    public void unpick(Pick pick) throws Exception
    {
        FileType ftnp = FileType.NotPicked;
        JSONObject jonp = tryParse(ftnp);
        FileType ftp = FileType.Picked;
        JSONObject jop = tryParse(ftp);

        if (jop.remove(pick.getKey()) == null)
        {
            throw new Exception("Failed to unpick " + pick);
        }
        jonp.put(pick.index, pick.name);

        writeFile(ftnp, jonp);
        writeFile(ftp, jop);
    }

    private int size(FileType ft) throws Exception
    {
        JSONObject jo = tryParse(ft);
        return jo.size();
    }

    public int getPickedSize() throws Exception
    {
        return size(FileType.Picked);
    }

    public int getNotPickedSize() throws Exception
    {
        return size(FileType.NotPicked);
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Presentation picker, do you want to pick? (Y/n)");
        if (scan.next().charAt(0) == 'Y')
        {
            Picker picker = new Picker();
            Picker.Pick pick = picker.pick();
            System.out.println(pick);
        }
        else
        {
            System.out.println("Aborted");
        }
        scan.close();
    }
}
