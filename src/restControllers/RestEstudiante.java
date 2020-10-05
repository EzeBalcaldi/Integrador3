package restControllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import esquemas.Carrera;
import esquemas.Estudiante;
import restControllers.Lector;

@Path("/estudiante")
public class RestEstudiante {
	
//	//a) dar de alta un estudiante
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void altaDeEstudiante(Estudiante e){
		Lector.estudiante.insertEstudiante(e);
	}
	
	//c) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple.
	@GET
	@Path("/recuperarEstudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> recuperarEstudiantes(){
	    return Lector.estudiante.recuperarEstudiantes();
	}
	
	//d) recuperar un estudiante, en base a su n�mero de libreta universitaria.
	@GET
	@Path("/estudianteSegunLibreUniversitaria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante estudianteSegunLibreUniversitaria(@PathParam("id") int num){
	    return Lector.estudiante.estudianteSegunLibreUniversitaria(num);
	}
	
	//e) recuperar todos los estudiantes, en base a su g�nero.
	@GET
	@Path("/estudianteSegunGenero/{genero}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> estudianteSegunGenero(@PathParam("genero") String genero){
	    return Lector.estudiante.estudianteSegunGenero(genero);
	}
	
	//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	@GET
	@Path("/estudianteSegunCarreraCiudad/{carrera}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> estudianteSegunCarreraCiudad(@PathParam("carrera") int carrera,@PathParam("ciudad") String ciudad){
	    return Lector.estudiante.estudianteSegunCarreraCiudad(carrera,ciudad);
	}
	
	
}
