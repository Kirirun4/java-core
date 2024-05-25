import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        String path = "C:\\game\\savegames";
        String tmp = "C:\\game\\temp\\temp.txt";
        String zip = "C:\\game\\savegames\\savegames.zip";

        File fTmp = new File(tmp);
        File dir = new File(path);
        List<GameProgress> gameProgresses = new ArrayList<>();

        //извлечение файлов из архива и запись лога в tmp = "C:\\game\\temp\\temp.txt"
        if (game.openZip(zip, path, tmp)) {
            System.out.println("Файлы извлечены из архива.");
        }

        //десерилизуем объекты
        for (File file: dir.listFiles()
        ) {
            if (file.getName().endsWith(".ser")) {
                gameProgresses.add(game.openProgress(file.getAbsolutePath()));
            }
        }

        for (GameProgress gameProgress: gameProgresses
        ) {
            System.out.println(gameProgress);
        }
    }
}
