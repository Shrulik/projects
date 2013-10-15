package controllers;

import play.api.templates.Html;
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


    /**
     * Handle default path requests, redirect to computers list
     */
    public static Result index() {
        return TODO;
    }



}
            
