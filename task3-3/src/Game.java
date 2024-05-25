import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Game {
        public void writeLog(String path, String rec) throws IOException {
        File log = new File(path);
        FileWriter out = new FileWriter(log, true);

        try {
            out.write("\n" + rec);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean openZip(String zipPath, String path, String tmpFile) {
        boolean result = false;
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                // получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(path + "\\" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
                //логирование
                writeLog(tmpFile, "Файл: " + name + "  извлечен из архива - " + zipPath);
            }
            result = true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public GameProgress openProgress(String path) {
        GameProgress gameProgress = null;
        // входной поток для чтения файла
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // десериализуем объект
            gameProgress = (GameProgress) ois.readObject();
            return gameProgress;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }

}

