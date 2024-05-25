import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        String path = "C:\\game\\savegames";
        String tmp = "C:\\game\\temp\\temp.txt";
        String zip = "C:\\game\\savegames\\savegames.zip";

        File fTmp = new File(tmp);
        ArrayList<GameProgress> gameProgresses = new ArrayList<>();

        //создание gameprogress
        gameProgresses.add(new GameProgress(10, 1, 2, 0.3));
        gameProgresses.add(new GameProgress(4, 2, 5, 0.6));
        gameProgresses.add(new GameProgress(3, 1, 4, 0.1));

        for (int i = 0; i < gameProgresses.size(); i++) {
            if (game.saveGame(path + "\\gameprogress" + (i + 1) + ".ser", gameProgresses.get(i))) {
                game.writeLog(tmp, "GameProgress сохранен в : " + path + "\\gameprogress" + (i + 1) + ".ser");
            }
            ;

        }

        //архивирование файлов
        File dir = new File(path);
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip));
        for (File file : dir.listFiles()
        ) {
            if (file.getName().endsWith(".ser")) {
                if (game.addToZip(zout, file)) {
                    game.writeLog(tmp, "Файл: " + file.getAbsolutePath() + " добавлен в архив: " + zip);
                }
            }
        }
        zout.close();

        //удаление файлов gameprogress
        for (File file : dir.listFiles()
        ) {
            if (!file.getName().endsWith(".zip")) {
                game.writeLog(tmp, "Файл: " + file.getAbsolutePath() + " - удален");
                if (file.delete()) {
                    System.out.println("файлы удвлены");
                }
            }
        }
    }
}
