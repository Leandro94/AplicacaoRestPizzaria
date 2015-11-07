/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.PizzaDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelo.Pizza;

/**
 * REST Web Service
 *
 * @author Leandro
 */
@Path("pizzaria")
public class PizzariaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PizzariaWS
     */
    public PizzariaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.PizzariaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
  
        return "REST do foda-se";
    }
    
    @GET
    @Produces("application/json")
    @Path("Pizza/get/{id}")
    public String getPizza(@PathParam("id") int id) 
    {
        Pizza p = new Pizza();
        p.setId(id);
        
        PizzaDAO pizzaDao = new PizzaDAO();
        p = pizzaDao.buscar(p);
        
        //converter para gson
        Gson g = new Gson();
        return g.toJson(p);  
    }
    @GET
    @Produces("application/json")
    @Path("Pizza/list")
    public String listaPizzas() {
        
        List <Pizza> lista;
        PizzaDAO pizzaDao =  new PizzaDAO();
        lista = pizzaDao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
       
    }
    

    /**
     * PUT method for updating or creating an instance of PizzariaWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
