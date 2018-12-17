package sample;

public class Moviest {

    public String title;
    public String director;
    public String actor;
    public int year;
    public String rating;
    public double viewers;

    Moviest (String title, String director, String actor, int year, String rating, double viewers) {
        this.title=title;
        this.director=director;
        this.actor=actor;
        this.year=year;
        this.rating=rating;
        this.viewers=viewers;
    }
    public String getInfoMovies () {
        String filx=("Фильм: " + title +"\n"+ " Режисер: " + director +"\n"+ " Актер: "+actor+"\n"+" Год: "+year+"\n"+" Рейтинг: "+rating+"\n"+" Просмотры: "+viewers+"\n");
        //System.out.println(filx);
        return filx;
    }
    public String getNewRating(String rating){
        this.rating=rating;
        String filn=("Фильм: " + title +"\n"+ " Режисер: " + director +"\n"+ " Актер: "+actor+"\n"+" Год: "+year+"\n"+" Рейтинг: "+rating+"\n"+" Просмотры: "+viewers+"\n");
        //System.out.println(filn);
        return filn;
    }
}

