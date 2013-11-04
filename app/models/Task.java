package models;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Task extends Model {

	@Id
	public Long id;
	
	public Date date;
	public String Label;
	
	
public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);
	
	public static List<Task> all()
	{
		//return find.all();
		return find.findList();
	}
	
	public static List<Task> findByUsername(String username)
	{
		return find.where().eq("username", username).findList();
	}
	
	public static Task createTodo(Task todo)
	{
		todo.date = new Date();
		todo.save();
    	return todo;
	}

	
	public static List<Task> findNext(int from, int nb)
	{
		return find.setFirstRow(from).setMaxRows(nb).findList();
	}
	
}

