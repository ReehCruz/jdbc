package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("Marcos");
		userposjava.setEmail("marcos@gmail.com");
		
		userPosDao.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		
		try {
			Userposjava userposjava = dao.buscar(5L);
			System.out.println(userposjava);
			System.out.println("----------------------------------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDao dao = new UserPosDao();
			Userposjava objetoBanco = dao.buscar(5L);
			objetoBanco.setNome("Nome mudado com metodo atualizar");
		
			dao.atualizar(objetoBanco);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void initDeletar() {
		try {	
			UserPosDao dao = new UserPosDao();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(11)3230-0343");
		telefone.setTipo("Trabalho");
		telefone.setUsuario(2L);
		
		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
		
		
	}
	
	@Test
	public void testeCarregaFonesUser() {
		UserPosDao dao = new UserPosDao();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------");
		}
	
	}
	
	@Test
	public void testeDeleteUserFone() {

		UserPosDao dao = new UserPosDao();
		dao.deleteFonesPorUser(5L);

	}
}
