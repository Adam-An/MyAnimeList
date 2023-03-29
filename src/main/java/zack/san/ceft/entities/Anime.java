package zack.san.ceft.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import zack.san.ceft.annotation.Rating;


@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "enter title pls")
    private String title;

    @Rating
    private String rating;

    private String imageUrl;

    @Size(max = 50, message = "Comment should be maximum 50 characters")
    private String comment;

    public Anime() {
    }

    public Anime(Integer id, String title, String rating, String priority, String comment) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.imageUrl = priority;
        this.comment = comment;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String priority) {
        this.imageUrl = priority;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
