package models;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Content {
	private int id;
	private String title;
	private String brief;
	private Date datecreate;
//	private DateTimeFormatter datecreate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	
	
	public Content(String title, String brief, Date datecreate) {
		super();
		this.title = title;
		this.brief = brief;
		this.datecreate = datecreate;
	}
	public Content(int id, String title, String brief, Date datecreate) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.datecreate = datecreate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Date getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}
	
	
	
}
