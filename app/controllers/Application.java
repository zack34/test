package controllers;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.Task;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	final static Form<Task> formTodo = Form.form(Task.class);
	public static final String NS_FOAF = "http://xmlns.com/foaf/0.1/";

	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
     
    
   /*
    public static Result submitInscForm() {
    	Form<User>  filledform=formuser.bindFromRequest();
    	User created = filledform.get();
    	return ok(SubmitFormInsc.render(created));
    }
   */
    
    //-------------------------------Methodes-----------------------------------------------
    
    
    public static Result submitTodo()
    {
    	Task todo = formTodo.bindFromRequest().get();
    	Task.createTodo(todo);
      //return TODO;
                return redirect(routes.Application.listTodos("visiteur"));
    }
    
    
 /*
    le mettre en comentaire pr le moments
  */
    
    public static Result listTodos(String username)
    {
            List<Task> todos ;
            if(username.equals("visiteur"))
                    todos = Task.all();
      
            else
                    todos = Task.findByUsername(username);
            if(request().accepts("text/html"))
                    return ok(Form_Todo.render(todos, "bonjour " + username, formTodo));
            else if(request().accepts("application/json"))
                    return ok(Json.toJson(todos));
            else if (request().accepts("application/rdf+xml"))
            {
                    //creation des proprietes
                    /*
            	    Property firstname = model.createProperty( NS_FOAF + "firstName" );
                    Property familyName = model.createProperty( NS_FOAF + "familyName" );
                    Property nick = model.createProperty( NS_FOAF + "nick" );
                    Property name = model.createProperty( NS_FOAF + "name" );
                    
                    Resource person = model.createResource(personURI);
                    
                    person.addProperty(firstname, strgivenName);
                    person.addProperty(familyName, strfamilyName);
                    person.addProperty(nick, strnickName);
                    person.addProperty(name, strfullName);
                    
                    OutputStream out = new ByteArrayOutputStream();
                        
                        model.write(out, "RDF/XML-ABBREV");
                         
                 return ok(out.toString());
                */
            	return TODO;
            }
            return badRequest();
    }
 
   
        
}
