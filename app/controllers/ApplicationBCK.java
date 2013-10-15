package controllers;

import models.Project;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

/**
 * Manage a database of computers
 */
public class ApplicationBCK extends Controller   {



    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
        return ok( views.html.index.render("bla") )  ;
    }



    @Transactional(readOnly=true)
    public static Result projects(){

        return ok(Json.toJson(Project.findAll()));
    }


    private static Form<Project> projectForm = form(Project.class);

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
            
