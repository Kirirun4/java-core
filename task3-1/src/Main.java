import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> paths = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        FileWriter out = null;
        File fTemp = null;

        paths.add("C:\\game\\res\\drawables");
        paths.add("C:\\game\\res\\icons");
        paths.add("C:\\game\\res\\vectors");
        paths.add("C:\\game\\savegames");
        paths.add("C:\\game\\src\\main");
        paths.add("C:\\game\\src\\test");
        paths.add("C:\\game\\temp");

        try {
            for (String s : paths) {
                File file = new File(s);
                if (file.mkdirs()) {
                    writeLog(tmp, file, true);
                    if (s.equals("C:\\game\\temp")) {
                        fTemp = new File(s + "/temp.txt");
                        if (fTemp.createNewFile()) {
                            writeLog(tmp, fTemp, true);
                        } else {
                            writeLog(tmp, fTemp, false);
                        }
                        out = new FileWriter(s + "\\temp.txt");
                    }
                } else {
                    writeLog(tmp, file, false);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fTemp != null) {
                if (out != null) {
                    out.write(tmp.toString());
                    out.close();
                }
            } else {
                System.out.println(tmp);
            }
        }
    }

    private static void writeLog(StringBuilder tmp, File file, boolean b) {
        tmp
                .append("\n")
                .append(b ? "" : "Ошибка! ")
                .append(file.isDirectory() ? "Директория " : "Файл: ")
                .append(file.getAbsolutePath())
                .append(b ? " - создан" : " - не создан");
    }
}
