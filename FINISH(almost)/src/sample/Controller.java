package sample;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import  java.io.*;
import java.util.Date;
import java.util.ArrayList;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button search;

    @FXML
    private Button limpo;

    @FXML
    private Button gosto;

    @FXML
    private Button ButRat;


    @FXML
    private Button DELL;

    @FXML
    private TextField MyActor;

    @FXML
    private TextField Films;

    @FXML
    private TextField nrat;

    @FXML
    private TextArea textinfo;

    @FXML
    void initialize()throws ParseException {

        BufferedReader br = null;

        Scanner name = new Scanner(System.in);
        ArrayList<Moviest> Movie=new ArrayList<>(15);

        Movie.add(0, new Moviest("Зеленая миля", "Фрэнк Дарабонт", "Том Хенкс", 1999, "9", 80));
        Movie.add(1,new Moviest("Одиннадцать друзей Оушена", "Стивен Содерберг", "Джордж Клуни", 2001, "8.1", 82));
        Movie.add(2, new Moviest("Побег из Шоушенка", "Фрэнк Дарабонт", "Морган Фриман", 1994, "9.5", 91));
        Movie.add(3, new Moviest("1+1", "Оливье Накаш, Эрик Толедано", "Омар Си", 2011, "9", 75));
        Movie.add(4,new Moviest("Назад в будущее", "Роберт Земекис", "Майкл Дж. Фокс", 1985, "9", 96));
        Movie.add(5, new Moviest("Поймай меня, если сможешь", "Стивен Спилберг", "Леонардо ДиКаприо", 2002, "9", 96));
        Movie.add(6, new Moviest("В погоне за счастьем", "Габриэле Муччино", "Уилл Смит", 2006, "8.5", 67));
        Movie.add(7, new Moviest("Титаник", "Джеймс Кэмерон", "Леонардо ДиКаприо", 1997, "9.5", 97));
        Movie.add(8, new Moviest("Аватар", "Джеймс Кэмерон", "Сэм Уортингтон", 2009, "9.9", 98));
        Movie.add(9, new Moviest("Мстители: Война бесконечности", "Энтони Руссо, Джо Руссо", "Роберт Дауни мл.", 2018, "9.7", 97));
        Movie.add(10, new Moviest("Чёрная Пантера", "Райан Куглер", "Чедвик Боузман", 2018, "9.8", 97));
        Movie.add(11,new Moviest("Тёмный рыцарь: Возрождение легенды", "Кристофер Нолан", "Кристиан Бейл", 2012, "8.8", 87));
        Movie.add(12,new Moviest("Стражи Галактики. Часть 2", "Джеймс Ганн", "Крис Пратт", 2017, "9", 95));
        Movie.add(13, new Moviest("Скайфолл", "Сэм Мендес", "Дэниел Крэйг", 2012, "8.4", 83));
        Movie.add(14, new Moviest("Первый мститель: Противостояние", "Энтони Руссо, Джо Руссо", "Крис Эванс", 2016, "8.7", 92));
        Movie.add(15, new Moviest("Тор: Рагнарёк", "Тайка Вайтити", "Крис Хемсворт", 2017, "9", 96));
        Movie.add(16, new Moviest("Гарри Поттер и Дары Смерти 2.", "Дэвид Йейтс", "Дэниел Рэдклифф", 2011, "8.6", 95));
        Movie.add(17, new Moviest("Заклятие", "Джеймс Ван", "Вера Фармига", 2013, "9.7", 95));



        try {
            File filex = new File("FILMS.txt");
            if (!filex.exists()) {
                filex.createNewFile();
            }
            PrintWriter pw = new PrintWriter(filex);
            for(int i=0;i<Movie.size();i++){
                pw.println(Movie.get(i).getInfoMovies());
            }
            pw.close();

            br = new BufferedReader(new FileReader("FILMS.txt"));
            String line;
            while((line = br.readLine())!=null){System.out.println(line);}

        } catch (IOException e) {
            System.out.println("Error" + e);
        }finally {
            try{
                br.close();
            }catch (IOException e){System.out.println("Error" + e);}
        }


        System.out.println("\nВывести названия фильмов, вышедших на экран за последние 3 года:\n");

        for(int i=0;i<Movie.size();i++){
            if(Movie.get(i).year>2015){System.out.println(Movie.get(i).getInfoMovies());}
            else {}
        }

        System.out.println("Вывести названия всех фильмов, в которых снимался данный актёр:\n");
        String act = name.nextLine();
        for(int i=0;i<Movie.size();i++) {
            if (Movie.get(i).actor.equals(act)) {
                System.out.println( Movie.get(i).getInfoMovies());
            } else {}
        }

        System.out.println("Вывести фамилию режиссёра, снявшего указанный фильм: \n");
        String dir = name.nextLine();
        for(int i=0;i<Movie.size();i++) {
            if (Movie.get(i).title.equals(dir)) {
                System.out.println( Movie.get(i).getInfoMovies());
            }
        }

        System.out.println("Введите название фильма :");
        String fil = name.nextLine ();
        System.out.println("Установите новый рейтинг фильму :");
        String rat = name.nextLine ();
        for(int i=0;i<Movie.size();i++){
            if(Movie.get(i).title.equals(fil)){
                System.out.println(Movie.get(i).getNewRating(rat));
            }
            else {}
        }
        search.setOnAction(event -> {

            String actors= MyActor.getText();
            String films= Films.getText();

            for(int i=0;i<Movie.size();i++){
                if(Movie.get(i).actor.equals(actors)){textinfo.appendText("\n"+Movie.get(i).getInfoMovies());}
                else {}

                if(Movie.get(i).title.equals(films)){textinfo.appendText("\n"+Movie.get(i).getInfoMovies());}
                else {}
            }
        });

        gosto.setOnAction(event->{
            String films= Films.getText();

            for(int i=0;i<Movie.size();i++) {
                if(Movie.get(i).title.equals(films)){
                    textinfo.appendText("\n"+Movie.get(i).title+"\n Мы рады что вы оценили это кино!\n Нам этот Фильм тоже нравится! ");
                }
                else {}
            }
        });


        ButRat.setOnAction(event->{
            String like= nrat.getText();
            String films= Films.getText();

            for(int i=0;i<Movie.size();i++) {
                if(Movie.get(i).title.equals(films)){
                    textinfo.appendText("\n"+Movie.get(i).getNewRating(like)+"\n Вы только что добавили новый рейтинг фильму!");
                }
                else {}
            }
        });

        DELL.setOnAction(event -> {
            String films= Films.getText();

            for(int i=0;i<Movie.size();i++) {
                if (Movie.get(i).title.equals(films)) {
                     Movie.remove(i).getInfoMovies();
                } else {}
            }
        });

        limpo.setOnAction(event->{
            textinfo.clear();
        });


    }
}
