package controllers;

import play.libs.Json;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;

import views.html.*;

import models.*;

/**
 * Manage a database of computers
 */
public class Application extends Controller   {

     private static Form<Project> projectForm = form(Project.class);
    

    @Transactional
    public static Result addProject(){
        Form<Project> form = projectForm.bindFromRequest();
        if ( form.hasErrors())
            return badRequest(form.errorsAsJson());

        Project project = form.get();
        project.save();
        return ok(Json.toJson(project));

    }
    
    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
        return ok( views.html.index.render() )  ;
    }

    @Transactional(readOnly=true)
    public static Result projects(){

        return ok(Json.toJson(Project.findAll()));
    }

    @Transactional()
    public static Result project(Long id){
        Form<Project> projectForm = form(Project.class).bindFromRequest();

        if ( !projectForm.hasErrors() ) {
            Project project = projectForm.get();
            project.update(id);
            return ok(Json.toJson(project));
        }
        else  {
            return badRequest(projectForm.errorsAsJson());
        }

    }

}
            
