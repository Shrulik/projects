package controllers;

import play.libs.Json;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.db.jpa.*;

import models.*;

/**
 * Manage a database of computers
 */
public class Application extends Controller   {

     private static Form<Project> projectForm = form(Project.class);

    
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

    @Transactional
    public static Result addProject(){
        Form<Project> boundForm = projectForm.bindFromRequest();

        if ( boundForm.hasErrors())
            return badRequest(boundForm.errorsAsJson());

        Project project = boundForm.get();
        project.save();
        return ok(Json.toJson(project));

    }

    @Transactional()
    public static Result updateProject(Long id){
        Form<Project> boundForm = projectForm.bindFromRequest();

        if ( boundForm.hasErrors() )
            return badRequest(boundForm.errorsAsJson());

        Project project = boundForm.get();
        project.update(id);
        return ok(Json.toJson(project));
    }

}
            
