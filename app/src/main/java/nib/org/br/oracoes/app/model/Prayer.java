package nib.org.br.oracoes.app.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Niege Costa Fonseca on 06/02/2016.
 */
@DatabaseTable(tableName = "prayer")
public class Prayer {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private String answer;

    @DatabaseField
    private String dateTime;

    @DatabaseField
    private Boolean isPrayed;

    public Prayer(){}

    public Prayer(String title, String description, String answer, String dateTime, boolean isPrayed){
        this.setAnswer(answer);
        this.setDescription(description);
        this.setTitle(title);
        this.setDateTime(dateTime);
        this.setIsPrayed(isPrayed);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Boolean getIsPrayed() {
        return isPrayed;
    }

    public void setIsPrayed(Boolean isPrayed) {
        this.isPrayed = isPrayed;
    }
}
