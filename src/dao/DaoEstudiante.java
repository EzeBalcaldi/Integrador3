package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import esquemas.Estudiante;

public class DaoEstudiante {
	private EntityManagerFactory emf = null;
	
	public DaoEstudiante() {
		this.emf = Persistence.createEntityManagerFactory("Arqui");
	}
	
	//a) dar de alta un estudiante
	public void insertEstudiante(Estudiante estu) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(estu);
		em.getTransaction().commit();
	}
	
	//c) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple
	public List<Estudiante> recuperarEstudiantes(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		@SuppressWarnings("unchecked")
		List <Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e order by edad DESC").getResultList();
		return estudiantes;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	//d) recuperar un estudiante, en base a su n�mero de libreta universitaria
	public Estudiante estudianteSegunLibreUniversitaria(int numLibreta){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		Query query = em.createQuery("SELECT e from Estudiante e where numero_libreta = :numero_libreta");
		query.setParameter("numero_libreta", numLibreta);
		@SuppressWarnings("unchecked")
		Estudiante estudiante = (Estudiante) query.getSingleResult();
		return estudiante;
		}
		catch(Exception e){
			return null;
		}
	}
	
	//e) recuperar todos los estudiantes, en base a su g�nero
	public List<Estudiante> estudianteSegunGenero(String genero){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		Query query = em.createQuery("SELECT e from Estudiante e where genero = :genero");
		query.setParameter("genero", genero);
		@SuppressWarnings("unchecked")
		List <Estudiante> estudiantes = query.getResultList();
		return estudiantes;
		}
		catch(Exception e){
			return null;
		}
	}
	
	//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	public List<Estudiante> estudianteSegunCarreraCiudad(int idCarrera, String ciudad){
		EntityManager em = emf.createEntityManager();
		try {
		Query query =  em.createQuery("SELECT ec.estudiante from Estudiante_Carrera ec join ec.estudiante e  join ec.carrera c where e.ciudad_residencia = :ciudad_residencia and c.id = :id ");
		query.setParameter("ciudad_residencia", ciudad);
		query.setParameter("id", idCarrera);
		@SuppressWarnings("unchecked")
		List <Estudiante> carreras = (List<Estudiante>) query.getResultList();
		return carreras;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	
	
	
}
