package controllers;

import models.Project;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;


public class Application extends Controller {


    public static Result index() {
       return TODO;
    }


    @Transactional(readOnly = true)
    public static Result projects() {
        return ok(Json.toJson(Project.findAll()));
    }


    @Transactional
    public static Result addProject(){
        Form<Project> boundForm = form(Project.class).bindFromRequest();

        if ( boundForm.hasErrors())
            return badRequest(boundForm.errorsAsJson());


        Project project = boundForm.get();
        project.save();

        return ok(Json.toJson(project));

    }

    @Transactional()
    public static Result updateProject(Long id){
        Form<Project> boundForm = form(Project.class).bindFromRequest();

        if ( boundForm.hasErrors() )
            return badRequest(boundForm.errorsAsJson());

        Project project = boundForm.get();
        project.update(id);
        return ok(Json.toJson(project));
    }

}
            
